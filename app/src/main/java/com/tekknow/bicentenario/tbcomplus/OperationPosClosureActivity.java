package com.tekknow.bicentenario.tbcomplus;


import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class OperationPosClosureActivity extends OperationControlActivity {

    @Override
    protected String getOperationClosureTitle() {
        return getString(R.string.title_activity_close_pos);
    }

    @Override
    protected int getOperationClosureView() {
        return R.layout.activity_operation_pos_closure;
    }

    @Override
    protected int getOperationStatus() {
        return GlobalConstants.STATUS_OK;
    }

}