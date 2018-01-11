package com.ganapathiram.user.intro_slider;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ganapathiram.user.R;


public class IntroOne extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro, container, false);

    return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
