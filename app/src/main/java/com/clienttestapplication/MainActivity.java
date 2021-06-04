package com.clienttestapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.clienttestapplication.databinding.ActivityMainBinding;
import com.clienttestapplication.utility.Utility;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding binding;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mContext = this;

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.submitButton.setOnClickListener(v -> {
            if (binding.firstNumber.getText().toString().length() <= 0) {
                Toast.makeText(mContext, "Please add number first", Toast.LENGTH_SHORT).show();
            } else if (binding.secondNumber.getText().toString().length() <= 0) {
                Toast.makeText(mContext, "Please add number second", Toast.LENGTH_SHORT).show();
            } else if (binding.limit.getText().toString().length() <= 0) {
                Toast.makeText(mContext, "Please add limit", Toast.LENGTH_SHORT).show();
            } else if (binding.firstString.getText().toString().length() <= 0) {
                Toast.makeText(mContext, "Please add string first", Toast.LENGTH_SHORT).show();
            } else if (binding.secondString.getText().toString().length() <= 0) {
                Toast.makeText(mContext, "Please add string second", Toast.LENGTH_SHORT).show();
            } else {

                int count = Utility.getIngerSharedPreferences(mContext, "hits");
                count = count + 1;
                Utility.setIntegerSharedPreference(mContext, "hits", count);

                Intent intent = new Intent(mContext, LoopActivity.class);
                intent.putExtra("firstNumber", Integer.parseInt(binding.firstNumber.getText().toString()));
                intent.putExtra("secondNumber", Integer.parseInt(binding.secondNumber.getText().toString()));
                intent.putExtra("limit", Integer.parseInt(binding.limit.getText().toString()));
                intent.putExtra("firstString", binding.firstString.getText().toString());
                intent.putExtra("secondString", binding.secondString.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}