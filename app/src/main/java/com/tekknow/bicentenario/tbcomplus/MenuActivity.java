package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tekknow.bicentenario.tbcomplus.model.MenuOption;

import java.util.ArrayList;
import java.util.List;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

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

    @Override
    protected int getLayout() {
        return R.layout.activity_menu;
    }


    private List<MenuOption> getMenuOptions(String category) {
        List<MenuOption> options = new ArrayList<>();

        switch (category) {
            case "POS":
                options.add(new MenuOption("Venta", SaleActivity.class));
                options.add(new MenuOption("Devolución", ""));
                options.add(new MenuOption("Consulta de Ultimo Movimiento", LastQueryInfoActivity.class));
                options.add(new MenuOption("Cierre de POS", PosClosureActivity.class));
                break;
            case "CNB":
                options.add(new MenuOption("Retiro", WithdrawalActivity.class));
                options.add(new MenuOption("Depósito", DepositActivity.class));
                options.add(new MenuOption("Transferencias", "TRANSFERENCIAS"));
                options.add(new MenuOption("Pagos Internos", "PAGOS_INTERNOS"));
                options.add(new MenuOption("Pagos Externos", "PAGOS_EXTERNOS"));
                options.add(new MenuOption("Consultas", ""));
                options.add(new MenuOption("Reversos", ReverseActivity.class));
                break;
            case "CONTROL":
                options.add(new MenuOption("Consulta de Totales", ""));
                options.add(new MenuOption("Consulta de Transacciones", ""));
                options.add(new MenuOption("Cierre Temporal de Operaciones", OperationTemporalClosureActivity.class));
                //options.add(new MenuOption("Reapertura de Operaciones", OperationReopenActivity.class));
                options.add(new MenuOption("Cierre de Operaciones", OperationClosureActivity.class));
                break;
            case "TRANSFERENCIAS":
                options.add(new MenuOption("Transferencia Cuentas Propias", TransferOwnAccountActivity.class));
                options.add(new MenuOption("Transferencia a Terceros", TransferThirdActivity.class));
                break;
            case "PAGOS_INTERNOS":
                options.add(new MenuOption("Pago de TDC", CreditCardPaymentActivity.class));
                options.add(new MenuOption("Pago de Microcrédito", MicrocreditPaymentActivity.class));
                break;
            case "PAGOS_EXTERNOS":
                options.add(new MenuOption("Pago CANTV", CantvPaymentActivity.class));
                options.add(new MenuOption("Pago DIRECTV", DirectvPaymentActivity.class));
                options.add(new MenuOption("Pago Movilnet Postpago", MovilnetPaymentActivity.class));
                options.add(new MenuOption("Pago SAREN", SarenPaymentActivity.class));
                options.add(new MenuOption("Pago Stanhome", StanhomePaymentActivity.class));
                options.add(new MenuOption("Recarga Movilnet", MovilnetRechargeActivity.class));
                break;
        }

        return options;
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