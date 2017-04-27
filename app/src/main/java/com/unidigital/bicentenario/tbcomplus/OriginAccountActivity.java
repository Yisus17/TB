package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;
import com.unidigital.bicentenario.tbcomplus.model.MenuPair;

import java.util.ArrayList;
import java.util.List;

public class OriginAccountActivity extends BaseActivity {
    ListView transferOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        transferOptions = (ListView) findViewById(R.id.lst_account_options);

        List<MenuPair> options = new ArrayList<>();
        options.add(new MenuPair(getString(R.string.txt_account_type_1), ACCOUNT_TYPE_1));
        options.add(new MenuPair(getString(R.string.txt_account_type_2), ACCOUNT_TYPE_2));

        ArrayAdapter<MenuPair> adapter = new ArrayAdapter<MenuPair>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options);
        transferOptions.setAdapter(adapter);

        transferOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuPair option = (MenuPair) transferOptions.getItemAtPosition(position);
                setResult(RESULT_OK, new Intent().putExtra(ACCOUNT_TYPE, option.getValue()));
                finish();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.origin_account;
    }
}
