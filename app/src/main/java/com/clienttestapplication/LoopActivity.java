package com.clienttestapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.clienttestapplication.databinding.ActivtyLoopBinding;
import com.clienttestapplication.utility.Utility;

import java.util.ArrayList;
import java.util.Locale;

public class LoopActivity extends AppCompatActivity {

    private static final String TAG = LoopActivity.class.getSimpleName();
    Context mContext;
    ActivtyLoopBinding binding;
    int firstNumber, secondNumber, limit;
    String firstString, secondString;
    ArrayList<String> arrayList = new ArrayList<>();
    int countBoth = 0, countFirst = 0, countSecond = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activty_loop);
        mContext = this;

        firstNumber = getIntent().getIntExtra("firstNumber", 0);
        secondNumber = getIntent().getIntExtra("secondNumber", 0);
        limit = getIntent().getIntExtra("limit", 0);
        firstString = getIntent().getStringExtra("firstString");
        secondString = getIntent().getStringExtra("secondString");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.infoText.setText(String.format(Locale.ENGLISH, "Page Hit Count: %d\n" +
                        "Number First: %d\nNumber Second: %d\n" +
                        "Limit: %d\nString First: %s\nString Second: %s",
                Utility.getIngerSharedPreferences(mContext, "hits"),
                firstNumber, secondNumber, limit, firstString, secondString));

        for (int i = 1; i <= limit; i++) {
            if (i % firstNumber == 0 && i % secondNumber == 0) {
                arrayList.add(firstString + secondString);
                countBoth++;
            } else if (i % firstNumber == 0) {
                arrayList.add(firstString);
                countFirst++;
            } else if (i % secondNumber == 0) {
                arrayList.add(secondString);
                countSecond++;
            } else {
                arrayList.add(String.valueOf(i));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1,
                android.R.id.text1, arrayList);
        binding.listView.setAdapter(adapter);

        binding.chartButton.setOnClickListener(v -> {
            Log.e(TAG, "countBoth ======> " + countBoth);
            Log.e(TAG, "countFirst ======> " + countFirst);
            Log.e(TAG, "countSecond ======> " + countSecond);
            Intent intent = new Intent(mContext, ChartViewActivity.class);
            intent.putExtra("countBoth", countBoth);
            intent.putExtra("countFirst", countFirst);
            intent.putExtra("countSecond", countSecond);
            startActivity(intent);
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
