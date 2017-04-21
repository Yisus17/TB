package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;
import com.tekknow.bicentenario.tbcomplus.model.MenuPair;

import java.util.ArrayList;
import java.util.List;

public class PaymentTypeActivity extends BaseActivity {

    ListView paymentOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_type);

        paymentOptions = (ListView) findViewById(R.id.lst_payment_options);

        List<MenuPair> options = new ArrayList<>();
        options.add(new MenuPair(getString(R.string.txt_payment_type_1), PAYMENT_TYPE_CASH));
        options.add(new MenuPair(getString(R.string.txt_payment_type_2), PAYMENT_TYPE_ACCOUNT));

        ArrayAdapter<MenuPair> adapter = new ArrayAdapter<MenuPair>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options);
        paymentOptions.setAdapter(adapter);

        paymentOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuPair option = (MenuPair) paymentOptions.getItemAtPosition(position);
                setResult(RESULT_OK, new Intent().putExtra(EXTRA_PAYMENT_TYPE, option.getValue()));
                finish();
            }
        });
    }
}