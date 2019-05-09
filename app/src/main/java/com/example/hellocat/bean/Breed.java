package com.example.hellocat.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Breed {
    private String name;
    private String description;
    private String id;
    private String wikipedia_url;
    private String img_url;
    @Generated(hash = 1198211894)
    public Breed(String name, String description, String id, String wikipedia_url,
            String img_url) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.wikipedia_url = wikipedia_url;
        this.img_url = img_url;
    }
    @Generated(hash = 1184883001)
    public Breed() {
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getImg_url(){
        return img_url;
    }
    public void setImg_url(String _img_url){
        img_url=_img_url;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getWikipedia_url() {
        return this.wikipedia_url;
    }
    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }


}
