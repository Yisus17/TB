package com.tekknow.bicentenario.tbcomplus.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tekknow.bicentenario.tbcomplus.R;

/**
 * Created by Mercedes Rodriguez on 4/26/2017.
 */

public class CiFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ci, container, false);
        return rootView;
    }
}
