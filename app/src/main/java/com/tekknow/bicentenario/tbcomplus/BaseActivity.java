package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public abstract class BaseActivity extends AppCompatActivity {

    protected static final int DISPLAY_MESSAGE_REQUEST = 1;
    protected static final int USER_CARD_REQUEST = 2;
    protected static final int USER_PIN_REQUEST = 3;
    protected static final int CUSTOMER_CARD_REQUEST = 4;
    protected static final int CUSTOMER_PIN_REQUEST = 5;
    protected static final int HOST_REQUEST = 6;
    protected static final int ACCOUNT_TYPE_REQUEST = 7;
    protected static final int AMOUNT_TYPE_REQUEST = 8;
    protected static final int TRANSFER_TYPE_REQUEST = 9;
    protected static final int PAYMENT_TYPE_REQUEST = 10;
    protected static final int CARD_TYPE_REQUEST = 11; //FIXME Solo para el Prototipo
    protected static final int CUSTOMER_CI_REQUEST = 12;
    protected static final int CUSTOMER_EMAIL_REQUEST = 13;
    protected static final int SALE_AMOUNT_REQUEST = 14;
    protected static final int ORIGIN_ACCOUNT_REQUEST=15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void displayMessage(Bundle data) { //Desplegar mensaje
        Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
        if (data != null) {
            intent.putExtras(data);
        }
        startActivityForResult(intent, DISPLAY_MESSAGE_REQUEST);
    }

    protected void displayMessage() { //Desplegar mensaje por defecto
        displayMessage(null);
    }

    protected void requestUserCard() { //Lectura de la tarjeta del CNB
        Intent intent = new Intent(getApplicationContext(), UserCardReadActivity.class);
        startActivityForResult(intent, USER_CARD_REQUEST);
    }

    protected void requestCustomerCard() { //Lectura de la tarjeta del Cliente
        Intent intent = new Intent(getApplicationContext(), CustomerCardReadActivity.class);
        startActivityForResult(intent, CUSTOMER_CARD_REQUEST);
    }

    protected void requestUserPin() { //Ingreso del pin del CNB
        Intent intent = new Intent(getApplicationContext(), UserPinEntryActivity.class);
        startActivityForResult(intent, USER_PIN_REQUEST);
    }

    protected void requestCustomerPin() { //Ingreso del pin del Cliente
        Intent intent = new Intent(getApplicationContext(), CustomerPinEntryActivity.class);
        startActivityForResult(intent, CUSTOMER_PIN_REQUEST);
    }

    protected void requestCustomerCI(){
        Intent intent = new Intent(getApplicationContext(), CustomerCIEntryActivity.class);
        startActivityForResult(intent, CUSTOMER_CI_REQUEST);
    }

    protected void requestCustomerEmail(){
        Intent intent = new Intent(getApplicationContext(), CustomerEmailEntryActivity.class);
        startActivityForResult(intent, CUSTOMER_EMAIL_REQUEST);
    }

    protected void requestSaleAmount(){
        Intent intent = new Intent(getApplicationContext(), SaleAmountActivity.class);
        startActivityForResult(intent, SALE_AMOUNT_REQUEST);
    }

    protected void sendHostRequest(Bundle data) { //Solicitud al host
        Intent intent = new Intent(getApplicationContext(), HostRequestActivity.class);
        if (data != null) {
            intent.putExtras(data);
        }
        startActivityForResult(intent, HOST_REQUEST);
    }

    protected void sendHostRequest() { //Solicitud al host por defecto
        sendHostRequest(null);
    }

    protected void selectAccountType() { //Pantalla para seleccionar tipo de cuenta (ahorro o corriente)
        Intent intent = new Intent(getApplicationContext(), AccountTypeActivity.class);
        startActivityForResult(intent, ACCOUNT_TYPE_REQUEST);
    }

    protected void selectAmountType(Bundle data) {
        Intent intent = new Intent(getApplicationContext(), AmountTypeActivity.class);
        if (data != null) {
            intent.putExtras(data);
        }
        startActivityForResult(intent, AMOUNT_TYPE_REQUEST);
    }

    protected void selectAmountType() { //Pantalla para seleccionar el monto a pagar (parcial, total, otro)
        selectAmountType(null);
    }

    //FIXME Solo para el Prototipo
    protected void selectCardType() { //Pantalla para seleccionar el tipo de tarjeta (credito/debito)
        Intent intent = new Intent(getApplicationContext(), CardTypeActivity.class);
        startActivityForResult(intent, CARD_TYPE_REQUEST);
    }

    protected void selectPaymentType() { //Pantalla para seleccionar el tipo de pago (efectivo, cargo en cuenta)
        Intent intent = new Intent(getApplicationContext(), PaymentTypeActivity.class);
        startActivityForResult(intent, PAYMENT_TYPE_REQUEST);
    }

    protected void selectTransferType() { //Pantalla para seleccionar el tipo de transferencia
        Intent intent = new Intent(getApplicationContext(), TransferTypeActivity.class);
        startActivityForResult(intent, TRANSFER_TYPE_REQUEST);
    }
    protected void selectOriginAccount() { //Pantalla para seleccionar cuenta origen transferencia
        Intent intent = new Intent(getApplicationContext(), OriginAccountActivity.class);
        startActivityForResult(intent, ORIGIN_ACCOUNT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int status = data.getIntExtra(GlobalConstants.EXTRA_STATUS, GlobalConstants.STATUS_OK);

        if(status == GlobalConstants.STATUS_CANCEL){
            setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.EXTRA_STATUS, GlobalConstants.STATUS_CANCEL));
            finish();
        }else{
            switch (requestCode) {
                case ACCOUNT_TYPE_REQUEST:
                    onAccountTypeSelectResult(status, data.getExtras());
                    break;
                case AMOUNT_TYPE_REQUEST:
                    onAmountTypeSelectResult(status, data.getExtras());
                    break;
                case CARD_TYPE_REQUEST: //FIXME Solo para el Prototipo
                    onCardTypeSelectResult(status, data.getExtras());
                    break;
                case CUSTOMER_CARD_REQUEST:
                    onCustomerCardRequestResult(status, data.getExtras());
                    break;
                case CUSTOMER_CI_REQUEST:
                    onCustomerCIRequestResult(status, data.getExtras());
                    break;
                case CUSTOMER_EMAIL_REQUEST:
                    onCustomerEmailRequestResult(status, data.getExtras());
                    break;
                case CUSTOMER_PIN_REQUEST:
                    onCustomerPinRequestResult(status, data.getExtras());
                    break;
                case DISPLAY_MESSAGE_REQUEST:
                    onDisplayMessageResult(status, data.getExtras());
                    break;
                case HOST_REQUEST:
                    onHostRequestResult(status, data.getExtras());
                    break;
                case PAYMENT_TYPE_REQUEST:
                    onPaymentTypeSelectResult(status, data.getExtras());
                    break;
                case SALE_AMOUNT_REQUEST:
                    onSaleAmountRequestResult(status, data.getExtras());
                    break;
                case TRANSFER_TYPE_REQUEST:
                    onTransferTypeRequestResult(status, data.getExtras());
                    break;
                case ORIGIN_ACCOUNT_REQUEST:
                    onOriginAccountRequestResult(status, data.getExtras());
                    break;
                case USER_CARD_REQUEST:
                    onUserCardRequestResult(status, data.getExtras());
                    break;
                case USER_PIN_REQUEST:
                    onUserPinRequestResult(status, data.getExtras());
                    break;
            }
        }
    }

    protected void onAccountTypeSelectResult(int status, Bundle data) {}

    protected void onAmountTypeSelectResult(int status, Bundle data) {}

    //FIXME Solo para el Prototipo
    protected void onCardTypeSelectResult(int status, Bundle data) {}

    protected void onCustomerCardRequestResult(int status, Bundle data) {}

    protected void onCustomerCIRequestResult(int status, Bundle extras) {}

    protected void onCustomerEmailRequestResult(int status, Bundle extras) {}

    protected void onCustomerPinRequestResult(int status, Bundle data) {}

    protected void onDisplayMessageResult(int status, Bundle data) {}

    protected void onHostRequestResult(int status, Bundle data) {}

    protected void onPaymentTypeSelectResult(int status, Bundle data) {}

    protected void onSaleAmountRequestResult(int status, Bundle extras) {}

    protected void onTransferTypeRequestResult(int status, Bundle data) {}

    protected void onOriginAccountRequestResult(int status, Bundle data) {}

    protected void onUserCardRequestResult(int status, Bundle data) {}

    protected void onUserPinRequestResult(int status, Bundle data) {}

    public void onReturn(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {}

}