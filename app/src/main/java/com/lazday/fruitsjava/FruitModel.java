package com.lazday.fruitsjava;

import java.io.Serializable;

public class FruitModel implements Serializable {
    private String name;
    private Integer image;

    public FruitModel(String name, Integer image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
