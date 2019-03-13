package com.alisnobba;

public class Item {
    private String name;
    private double price;
    private boolean onSale;

    public Item (String name, double price, boolean onSale) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Item {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", onSale=" + onSale +
                '}';
    }
}