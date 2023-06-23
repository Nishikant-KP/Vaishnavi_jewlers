package com.example.vaishnavi_jewllers.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChangeConstantViewModel extends ViewModel {
    private MutableLiveData<String> Dwt_con;
    private MutableLiveData<String> Cs_R_con;
    private MutableLiveData<String> Cs_G_con;
    private MutableLiveData<String> Prl_con;
    private MutableLiveData<String> Mk_con;
    private MutableLiveData<String> Nwt_con;

    public ChangeConstantViewModel() {
        init();
    }

    private void init() {
        Dwt_con = new MutableLiveData<>("45000");
        Cs_R_con = new MutableLiveData<>("450");
        Cs_G_con = new MutableLiveData<>("450");
        Prl_con = new MutableLiveData<>("250");
        Mk_con = new MutableLiveData<>("500");
        Nwt_con = new MutableLiveData<>("0.91");
    }

    public MutableLiveData<String> getDwt_con() {
        return Dwt_con;
    }

    public void setDwt_con(MutableLiveData<String> dwt_con) {
        Dwt_con = dwt_con;
    }

    public MutableLiveData<String> getCs_R_con() {
        return Cs_R_con;
    }

    public void setCs_R_con(MutableLiveData<String> cs_R_con) {
        Cs_R_con = cs_R_con;
    }

    public MutableLiveData<String> getCs_G_con() {
        return Cs_G_con;
    }

    public void setCs_G_con(MutableLiveData<String> cs_G_con) {
        Cs_G_con = cs_G_con;
    }

    public MutableLiveData<String> getPrl_con() {
        return Prl_con;
    }

    public void setPrl_con(MutableLiveData<String> prl_con) {
        Prl_con = prl_con;
    }

    public MutableLiveData<String> getMk_con() {
        return Mk_con;
    }

    public void setMk_con(MutableLiveData<String> mk_con) {
        Mk_con = mk_con;
    }

    public MutableLiveData<String> getNwt_con() {
        return Nwt_con;
    }

    public void setNwt_con(MutableLiveData<String> nwt_con) {
        Nwt_con = nwt_con;
    }

    public void check() {
        if(Dwt_con.getValue().isEmpty()){
            Dwt_con.setValue("45000");
        }
        if(Cs_R_con.getValue().isEmpty()){
            Cs_R_con.setValue("450");
        }
        if(Cs_G_con.getValue().isEmpty()){
            Cs_G_con.setValue("450");
        }
        if(Prl_con.getValue().isEmpty()){
            Prl_con.setValue("250");
        }
        if(Mk_con.getValue().isEmpty()){
            Mk_con.setValue("500");
        }
        if(Nwt_con.getValue().isEmpty()){
            Nwt_con.setValue("0.91");
        }


    }

    public void refresh() {
        Dwt_con.setValue("45000");
        Cs_R_con.setValue("450");
        Cs_G_con.setValue("450");
        Prl_con.setValue("250");
        Mk_con.setValue("500");
        Nwt_con.setValue("0.91");
    }


}
