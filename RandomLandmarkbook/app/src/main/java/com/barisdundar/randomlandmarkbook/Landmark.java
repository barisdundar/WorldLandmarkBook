package com.barisdundar.randomlandmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable {
    String name;
    String country;
    int image;
    String info;

    public Landmark(String name, String country, int image, String info) {
        this.name = name;
        this.country = country;
        this.image = image;
        this.info = info;
    }
}
