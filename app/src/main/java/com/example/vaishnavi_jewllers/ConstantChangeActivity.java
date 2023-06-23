package com.example.vaishnavi_jewllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.vaishnavi_jewllers.databinding.ActivityConstantChangeBinding;
import com.example.vaishnavi_jewllers.viewmodel.ChangeConstantViewModel;

public class ConstantChangeActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityConstantChangeBinding binding;
    private ChangeConstantViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constant_change);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_constant_change);
        viewModel = new ViewModelProvider(this).get(ChangeConstantViewModel.class);
        binding.setClickHandler(new ClickHandlers());
        setConstants();
        binding.setModel(viewModel);
    }

    private void setConstants() {
        viewModel.getDwt_con().setValue(String.valueOf(getIntent().getIntExtra("Dwt_con",45000)));
        viewModel.getCs_R_con().setValue(String.valueOf(getIntent().getIntExtra("Cs_R_con",450)));
        viewModel.getCs_G_con().setValue(String.valueOf(getIntent().getIntExtra("Cs_G_con",450)));
        viewModel.getPrl_con().setValue(String.valueOf(getIntent().getIntExtra("Prl_con",250)));
        viewModel.getMk_con().setValue(String.valueOf(getIntent().getIntExtra("Mk_con",500)));
        viewModel.getNwt_con().setValue(String.valueOf(getIntent().getDoubleExtra("Cs_G_con",0.91)));

    }

    public class ClickHandlers{
        public void onSubmit(View v){
            //todo display the final prize
            Log.i(TAG, "onSubmit: in submit");
            viewModel.check();
            binding.invalidateAll();
            Intent intent = new Intent();
            intent.putExtra("Dwt_con",viewModel.getDwt_con().getValue());
            intent.putExtra("Cs_R_con",viewModel.getCs_R_con().getValue());
            intent.putExtra("Cs_G_con",viewModel.getCs_G_con().getValue());
            intent.putExtra("Prl_con",viewModel.getPrl_con().getValue());
            intent.putExtra("Mk_con",viewModel.getMk_con().getValue());
            intent.putExtra("Nwt_con",viewModel.getNwt_con().getValue());
            setResult(Activity.RESULT_OK,intent);
            finish();

        }

        public void onRefresh(View v){
            viewModel.getDwt_con().setValue(String.valueOf(getIntent().getIntExtra("Dwt_con",45000)));
            viewModel.getCs_R_con().setValue(String.valueOf(getIntent().getIntExtra("Cs_R_con",450)));
            viewModel.getCs_G_con().setValue(String.valueOf(getIntent().getIntExtra("Cs_G_con",450)));
            viewModel.getPrl_con().setValue(String.valueOf(getIntent().getIntExtra("Prl_con",250)));
            viewModel.getMk_con().setValue(String.valueOf(getIntent().getIntExtra("Mk_con",500)));
            viewModel.getNwt_con().setValue(String.valueOf(getIntent().getDoubleExtra("Cs_G_con",0.91)));
            binding.invalidateAll();
        }
    }
}