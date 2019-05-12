package com.example.hellocat.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.hellocat.BR;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Categories extends BaseObservable {
    /**
     * id : 5
     * name : boxes
     */

    private int id;
    private String name;
    @Generated(hash = 749050540)
    public Categories(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 267348489)
    public Categories() {
    }
    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged( BR.id );
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged( BR.name );
    }
}
