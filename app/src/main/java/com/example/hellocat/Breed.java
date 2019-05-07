package com.example.hellocat;

public class Breed {
    private String name;
    private String description;
    private String id;
    private String wikipedia_url;
    private String img_url;
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


}
