package com.example.asus.finalhomework;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class ViewpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpage);
        MyPageAdapter pageAdapter=new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        //TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        // tabLayout.setupWithViewPager(viewPager);

    }
}
