package com.ganapathiram.user.intro_slider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ganapathiram.user.R;
import com.ganapathiram.user.activiites.Dashboard;

/**
 * Created by Creative IT Works on 11-Jan-18.
 */

public class IntroActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private LinearLayout pager_indicator;
    private ViewPager intro_images;
    private int dotsCount;
    private ImageView[] dots;
    private ImageView header;
    private Button login;
    private ViewPagerAdapter mAdapter;
    private int[] mImageResources = {
            R.mipmap.header1,
            R.mipmap.header2,
            R.mipmap.header3

    };

    private int[] images = {
            R.mipmap.pop_film,
            R.mipmap.pop_ticket,
            R.mipmap.time_icon,

    };

    private int[] login_bg = {
            R.drawable.login_org_bg,
            R.drawable.login_lav_bg,
            R.drawable.login_blue_bg,

    };

    private int[] indicator_bg = {
            R.drawable.selected_item_org_dot,
            R.drawable.selected_item_lav_dot,
            R.drawable.selected_item_blue_dot

    };


    private int[] login_botton_round_corner = {
            R.drawable.login_bottom_org_round_corner,
            R.drawable.login_bottom_lav_round_corner,
            R.drawable.login_bottom_blue_round_corner

    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page);
        intialiseView();
    }

    void intialiseView()
    {

        intro_images = (ViewPager) findViewById(R.id.pager_introduction);
        header=(ImageView) findViewById(R.id.header);
        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        login=(Button) findViewById(R.id.login);

        mAdapter = new ViewPagerAdapter(IntroActivity.this, images);
        intro_images.setAdapter(mAdapter);
        intro_images.setCurrentItem(0);
        intro_images.setOnPageChangeListener(this);
        setUiPageViewController();



    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(indicator_bg[0]));
        header.setBackgroundResource(mImageResources[0]);
        login.setBackgroundResource(login_bg[0]);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginDialog(0);
            }
        });
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(final int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(indicator_bg[position]));
        header.setBackgroundResource(mImageResources[position]);
        login.setBackgroundResource(login_bg[position]);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginDialog(position);
            }
        });
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void loginDialog(int position) {

        // custom dialog
        final Dialog dialog = new Dialog(IntroActivity.this, R.style.CustomDialog);


        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.login_dialog);
        dialog.getWindow().setGravity(Gravity.CENTER);

        Button login=(Button)dialog.findViewById(R.id.login);
        login.setBackgroundResource(login_botton_round_corner[position]);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog.show();
        dialog.getWindow().setLayout((9 * width) / 10, (6 * height) / 10);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(IntroActivity.this, Dashboard.class);
                startActivity(i);
                finish();
            }
        });



        dialog.show();



    }
}
