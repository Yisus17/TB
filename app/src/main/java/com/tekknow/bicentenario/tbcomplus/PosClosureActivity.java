package com.tekknow.bicentenario.tbcomplus;


import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class PosClosureActivity extends ClosureActivity {

    @Override
    protected String getOperationClosureTitle() {
        return getString(R.string.title_activity_close_pos);
    }

    @Override
    protected int getOperationClosureView() {
        return R.layout.activity_pos_closure;
    }

    @Override
    protected int getOperationStatus() {
        return GlobalConstants.STATUS_OK;
    }

}