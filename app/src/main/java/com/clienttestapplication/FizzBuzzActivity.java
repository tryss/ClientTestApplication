package com.clienttestapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.clienttestapplication.databinding.ActivtyLoopBinding;

import java.util.ArrayList;

public class FizzBuzzActivity extends AppCompatActivity {

    private static final String TAG = FizzBuzzActivity.class.getSimpleName();
    Context mContext;
    ActivtyLoopBinding binding;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activty_loop);
        mContext = this;

        binding.infoText.setText("Fizz Buzz View");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                arrayList.add("fizzbuzz");
            } else if (i % 3 == 0) {
                arrayList.add("fizz");
            } else if (i % 5 == 0) {
                arrayList.add("buzz");
            } else {
                arrayList.add(String.valueOf(i));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1,
                android.R.id.text1, arrayList);
        binding.listView.setAdapter(adapter);
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