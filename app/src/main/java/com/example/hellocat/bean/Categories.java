package com.example.hellocat.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.hellocat.BR;

public class Categories extends BaseObservable {
    /**
     * id : 5
     * name : boxes
     */

    private int id;
    private String name;
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
