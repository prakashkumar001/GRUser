package com.ganapathiram.user.intro_slider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ganapathiram.user.R;


public class IntroTwo extends Fragment {

    TextView learnmore, start;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro2, container, false);

       /* learnmore = (TextView) view.findViewById(R.id.btn_learnmore);
        start = (TextView) view.findViewById(R.id.btn_start);
        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                SplashActivity.activity.finish();
            }
        });*/

    return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
