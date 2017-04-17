package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tekknow.bicentenario.tbcomplus.model.MenuOption;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    public static final String MENU_CATEGORY_ID = "com.tekknow.bicentenario.tbcomplus.MENU_CATEGORY_ID";
    public static final String MENU_CATEGORY_TITLE = "com.tekknow.bicentenario.tbcomplus.MENU_CATEGORY_TITLE";

    ListView menuOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuOptions = (ListView) findViewById(R.id.lst_menu_options);

        String categoryId = getIntent().getStringExtra(MENU_CATEGORY_ID);
        String categoryTitle = getIntent().getStringExtra(MENU_CATEGORY_TITLE);

        TextView category = (TextView) findViewById(R.id.txt_category);
        category.setText(categoryTitle.toUpperCase());

        List<MenuOption> options = getMenuOptions(categoryId);

        ArrayAdapter<MenuOption> adapter = new ArrayAdapter<MenuOption>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options);
        menuOptions.setAdapter(adapter);

        menuOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MenuOption option = (MenuOption) menuOptions.getItemAtPosition(position);

            if (option.getActivity() != null) {
                Intent intent = new Intent(getApplicationContext(), option.getActivity());
                startActivity(intent);
            } else if (option.getCategoryId() != null) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra(MENU_CATEGORY_ID, option.getCategoryId());
                intent.putExtra(MENU_CATEGORY_TITLE, option.getTitle());
                startActivity(intent);
            }
            }
        });
    }


    private List<MenuOption> getMenuOptions(String category) {
        List<MenuOption> options = new ArrayList<>();

        switch (category) {
            case "POS":
                options.add(new MenuOption("Ventas", SaleActivity.class));
                options.add(new MenuOption("Devoluciones", ""));
                options.add(new MenuOption("Consulta de Ultimo Movimiento", LastQueryInfoActivity.class));
                options.add(new MenuOption("Cierre de POS", ClosePosActivity.class));
                break;
            case "CNB":
                options.add(new MenuOption("Retiros", WithdrawalActivity.class));
                options.add(new MenuOption("Depósitos", DepositActivity.class));
                options.add(new MenuOption("Transferencias", "TRANSFERENCIAS"));
                options.add(new MenuOption("Pagos Internos", "PAGOS_INTERNOS"));
                options.add(new MenuOption("Pagos Externos", "PAGOS_EXTERNOS"));
                options.add(new MenuOption("Consultas", ""));
                break;
            case "CONTROL":
                options.add(new MenuOption("Consulta de Totales", ""));
                options.add(new MenuOption("Consulta de Transacciones", ""));
                options.add(new MenuOption("Cierre Temporal de Operaciones", TemporalOperationsClosureActivity.class));
                options.add(new MenuOption("Reapertura de Operaciones", ""));
                options.add(new MenuOption("Cierre de Operaciones", OperationsClosureActivity.class));
                break;
            case "TRANSFERENCIAS":
                options.add(new MenuOption("Transferencias Cuenta Propias", TransferOwnAccountActivity.class));
                options.add(new MenuOption("Transferencias a Terceros", ""));
                break;
            case "PAGOS_INTERNOS":
                options.add(new MenuOption("Pago de TDC", ""));
                options.add(new MenuOption("Pago de Microcrédito", ""));
                break;
            case "PAGOS_EXTERNOS":
                options.add(new MenuOption("Pago CANTV", ""));
                options.add(new MenuOption("Pago Movilnet Postpago", ""));
                options.add(new MenuOption("Recarga Movilnet", ""));
                options.add(new MenuOption("SAREN", ""));
                options.add(new MenuOption("DirecTV", ""));
                break;
        }

        return options;
    }

    public void onReturn(View view) {
        finish();
    }



}