package com.clienttestapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.clienttestapplication.databinding.ActivityChartViewBinding;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartViewActivity extends AppCompatActivity {

    private static final String TAG = ChartViewActivity.class.getSimpleName();
    Context mContext;
    ActivityChartViewBinding binding;
    int countBoth = 0, countFirst = 0, countSecond = 0, limit = 0;
    String firstString = "", secondString = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chart_view);

        mContext = this;

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        countBoth = getIntent().getIntExtra("countBoth", 0);
        countFirst = getIntent().getIntExtra("countFirst", 0);
        countSecond = getIntent().getIntExtra("countSecond", 0);
        firstString = getIntent().getStringExtra("firstString");
        secondString = getIntent().getStringExtra("secondString");

        ArrayList<BarEntry> noOfCount = new ArrayList<>();

        noOfCount.add(new BarEntry(0, countBoth));
        noOfCount.add(new BarEntry(1, countFirst));
        noOfCount.add(new BarEntry(2, countSecond));

        /*ArrayList<BarDataSet>type = new ArrayList<>();
        type.add(new BarDataSet(new ArrayList<BarEntry>(),"BOTH"));
        type.add(new BarDataSet(new ArrayList<BarEntry>(),firstString));
        type.add(new BarDataSet(new ArrayList<BarEntry>(),secondString));*/


        BarDataSet bardataset = new BarDataSet(noOfCount, "No Of Hits");
        binding.barchart.animateY(5000);
        BarData data = new BarData(bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        binding.barchart.setData(data);
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