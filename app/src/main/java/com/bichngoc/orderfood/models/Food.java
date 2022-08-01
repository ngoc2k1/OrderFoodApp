package com.bichngoc.orderfood.models;

import java.io.Serializable;

public class Food implements Serializable {
    private String name;
    private String picture;
    private String description;
    private Double price;
    private Integer numberInCart;

    public Food(String name, String picture, String description, Double price) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.price = price;
    }

    public Food(String name, String picture, String description, Double price, Integer numberInCart) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.price = price;
        this.numberInCart = numberInCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(Integer numberInCart) {
        this.numberInCart = numberInCart;
    }
}
