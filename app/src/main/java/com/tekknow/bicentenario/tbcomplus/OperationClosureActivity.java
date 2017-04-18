package com.tekknow.bicentenario.tbcomplus;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

/**
 * Created by Mercedes Rodriguez on 4/18/2017.
 */

public class OperationClosureActivity extends OperationControlActivity {
    @Override
    protected String getOperationClosureTitle() {
        return null;
    }

    @Override
    protected int getOperationClosureView() {
        return R.layout.activity_operation_closure;
    }

    @Override
    protected int getOperationStatus() {
        return GlobalConstants.STATUS_CLOSE;
    }
}
