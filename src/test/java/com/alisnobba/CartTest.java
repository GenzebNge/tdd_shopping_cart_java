package com.alisnobba;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CartTest {

    private static final double DELTA = 1e-15;
    private Cart cart;

    @Before
    public void setUp () throws Exception {
        cart = new Cart ();
        assertNotNull(cart);
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
    public void testGetTotalPriceWhenNoItemsAreAdded () {
        double expectedTotalPrice = 0.0;
        double actualTotalPrice;
        actualTotalPrice = cart.getTotalPrice ();
        assertEquals ("Should return a zero value when no items are added.", expectedTotalPrice, actualTotalPrice, DELTA);
    }

    @Test
    public void testGetTotalPriceWhenTwoItemsAreAdded () {
        double expectedTotalPrice = 3500.0;
        double actualTotalPrice;
        Item item = new Item ("Handbag", 500D, true);
        Item item2 = new Item ("Rolex", 1500D, false);
        cart.addItem (item, 1);
        cart.addItem (item2, 2);
        actualTotalPrice = cart.getTotalPrice ();
        assertEquals ("Should return a total price of 4000.0 (as double type).", expectedTotalPrice , actualTotalPrice, DELTA);
    }

   @Test
    public void testItemQuantities () {
        Item item = new Item ("Handbag", 100.00D, true);
        Item item2 = new Item ("Watch", 1000.00D, true);
        cart.addItem (item, 2);
        cart.addItem (item2, 4);
        assertNotNull (cart.itemQuantities ());
        assertTrue(cart.itemQuantities ().contains("Handbag - x2"));
       assertTrue(cart.itemQuantities ().contains("Watch - x4"));
    }

    @Test
    public void testItemizedList (){
        Item item = new Item ("Handbag", 500D, true);
        Item item2 = new Item ("Watch", 40000D, true);
        cart.addItem (item, 1);
        cart.addItem (item2, 2);
        assertNotNull (cart.itemizedList());
        assertEquals ("Should return itemized quantity and price.", 2, cart.itemizedList().size());
    }

    @Test
    public void testOnSaleItems (){
        Item item = new Item ("Handbag", 500D, true);
        Item item2 = new Item ("Watch", 40000D, true);
        Item item3 = new Item ("Rolex", 500D, false);
        Item item4 = new Item ("Cell Phone", 40000D, false);
        cart.addItem (item, 1);
        cart.addItem (item2, 2);
        cart.addItem (item3, 3);
        cart.addItem (item4, 4);
        assertNotNull (cart.onSaleItems ());
        assertEquals ("Should return on sale items.", 2, cart.onSaleItems ().size ());
    }
}