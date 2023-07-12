package com.ui.foodorder.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;
import com.ui.foodorder.R;
import com.ui.foodorder.adapter.ViewPagerAdapter;
import com.ui.foodorder.animation.DepthPageTransformer;
import com.ui.foodorder.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private ViewPagerAdapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initialView();
        initialData();
    }

    private void initialView() {

        mViewPagerAdapter = new ViewPagerAdapter(this);
        mBinding.viewPaper.setAdapter(mViewPagerAdapter);
        mBinding.viewPaper.setUserInputEnabled(false); //disable swipe view paper 2

        mBinding.viewPaper.setPageTransformer(new DepthPageTransformer());
        //event scroll horizontal
        mBinding.viewPaper.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mBinding.bottomNavigation.getMenu().findItem(R.id.nav_home).setChecked(true);
                        break;
                    case 1:
                        mBinding.bottomNavigation.getMenu().findItem(R.id.nav_contact).setChecked(true);
                        break;
                    case 2:
                        mBinding.bottomNavigation.getMenu().findItem(R.id.nav_payment).setChecked(true);
                        break;
                    case 3:
                        mBinding.bottomNavigation.getMenu().findItem(R.id.nav_profile).setChecked(true);
                        break;
                }
            }
        });

        //event bottom navigation
        mBinding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        mBinding.viewPaper.setCurrentItem(0);
                        break;
                    case R.id.nav_contact:
                        mBinding.viewPaper.setCurrentItem(1);
                        break;
                    case R.id.nav_payment:
                        mBinding.viewPaper.setCurrentItem(2);
                        break;
                    case R.id.nav_profile:
                        mBinding.viewPaper.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    private void initialData() {
    }
}