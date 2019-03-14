package com.alisnobba;

public class Item {
    private String name;
    private double price;
    private boolean onSale;

    public Item (final String name, final double price, final boolean onSale) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }

    /*public Item () {

    }
    public Item withName (String name){
        this.name = name;
        return this;
    }
    public Item withPrice (double price){
        this.price = price;
        return this;
    }
    public Item withOnSale (boolean onSale){
        this.onSale = onSale;
        return this;
    }*/

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOnSale() {
        return onSale;
    }
}