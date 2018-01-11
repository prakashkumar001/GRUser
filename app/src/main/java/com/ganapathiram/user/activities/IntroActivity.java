package com.ganapathiram.user.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ganapathiram.user.R;

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
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(indicator_bg[position]));
        header.setBackgroundResource(mImageResources[position]);
        login.setBackgroundResource(login_bg[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
