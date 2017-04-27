package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public abstract class TransactionActivity extends BaseActivity {

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
    protected static final int ORIGIN_ACCOUNT_REQUEST = 15;
    protected static final int SIGNATURE_REQUEST = 16;
    protected static final int REVERSE_SURE_REQUEST = 17;
    protected static final int REVERSE_INFO_DATA_REQUEST = 18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //---- Plantilla para llamar request ----
    protected void sendRequest(Class activity, int tag, Bundle data){
        String title = getBarTitle();
        Intent intent = new Intent(getApplicationContext(), activity);

        if (data == null) {
            data = new Bundle();
        }

        data.putString(EXTRA_TITLE, title);
        intent.putExtras(data);

        startActivityForResult(intent, tag);
    }

    //---- Desplegar mensaje ----
    protected void displayMessage(Bundle data) {
        sendRequest(DisplayMessageActivity.class, DISPLAY_MESSAGE_REQUEST, data);
    }

    protected void displayMessage() { //Desplegar mensaje por defecto
        displayMessage(null);
    }


    //---- Lectura de la tarjeta del CNB ----
    protected void requestUserCard(Bundle data) {
        sendRequest(UserCardReadActivity.class, USER_CARD_REQUEST, data);
    }

    protected void requestUserCard() { //Desplegar mensaje por defecto
        requestUserCard(null);
    }


    //---- Lectura de la tarjeta del Cliente ----
    protected void requestCustomerCard(Bundle data) {
        sendRequest(CustomerCardReadActivity.class, CUSTOMER_CARD_REQUEST, data);
    }

    protected void requestCustomerCard() {
        requestCustomerCard(null);
    }


    //---- Ingreso del pin del CNB ----
    protected void requestUserPin(Bundle data) {
        sendRequest(UserPinEntryActivity.class, USER_PIN_REQUEST, data);
    }

    protected void requestUserPin() {
        requestUserPin(null);
    }

    //---- Ingreso del pin del Cliente ----
    protected void requestCustomerPin(Bundle data) {
        sendRequest(CustomerPinEntryActivity.class, CUSTOMER_PIN_REQUEST, data);
    }

    protected void requestCustomerPin() {
        requestCustomerPin(null);
    }

    //---- Ingreso de la cédula del cliente ----
    protected void requestCustomerCI(Bundle data){
        sendRequest(CustomerCIEntryActivity.class, CUSTOMER_CI_REQUEST, data);
    }

    protected void requestCustomerCI(){
        requestCustomerCI(null);
    }

    //---- Ingreso del correo electrónico del cliente ----
    protected void requestCustomerEmail(Bundle data){
        sendRequest(CustomerEmailEntryActivity.class, CUSTOMER_EMAIL_REQUEST, data);
    }

    protected void requestCustomerEmail(){
        requestCustomerEmail(null);
    }

    //---- Ingreso del monto de la Venta ----
    protected void requestSaleAmount(Bundle data){
        sendRequest(SaleAmountActivity.class, SALE_AMOUNT_REQUEST, data);
    }

    protected void requestSaleAmount(){
        requestSaleAmount(null);
    }

    //---- Solicitud al host ----
    protected void sendHostRequest(Bundle data) {
        sendRequest(HostRequestActivity.class, HOST_REQUEST, data);
    }

    protected void sendHostRequest() { //Solicitud al host por defecto
        sendHostRequest(null);
    }

    //---- Seleccion tipo de cuenta (ahorro o corriente) ----
    protected void selectAccountType(Bundle data) {
        sendRequest(AccountTypeActivity.class, ACCOUNT_TYPE_REQUEST, data);
    }

    protected void selectAccountType() {
        selectAccountType(null);
    }

    //---- Seleccion del monto a pagar (parcial, total, otro) ----
    protected void selectAmountType(Bundle data) {
        sendRequest(AmountTypeActivity.class, AMOUNT_TYPE_REQUEST, data );
    }

    protected void selectAmountType() {
        selectAmountType(null);
    }

    //---- Seleccion tipo de tarjeta (credito/debito) ----
    //FIXME Solo para el Prototipo
    protected void selectCardType(Bundle data) {
        sendRequest(CardTypeActivity.class, CARD_TYPE_REQUEST, data);
    }

    protected void selectCardType() {
        selectCardType(null);
    }

    //---- Seleccion tipo de pago (efectivo, cargo en cuenta) ----
    protected void selectPaymentType(Bundle data) {
        sendRequest(PaymentTypeActivity.class, PAYMENT_TYPE_REQUEST, data);
    }

    protected void selectPaymentType() {
        selectPaymentType(null);
    }

    //---- Seleccion tipo de transferencia (Propia/Terceros) ----
    protected void selectTransferType(Bundle data) {
        sendRequest(TransferTypeActivity.class, TRANSFER_TYPE_REQUEST, data);
    }

    protected void selectTransferType() {
        selectTransferType(null);
    }

    //---- Seleccion cuenta origen transferencia (Ahorro/Corriente) ----
    protected void selectOriginAccount(Bundle data) {
        sendRequest(OriginAccountActivity.class, ORIGIN_ACCOUNT_REQUEST, data);
    }

    protected void selectOriginAccount() {
        selectOriginAccount(null);
    }

    //---- Seleccion cuenta origen transferencia (Ahorro/Corriente) ----
    protected void requestSignature(Bundle data) {
        sendRequest(SignatureCaptureActivity.class, SIGNATURE_REQUEST, data);
    }

    protected void requestSignature() {
        requestSignature(null);
    }

    //---- Información de reverso ----
    protected void requestReverseInfoData(Bundle data) {
        sendRequest(ReverseInfoDataActivity.class, REVERSE_INFO_DATA_REQUEST, data);
    }

    protected void requestReverseInfoData() {
        requestReverseInfoData(null);
    }

    //---- Confirmacion de reverso ----
    protected void requestReverseSure(Bundle data) {
        sendRequest(ReverseSureActivity.class, REVERSE_SURE_REQUEST, data);
    }

    protected void requestReverseSure() {
        requestReverseSure(null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int status = data.getIntExtra(EXTRA_STATUS, STATUS_OK);

        switch (status) {
            case STATUS_CANCEL:
                onCancel();
                break;
            case STATUS_CLOSE:
                onClose();
                break;
            default:
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
                    case REVERSE_INFO_DATA_REQUEST:
                        onReverseInfoDataRequestResult(status, data.getExtras());
                        break;
                    case REVERSE_SURE_REQUEST:
                        onReverseSureRequestResult(status, data.getExtras());
                        break;
                    case SALE_AMOUNT_REQUEST:
                        onSaleAmountRequestResult(status, data.getExtras());
                        break;
                    case SIGNATURE_REQUEST:
                        onSignatureRequestResult(status, data.getExtras());
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

                break;
        }
    }

    //---- Metodos "abstractos" ----

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

    protected void onReverseInfoDataRequestResult(int status, Bundle data) {}

    protected void onReverseSureRequestResult(int status, Bundle data) {}

    protected void onSaleAmountRequestResult(int status, Bundle extras) {}

    protected void onSignatureRequestResult(int status, Bundle data) {}

    protected void onTransferTypeRequestResult(int status, Bundle data) {}

    protected void onOriginAccountRequestResult(int status, Bundle data) {}

    protected void onUserCardRequestResult(int status, Bundle data) {}

    protected void onUserPinRequestResult(int status, Bundle data) {}



}