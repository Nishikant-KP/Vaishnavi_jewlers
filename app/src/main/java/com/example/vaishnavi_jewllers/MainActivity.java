package com.example.vaishnavi_jewllers;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.vaishnavi_jewllers.databinding.ActivityMainBinding;
import com.example.vaishnavi_jewllers.viewmodel.ChangeConstantViewModel;
import com.example.vaishnavi_jewllers.viewmodel.ViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        binding.setClickHandler(new ClickHandler());
        binding.setModel(viewModel);
        binding.title.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onChangeConstants();
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 100){
                viewModel.setDwt_con(Integer.parseInt(data.getStringExtra("Dwt_con")));
                viewModel.setCs_R_con(Integer.parseInt(data.getStringExtra("Cs_R_con")));
                viewModel.setCs_G_con(Integer.parseInt(data.getStringExtra("Cs_G_con")));
                viewModel.setPrl_con(Integer.parseInt(data.getStringExtra("Prl_con")));
                viewModel.setMk_con(Integer.parseInt(data.getStringExtra("Mk_con")));
                viewModel.setNwt_con(Double.parseDouble(data.getStringExtra("Nwt_con")));

            }
        }
    }

    public void onChangeConstants(){
        //todo display fragment to change the constants
        Log.i(TAG, "onChangeConstants: in ChangeConstants");
        Intent intent = new Intent(this, ConstantChangeActivity.class);
        intent.putExtra("Dwt_con",viewModel.getDwt_con());
        intent.putExtra("Cs_R_con",viewModel.getCs_R_con());
        intent.putExtra("Cs_G_con",viewModel.getCs_G_con());
        intent.putExtra("Prl_con",viewModel.getPrl_con());
        intent.putExtra("Mk_con",viewModel.getMk_con());
        intent.putExtra("Nwt_con",viewModel.getNwt_con());
        startActivityForResult(intent,100);
    }


    public class ClickHandler
    {
        public void onSubmit(View v){
            //todo display the final prize
            Log.i(TAG, "onSubmit: in submit");
            viewModel.calculate();
            binding.invalidateAll();
        }

        public void onRefresh(View v){
            viewModel.refresh();
            binding.invalidateAll();
        }

        public void onGenerateBill(View v){
            //create intent and go to Bill Activity
            double a = (Double.parseDouble(viewModel.getNwt().getValue()) * viewModel.getMk_con());
            double b = (Double.parseDouble(viewModel.getNwt().getValue()) * viewModel.getNwt_con()* Double.parseDouble(viewModel.getGrt().getValue()));
            double c = (Double.parseDouble(viewModel.getDwt().getValue()) * viewModel.getDwt_con());
            double d = (Double.parseDouble(viewModel.getCs_R().getValue()) * viewModel.getCs_R_con());
            double e = (Double.parseDouble(viewModel.getCs_G().getValue()) * viewModel.getCs_G_con());
            double f = ( Double.parseDouble(viewModel.getPrl().getValue()) * viewModel.getPrl_con());
            double tot = a+b+c+d+e+f;
            Intent intent = new Intent(v.getContext(), BillActivity.class);
            intent.putExtra("making_cost",a);
            intent.putExtra("gold_cost",b);
            intent.putExtra("diamond_cost",c);
            intent.putExtra("ruby_cost",d);
            intent.putExtra("emerald_cost",e);
            intent.putExtra("pearl_cost",f);
            intent.putExtra("total_cost",tot);
            startActivity(intent);
        }




    }
}