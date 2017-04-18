package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;
import com.tekknow.bicentenario.tbcomplus.model.MenuPair;

import java.util.ArrayList;
import java.util.List;

public class AccountTypeActivity extends GenericActivity {

    ListView accountOptions;
    Intent result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);

        result = new Intent();

        accountOptions = (ListView) findViewById(R.id.lst_account_options);

        List<MenuPair> options = new ArrayList<>();
        options.add(new MenuPair(getString(R.string.txt_account_type_1), GlobalConstants.ACCOUNT_TYPE_1));
        options.add(new MenuPair(getString(R.string.txt_account_type_2), GlobalConstants.ACCOUNT_TYPE_2));

        ArrayAdapter<MenuPair> adapter = new ArrayAdapter<MenuPair>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options);
        accountOptions.setAdapter(adapter);

        accountOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuPair option = (MenuPair) accountOptions.getItemAtPosition(position);
                result.putExtra(GlobalConstants.ACCOUNT_TYPE, option.getValue());
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }

}