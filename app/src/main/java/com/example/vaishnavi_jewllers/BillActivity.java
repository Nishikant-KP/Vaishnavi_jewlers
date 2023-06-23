package com.example.vaishnavi_jewllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.vaishnavi_jewllers.databinding.ActivityBill2Binding;

public class BillActivity extends AppCompatActivity {

    private ActivityBill2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill2);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bill2);
        binding.setClickHandler(new ClickHandler());



    }
    public class ClickHandler{
        public void onBack(View v)
        {
           finish();
        }
    }
}