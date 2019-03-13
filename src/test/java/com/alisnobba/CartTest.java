package com.alisnobba;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {

    @Before
    public void setUp () throws Exception {
    }

    @After
    public void tearDown () throws Exception {
    }

    @Test
    public void testGetItemsIsNeverNull () {
        Cart cart = new Cart ();
        assertNotNull (cart.getItems ());
    }

    @Test
    public void testAddItem () {
        // Setup.
        Item item = new Item ("Rolex", 1000.00D, true);
        Cart cart = new Cart ();
        cart.addItem (item, 10);
        //testable.
        assertEquals(1, cart.getItems().size());
    }

    @Test
    public void testItemQuantities () {
        Item item = new Item ("Handbag", 100.00D, true);
        Item item2 = new Item ("Watch", 1000.00D, true);
        Cart cart = new Cart ();
        cart.addItem (item, 2);
        cart.addItem (item2, 4);
        assertNotNull (cart.itemQuantities ());
        assertEquals(2, cart.itemQuantities ().size());
    }

    @Test
    public void testItemizedList (){
        Item item = new Item ("Handbag", 500D, true);
        Item item2 = new Item ("Watch", 40000D, true);
        Cart cart = new Cart ();
        cart.addItem (item, 1);
        cart.addItem (item2, 2);
        assertNotNull (cart.itemizedList());
        assertEquals ("Should return itemized quantity and price.", 2, cart.itemizedList().size());
    }
}