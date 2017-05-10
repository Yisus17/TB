package com.unidigital.bicentenario.tbcomplus.widget;

import android.content.Context;

import java.util.ArrayList;
import com.unidigital.bicentenario.tbcomplus.widget.*;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

/**
 * Created by Jesus Arevalo on 5/10/2017.
 */

public class fieldValidation {
    public String msg;
    public boolean isValid;

    public fieldValidation(String msg, boolean isValid){
        this.isValid=isValid;
        this.msg=msg;
    }

}
