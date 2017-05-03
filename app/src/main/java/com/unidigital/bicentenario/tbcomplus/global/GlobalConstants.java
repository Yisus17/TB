package com.unidigital.bicentenario.tbcomplus.global;

public class GlobalConstants {

    public static final String EXTRA_ACCOUNT_MODE = "com.tekknow.bicentenario.tbcomplus.extra.ACCOUNT_MODE";
    public static final String EXTRA_AMOUNT_TYPE = "com.tekknow.bicentenario.tbcomplus.extra.AMOUNT_TYPE";
    public static final String EXTRA_MESSAGE_CONTENT = "com.tekknow.bicentenario.tbcomplus.extra.MESSAGE_CONTENT";
    public static final String EXTRA_MESSAGE_TYPE = "com.tekknow.bicentenario.tbcomplus.extra.MESSAGE_TYPE";
    public static final String EXTRA_PAYMENT_TYPE = "com.tekknow.bicentenario.tbcomplus.extra.PAYMENT_TYPE";
    public static final String EXTRA_REQUEST_CODE = "com.tekknow.bicentenario.tbcomplus.extra.REQUEST_CODE";
    public static final String EXTRA_STATUS = "com.tekknow.bicentenario.tbcomplus.extra.STATUS";
    public static final String EXTRA_MODALITY = "com.tekknow.bicentenario.tbcomplus.extra.MODALITY";
    public static final String EXTRA_TITLE = "com.tekknow.bicentenario.tbcomplus.extra.TITLE";
    public static final String EXTRA_SEQUENCE_NUMBER = "com.tekknow.bicentenario.tbcomplus.extra.SEQUENCE_NUMBER";

    public static final int ACCOUNT_MODE_RETURN = 1;
    public static final int ACCOUNT_MODE_CANCEL = 2;

    public static final int AMOUNT_TYPE_BALANCE = 1;
    public static final int AMOUNT_TYPE_FIXED = 2;

    public static final String CARD_TYPE = "CARD_TYPE";
    public static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";

    public static final String TDD = "Tarjeta de Débito";
    public static final String TDC = "Tarjeta de Crédito";
    public static final int CARD_TDD = 1; //Debito
    public static final int CARD_TDC = 2; //Credito

    public static final int ACCOUNT_TYPE_1 = 1; //Ahorro
    public static final int ACCOUNT_TYPE_2 = 2; //Corriente

    public static final int MESSAGE_TYPE_SUCCESS = 1;
    public static final int MESSAGE_TYPE_INFO = 2;
    public static final int MESSAGE_TYPE_WARNING = 3;
    public static final int MESSAGE_TYPE_ERROR = 4;

    public static final int MODALITY_START_OPERATIONS = 1;
    public static final int MODALITY_AUTHENTICATE_OPERATIONS = 2;
    public static final int MODALITY_REOPEN_OPERATIONS = 3;


    public static final int PAYMENT_TYPE_CASH = 1;
    public static final int PAYMENT_TYPE_ACCOUNT = 2;

    public static final int STATUS_OK = 0;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_CANCEL = 2;
    public static final int STATUS_BACK = 3;
    public static final int STATUS_CLOSE = 4;

    public static final int TOAST_LIMITES_MONTOS=0;

    public static final int MIN_AMOUNT_WITHDRAWAL=1000; //Montos minimos y maximos de prueba
    public static final int MAX_AMOUNT_WITHDRAWAL=10000;



}