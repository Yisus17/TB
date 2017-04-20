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

public class OriginAccountActivity extends BaseActivity {
    ListView transferOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.origin_account);
        transferOptions = (ListView) findViewById(R.id.lst_account_options);

        List<MenuPair> options = new ArrayList<>();
        options.add(new MenuPair(getString(R.string.txt_account_type_1), GlobalConstants.ACCOUNT_TYPE_1));
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
}
