package com.example.listandadapters.CountriesFramework;

public class Countries {
    String name;
    String capital;
    String image;
    String url;
    public Countries(String name, String capital, String image, String url){
        this.name=name;
        this.capital=capital;
        this.image=image;
        this.url=url;
    }

    public Countries(){}

    public String getName(){
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getImage() {
        return image;
    }

    public String getUrl(){ return url; }
}
