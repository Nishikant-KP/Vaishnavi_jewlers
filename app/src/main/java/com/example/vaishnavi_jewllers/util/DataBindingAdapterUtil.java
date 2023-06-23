package com.example.vaishnavi_jewllers.util;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class DataBindingAdapterUtil {
    @BindingAdapter({"textOut"})
    public static void textOutput(TextView view,String out){
        view.setText("Total Cost: "+out);
    }
}
