package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.*;
import android.widget.Toast;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public abstract class BaseActivity extends AppCompatActivity {
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent()!= null && getIntent().getStringExtra(EXTRA_TITLE) != null){
            title = getIntent().getStringExtra(EXTRA_TITLE);
        }else{
            title = getBarTitle();
        }

        setContentLayout(getLayout());
    }

    public void onAccept() {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_OK));
        finish();
    }

    public void onReturn() {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_BACK));
        finish();
    }

    public void onCancel() {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_CANCEL));
        finish();
    }

    public void onClose(){
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_CLOSE));
        finish();
    }

    public void onAccept(View view) {
        onAccept();
    }

    public void onReturn(View view){
        onReturn();
    }

    public void onCancel(View view){
        onCancel();
    }

    @Override
    public void onBackPressed() {}

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_home:
                onCancel();// Volver al home
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected abstract int getLayout();

    protected String getBarTitle(){
        return getString(R.string.app_name);
    }

    public void setContentLayout(int layout){
        if(layout != -1){
            setContentView(layout);

            Toolbar myToolbar = (Toolbar) findViewById(R.id.appbar);
            myToolbar.setLogo(R.drawable.icono_bicentenario);

            TextView mTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
            mTitle.setText(title);

            setSupportActionBar(myToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    public Toast setCustomToast(String Text, int layout){ //Metodo para crear un custom toast
        RelativeLayout holder = null;
        TextView customText;

        switch (layout){
            case TOAST_LIMITES_MONTOS:
                holder= (RelativeLayout) getLayoutInflater().inflate(R.layout.custom_toast_amout_limits,(RelativeLayout) findViewById(R.id.rell));
                break;
        }
        customText = (TextView) holder.findViewById(R.id.textViewCustomToast);

        customText.setText(Text);
        final Toast t = new Toast(getApplicationContext());
        t.setGravity(Gravity.CENTER,0,0);
        t.setDuration(Toast.LENGTH_SHORT);
        t.setView(holder);

        return t;
    }

    /*******Manejo de inactividad del usuario para colocar banner publicitario**********/
    public static final long DISCONNECT_TIMEOUT = 60000; //1000 = 1 segundo
    private Handler disconnectHandler = new Handler(){
        public void handleMessage(Message msg) {
        }
    };

    private Runnable disconnectCallback = new Runnable() {
        @Override
        public void run() {
            Intent myIntent = new Intent(BaseActivity.this, BannerActivity.class);
            BaseActivity.this.startActivity(myIntent);

        }
    };

    public void resetDisconnectTimer(){
        disconnectHandler.removeCallbacks(disconnectCallback);
        disconnectHandler.postDelayed(disconnectCallback, DISCONNECT_TIMEOUT);
    }

    public void stopDisconnectTimer(){
        disconnectHandler.removeCallbacks(disconnectCallback);
    }

    @Override
    public void onUserInteraction(){
        resetDisconnectTimer();
    }

    @Override
    public void onResume() {
        super.onResume();
        resetDisconnectTimer();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopDisconnectTimer();
    }

    /************************************************************************/


}
