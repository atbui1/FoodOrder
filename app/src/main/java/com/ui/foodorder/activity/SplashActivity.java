package com.ui.foodorder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ui.foodorder.R;
import com.ui.foodorder.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivitySplashBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
        mBinding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initialView();
        initialData();
    }

    private void initialView() {
        mBinding.txtGetStar.setOnClickListener(this);
    }

    private void initialData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_get_star:
                goToMain();
            break;
        }
    }

    private void goToMain() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }
}