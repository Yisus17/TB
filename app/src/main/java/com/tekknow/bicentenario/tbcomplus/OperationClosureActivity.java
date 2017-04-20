package com.tekknow.bicentenario.tbcomplus;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class OperationClosureActivity extends ClosureActivity {
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
        return STATUS_CLOSE;
    }
}
