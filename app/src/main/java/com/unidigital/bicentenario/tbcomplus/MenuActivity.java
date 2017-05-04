package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unidigital.bicentenario.tbcomplus.model.MenuOption;

import java.util.ArrayList;
import java.util.List;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class MenuActivity extends BaseActivity {

    public static final String MENU_CATEGORY_ID = "com.tekknow.bicentenario.tbcomplus.MENU_CATEGORY_ID";
    public static final String MENU_CATEGORY_TITLE = "com.tekknow.bicentenario.tbcomplus.MENU_CATEGORY_TITLE";

    protected static final int MENU_REQUEST = 1;

    ListView menuOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        menuOptions = (ListView) findViewById(R.id.lst_menu_options);

        final String categoryId = getIntent().getStringExtra(MENU_CATEGORY_ID);
        List<MenuOption> options = getMenuOptions(categoryId);

        ArrayAdapter<MenuOption> adapter = new ArrayAdapter<MenuOption>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options);
        menuOptions.setAdapter(adapter);

        menuOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MenuOption option = (MenuOption) menuOptions.getItemAtPosition(position);

            if (option.getActivity() != null) {
                Intent intent = new Intent(getApplicationContext(), option.getActivity());
                startActivityForResult(intent, MENU_REQUEST);
            } else if (option.getCategoryId() != null) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra(MENU_CATEGORY_ID, option.getCategoryId());
                intent.putExtra(EXTRA_TITLE, option.getTitle());
                startActivityForResult(intent, MENU_REQUEST);
            }
            }
        });
    }

    private List<MenuOption> getMenuOptions(String category) {
        List<MenuOption> options = new ArrayList<>();

        switch (category) {
            case "POS":
                options.add(new MenuOption(getString(R.string.menu_sales), SaleActivity.class));
                options.add(new MenuOption(getString(R.string.title_activity_void), VoidActivity.class));
                options.add(new MenuOption(getString(R.string.menu_last_query_info), LastQueryInfoActivity.class));
                options.add(new MenuOption(getString(R.string.menu_pos_closure), PosClosureActivity.class));
                break;
            case "CNB":
                options.add(new MenuOption(getString(R.string.menu_withdrawal), WithdrawalActivity.class));
                options.add(new MenuOption(getString(R.string.menu_deposits), DepositActivity.class));
                options.add(new MenuOption(getString(R.string.menu_transfers), "TRANSFERENCIAS"));
                options.add(new MenuOption(getString(R.string.menu_internal_payments), "PAGOS_INTERNOS"));
                options.add(new MenuOption(getString(R.string.menu_external_payments), "PAGOS_EXTERNOS"));
                options.add(new MenuOption(getString(R.string.menu_queries), ""));
                options.add(new MenuOption(getString(R.string.menu_reverses), ReverseActivity.class));
                break;
            case "CONTROL":
                options.add(new MenuOption(getString(R.string.menu_total_queries), ""));
                options.add(new MenuOption(getString(R.string.menu_transaction_queries), ""));
                options.add(new MenuOption(getString(R.string.menu_operation_temporal_closure), OperationTemporalClosureActivity.class));
                //options.add(new MenuOption("Reapertura de Operaciones", OperationReopenActivity.class));
                options.add(new MenuOption(getString(R.string.menu_operation_closure), OperationClosureActivity.class));
                break;
            case "TRANSFERENCIAS":
                options.add(new MenuOption(getString(R.string.title_activity_transfer_own_account), TransferOwnAccountActivity.class));
                options.add(new MenuOption(getString(R.string.title_activity_transfer_third), TransferThirdActivity.class));
                break;
            case "PAGOS_INTERNOS":
                options.add(new MenuOption(getString(R.string.title_activity_creditcard_payment), CreditCardPaymentActivity.class));
                options.add(new MenuOption(getString(R.string.title_activity_microcredit_payment), MicrocreditPaymentActivity.class));
                break;
            case "PAGOS_EXTERNOS":
                options.add(new MenuOption(getString(R.string.title_activity_cantv_payment), CantvPaymentActivity.class));
                options.add(new MenuOption(getString(R.string.title_activity_directv_payment), DirectvPaymentActivity.class));
                options.add(new MenuOption(getString(R.string.title_activity_movilnet_payment), MovilnetPaymentActivity.class));
                options.add(new MenuOption(getString(R.string.title_activity_saren_payment), SarenPaymentActivity.class));
                options.add(new MenuOption(getString(R.string.title_activity_stanhome_payment), StanhomePaymentActivity.class));
                options.add(new MenuOption(getString(R.string.title_activity_movilnet_recharge), MovilnetRechargeActivity.class));
                break;
        }

        return options;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_menu;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int status = data.getIntExtra(EXTRA_STATUS, STATUS_OK);

        if(status != STATUS_BACK){
            setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, status));
            finish();
        }
    }
}