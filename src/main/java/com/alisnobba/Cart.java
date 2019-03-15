package com.alisnobba;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {

    private Map <Item, Integer> cartItems;
    private static final String thePattern = "%s x%s - $%s";

    public Cart () {
        cartItems = new HashMap<>();
    }

    public Set<Item> getItems () {
        Set<Item> items = new HashSet<>();
        if (cartItems.size () == 0) {
            return items;
        }
        items = cartItems.keySet();
        return items;
    }

    public void addItem (Item item, int quantity) {
        cartItems.put (item, quantity);
    }

    //Mapped stream of items with quantity to form a string

    public List<String> itemQuantities () {
        List<String> itemsQuantity = new ArrayList<>();
        if (cartItems.size () == 0) {

            return itemsQuantity;
        } else {

            itemsQuantity = cartItems.entrySet().stream()
                    .map(entry ->
                            String.format("%s - x%s",
                                    entry.getKey().getName(), entry.getValue()))
                    .collect(Collectors.toList());
        }
        return itemsQuantity;
    }

    //changed code by using stream to get item names and quantity

    public List<String> itemizedList() {
        List<String> itemized = new ArrayList<>();
        if (cartItems.size () == 0) {
            return itemized;
        } else {
            itemized = cartItems.entrySet().stream()
                    .map(entry ->
                            String.format(thePattern,
                                    entry.getKey().getName(), entry.getValue(), entry.getKey().getPrice()))
                    .collect(Collectors.toList());
        }
        return itemized;
    }

    //Used filter on stream to get only onSale items
    //Used thePattern for the formatting of string

    public List<String> onSaleItems () {
        List<String> onSaleItemsList = new ArrayList<>();
        if (cartItems.size() == 0) {
            return onSaleItemsList;
        } else {
            onSaleItemsList = cartItems.entrySet().stream()
                    .filter(item -> item.getKey().isOnSale())
                    .map(entry ->
                            String.format(thePattern,
                                    entry.getKey ().getName (), entry.getValue (), entry.getKey ().getPrice ()))
                    .collect(Collectors.toList());

        }
        return onSaleItemsList;
    }

   //Used stream on entryset of Map<Item, quantity> and used map and reduce functions to calculate total price of the items

    public double getTotalPrice () {
        double totalPrice = 0D;
        if (cartItems.size () == 0) {
            return totalPrice;
        } else {
           totalPrice = cartItems.entrySet().stream().map(e -> e.getKey().getPrice()*e.getValue())
                    .reduce(totalPrice, Double::sum);
        }
        return totalPrice;
    }
}