package com.ganapathiram.user.activiites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ganapathiram.user.R;
import com.ganapathiram.user.adapter.ProductListAdapter;
import com.ganapathiram.user.common.GlobalClass;
import com.ganapathiram.user.database.Product;
import com.ganapathiram.user.intro_slider.IntroActivity;

import java.util.ArrayList;

/**
 * Created by Prakash on 1/25/2018.
 */

public class Dashboard extends AppCompatActivity {
    public static RecyclerView productList;
    public static ProductListAdapter adapter;
    public static TextView cartcount;
    GlobalClass global;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        global=(GlobalClass)getApplicationContext();
        productList = (RecyclerView) findViewById(R.id.productList);
        cartcount=(TextView)findViewById(R.id.cartcount);


        adapter = new ProductListAdapter(getApplicationContext(), new ArrayList<Product>());
        final int columns = getResources().getInteger(R.integer.grid_column);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),columns);
        productList.setLayoutManager(layoutManager);
        productList.setItemAnimator(new DefaultItemAnimator());
        productList.setAdapter(adapter);
        productList.setNestedScrollingEnabled(false);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Dashboard.this, IntroActivity.class);
        startActivity(i);
        ActivityCompat.finishAffinity(Dashboard.this);
    }
}
