package com.clienttestapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class StartActivity extends AppCompatActivity {

    private static final String TAG = StartActivity.class.getSimpleName();
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activty_start);
        mContext = this;

    }

    public void fizzBuzzClick(View view) {
        startActivity(new Intent(mContext, FizzBuzzActivity.class));
    }

    public void fiveParametersClick(View view) {
        startActivity(new Intent(mContext, MainActivity.class));
    }
}
