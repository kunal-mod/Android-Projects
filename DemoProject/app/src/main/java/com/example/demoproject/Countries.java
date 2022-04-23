package com.example.demoproject;

public class Countries {
    private final String countryName;
    private final String countryFood;
    private final int image;
    public Countries(String countryName, String countryCapital, int image){
        this.countryName = countryName;
        this.countryFood = countryCapital;
        this.image = image;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryFood() {
        return countryFood;
    }

    public int getImage() {
        return image;
    }
}
