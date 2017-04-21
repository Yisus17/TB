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

public class CardTypeActivity extends BaseActivity {

    ListView accountOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_type);

        accountOptions = (ListView) findViewById(R.id.lst_card_options);

        List<MenuPair> options = new ArrayList<>();
        options.add(new MenuPair(TDD, CARD_TDD));
        options.add(new MenuPair(TDC, CARD_TDC));

        ArrayAdapter<MenuPair> adapter = new ArrayAdapter<MenuPair>(this, android.R.layout.simple_list_item_1, android.R.id.text1, options);
        accountOptions.setAdapter(adapter);

        accountOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuPair option = (MenuPair) accountOptions.getItemAtPosition(position);
                setResult(RESULT_OK, new Intent().putExtra(CARD_TYPE, option.getValue()));
                finish();
            }
        });
    }
}
