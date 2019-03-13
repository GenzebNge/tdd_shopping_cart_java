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
        List<String> itemsQuanty = new ArrayList<>();

        if (cartItems.size () == 0) {
            return itemsQuanty;
        } else {
            Iterator<Map.Entry <Item, Integer>> iterator = cartItems.entrySet ().iterator();

            while (iterator.hasNext ()) {
                Map.Entry<Item, Integer> entry = iterator.next();
                StringBuilder stringBuilder = new StringBuilder ();
                stringBuilder.append (entry.getKey ().getName ()).append (" - x").append (entry.getValue ());
                itemsQuanty.add (stringBuilder.toString());
            }
        }
        return itemsQuanty;
    }

    public List<String> itemizedList() {
        List<String> itemized = new ArrayList<>();
        if (cartItems.size() == 0) {
            return itemized;
        } else {
            Iterator<Map.Entry<Item, Integer>> iterator = cartItems.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Item, Integer> entry = iterator.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append (entry.getKey().getName()).append (" x").append (entry.getValue())
                        .append (" - $").append (entry.getKey().getPrice());
                itemized.add (stringBuilder.toString());
            }
        }
        return itemized;
    }
}