package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;
import com.tekknow.bicentenario.tbcomplus.model.MenuPair;

import java.util.ArrayList;
import java.util.List;


public class TransferTypeActivity extends AppCompatActivity {

    ListView transferOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_own_transfer_type);

        transferOptions = (ListView) findViewById(R.id.lst_transfer_options);
        List<MenuPair> options = new ArrayList<>();
        options.add(new MenuPair(getString(R.string.txt_transfer_type_1), GlobalConstants.ACCOUNT_TYPE_1));
        options.add(new MenuPair(getString(R.string.txt_account_type_2), GlobalConstants.ACCOUNT_TYPE_2));

        ArrayAdapter<MenuPair> adapter = new ArrayAdapter<MenuPair>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options);
        transferOptions.setAdapter(adapter);

        transferOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuPair option = (MenuPair) transferOptions.getItemAtPosition(position);
                setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.ACCOUNT_TYPE, option.getValue()));
                finish();
            }
        });
    }

    public void cancel(View view) {
        setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.EXTRA_STATUS, GlobalConstants.STATUS_CANCEL));
        finish();
    }

}