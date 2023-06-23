package com.example.vaishnavi_jewllers.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    //Inputs from user
    private MutableLiveData<String> Gwt;
    private MutableLiveData<String> Grt;
    private MutableLiveData<String> Nwt;
    private MutableLiveData<String> Dwt;
    private MutableLiveData<String> Cs_R;
    private MutableLiveData<String> Cs_G;
    private MutableLiveData<String> Prl;


    //Constants
    private int Dwt_con = 45000;
    private int Cs_R_con = 450;
    private int Cs_G_con = 450;
    private int Prl_con = 250;
    private int Mk_con = 500;
    private double Nwt_con = 0.91;

    //OutPut
    private MutableLiveData<String> tot;

    //boolean for output visibility
    private MutableLiveData<Boolean> isOutputVisible;

    public ViewModel() {
        //to initialize variables
        init();
    }

    private void init() {
        Grt = new MutableLiveData<>("");
        Gwt = new MutableLiveData<>("");
        Nwt = new MutableLiveData<>("");
        Dwt = new MutableLiveData<>("");
        Cs_G = new MutableLiveData<>("");
        Cs_R = new MutableLiveData<>("");
        Prl = new MutableLiveData<>("");
        tot = new MutableLiveData<>("");
        isOutputVisible = new MutableLiveData<>(false);
    }

    public MutableLiveData<String> getGwt() {
        return Gwt;
    }

    public void setGwt(MutableLiveData<String> gwt) {
        Gwt = gwt;
    }

    public MutableLiveData<String> getNwt() {
        return Nwt;
    }

    public void setNwt(MutableLiveData<String> nwt) {
        Nwt = nwt;
    }

    public MutableLiveData<String> getDwt() {
        return Dwt;
    }

    public void setDwt(MutableLiveData<String> dwt) {
        Dwt = dwt;
    }

    public MutableLiveData<String> getCs_R() {
        return Cs_R;
    }

    public void setCs_R(MutableLiveData<String> cs_R) {
        Cs_R = cs_R;
    }

    public MutableLiveData<String> getCs_G() {
        return Cs_G;
    }

    public void setCs_G(MutableLiveData<String> cs_G) {
        Cs_G = cs_G;
    }

    public MutableLiveData<String> getPrl() {
        return Prl;
    }

    public void setPrl(MutableLiveData<String> prl) {
        Prl = prl;
    }

    public Integer getDwt_con() {
        return Dwt_con;
    }

    public void setDwt_con(int dwt_con) {
        Dwt_con = dwt_con;
    }

    public Integer getCs_R_con() {
        return Cs_R_con;
    }

    public void setCs_R_con(int cs_R_con) {
        Cs_R_con = cs_R_con;
    }

    public Integer getCs_G_con() {
        return Cs_G_con;
    }

    public void setCs_G_con(int cs_G_con) {
        Cs_G_con = cs_G_con;
    }

    public Integer getPrl_con() {
        return Prl_con;
    }

    public void setPrl_con(int prl_con) {
        Prl_con = prl_con;
    }

    public Integer getMk_con() {
        return Mk_con;
    }

    public void setMk_con(int mk_con) {
        Mk_con = mk_con;
    }

    public double getNwt_con() {
        return Nwt_con;
    }

    public void setNwt_con(double nwt_con) {
        Nwt_con = nwt_con;
    }

    public MutableLiveData<String> getGrt() {
        return Grt;
    }

    public void setGrt(MutableLiveData<String> grt) {
        Grt = grt;
    }

    public MutableLiveData<String> getTot() {
        return tot;
    }

    public void setTot(MutableLiveData<String> tot) {
        this.tot = tot;
    }

    public void calculate() {
        check();
        try{
            double a = (Double.parseDouble(Nwt.getValue()) * Mk_con);
            double b = (Double.parseDouble(Nwt.getValue()) * Nwt_con * Double.parseDouble(Grt.getValue()));
            double c = (Double.parseDouble(Dwt.getValue()) * Dwt_con);
            double d = (Double.parseDouble(Cs_R.getValue()) * Cs_R_con);
            double e = (Double.parseDouble(Cs_G.getValue()) * Cs_G_con);
            double f = ( Double.parseDouble(Prl.getValue()) * Prl_con);

            String x =   String.valueOf((Double.parseDouble(Nwt.getValue()) * Mk_con) +
                    (Double.parseDouble(Nwt.getValue()) * Nwt_con * Double.parseDouble(Grt.getValue()))+
                    (Double.parseDouble(Dwt.getValue()) * Dwt_con) +
                    (Double.parseDouble(Cs_R.getValue()) * Cs_R_con) +
                    (Double.parseDouble(Cs_G.getValue()) * Cs_G_con) +
                    ( Double.parseDouble(Prl.getValue()) * Prl_con));
            tot.setValue(x);
            isOutputVisible.setValue(true);
            Log.i("total value", "calculate: "+ a + b + c +d +e + f +tot.getValue());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void check() {
        if(Gwt.getValue().isEmpty()){
            Gwt.setValue("0");
        }
        if(Nwt.getValue().isEmpty()){
            if(!Gwt.getValue().isEmpty()){
                double c = (Double.parseDouble(Dwt.getValue())) / 5;
                double d = (Double.parseDouble(Cs_R.getValue())) / 5 ;
                double e = (Double.parseDouble(Cs_G.getValue())) / 5 ;
                double f = ( Double.parseDouble(Prl.getValue())) / 5;
                Log.i("TAG_buf", "Dwt: "+c+ "Rubies" + d + "green " + e + "pearls" + f);
                double x = (Double.valueOf(Gwt.getValue())) - (c + d + e + f);
                Log.i("TAG_buf", "net" + x);
                Nwt.setValue(String.valueOf(x));
            }
            else {
                Nwt.setValue("0");
            }
        }
        if(Dwt.getValue().isEmpty()){
            Dwt.setValue("0");
        }
        if(Prl.getValue().isEmpty()){
            Prl.setValue("0");
        }
        if(Cs_R.getValue().isEmpty()){
            Cs_R.setValue("0");
        }
        if(Cs_G.getValue().isEmpty()){
            Cs_G.setValue("0");
        }
        if(Grt.getValue().isEmpty()){
            Grt.setValue("0");
        }

    }

    public MutableLiveData<Boolean> getIsOutputVisible() {
        return isOutputVisible;
    }

    public void setIsOutputVisible(MutableLiveData<Boolean> isOutputVisible) {
        this.isOutputVisible = isOutputVisible;
    }

    public void refresh() {

            Gwt.setValue("");


            Nwt.setValue("");


            Dwt.setValue("");


            Prl.setValue("");


            Cs_R.setValue("");


            Cs_G.setValue("");


            Grt.setValue("");
            isOutputVisible.setValue(false);

    }
}
