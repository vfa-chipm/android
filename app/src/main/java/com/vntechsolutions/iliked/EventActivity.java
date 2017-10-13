package com.vntechsolutions.iliked;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chiPM on 10/13/17.
 */

public class EventActivity extends Fragment{
    public EventActivity(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_event, container, false);
    }
}
