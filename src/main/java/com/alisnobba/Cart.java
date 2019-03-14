package com.alisnobba;

import java.util.*;

public class Cart {

    private Map <Item, Integer> cartItems;

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

    public List<String> itemQuantities () {
        List<String> itemsQuantity = new ArrayList<>();
        if (cartItems.size () == 0) {
            return itemsQuantity;
        } else {
            Iterator<Map.Entry <Item, Integer>> iterator = cartItems.entrySet ().iterator();
            while (iterator.hasNext ()) {
                Map.Entry<Item, Integer> entry = iterator.next();
                StringBuilder stringBuilder = new StringBuilder ();
                Formatter fmt = new Formatter (stringBuilder);
                fmt.format ("%s - x%s", entry.getKey ().getName (), entry.getValue ());
                itemsQuantity.add (stringBuilder.toString());
            }
        }
        return itemsQuantity;
    }

    public List<String> itemizedList() {
        List<String> itemized = new ArrayList<>();
        if (cartItems.size () == 0) {
            return itemized;
        } else {
            Iterator<Map.Entry<Item, Integer>> iterator = cartItems.entrySet ().iterator ();
            while (iterator.hasNext ()) {
                Map.Entry<Item, Integer> entry = iterator.next ();
                itemized.add (addItemsToList (entry));
            }
        }
        return itemized;
    }

    public List<String> onSaleItems () {
        List<String> onSaleItemsList = new ArrayList<>();
        if (cartItems.size() == 0) {
            return onSaleItemsList;
        } else {
            Iterator<Map.Entry<Item, Integer>> iterator = cartItems.entrySet ().iterator ();
            while (iterator.hasNext()) {
                Map.Entry<Item, Integer> entry = iterator.next ();
                if(entry.getKey ().isOnSale ()) {
                    onSaleItemsList.add (addItemsToList (entry));
                }
            }
        }
        return onSaleItemsList;
    }

    private static String addItemsToList (Map.Entry<Item, Integer> entry) {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter fmt = new Formatter (stringBuilder);
        fmt.format ("%s x%s - $%s", entry.getKey ().getName (), entry.getValue (), entry.getKey ().getPrice ());
        return stringBuilder.toString ();
    }

    public double getTotalPrice () {
        double totalPrice = 0D;
        if (cartItems.size () == 0) {
            return totalPrice;
        } else {
            Iterator<Map.Entry<Item, Integer>> iterator = cartItems.entrySet ().iterator ();
            while (iterator.hasNext ()) {
                Map.Entry<Item, Integer> entry = iterator.next ();
                totalPrice += (entry.getKey ().getPrice () * entry.getValue ());
                }
            }
        return totalPrice;
    }
}