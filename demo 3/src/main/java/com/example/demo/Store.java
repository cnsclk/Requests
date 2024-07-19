package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    List<Order> orders;

    public Store() {
        this.orders = new ArrayList<>();

        // Order 1
        Order order1 = new Order(1000);
        order1.addItem(new Item(2000, 12, 100.51));
        order1.addItem(new Item(2001, 31, 200));
        order1.addItem(new Item(2002, 22, 150.86));
        order1.addItem(new Item(2003, 41, 250));
        order1.addItem(new Item(2004, 55, 244));
        orders.add(order1);

        // Order 2
        Order order2 = new Order(1001);
        order2.addItem(new Item(2001, 88, 44.531));
        order2.addItem(new Item(2002, 121, 88.11));
        order2.addItem(new Item(2004, 74, 211));
        order2.addItem(new Item(2002, 14, 88.11));
        orders.add(order2);

        // Order 3
        Order order3 = new Order(1002);
        order3.addItem(new Item(2003, 2, 12.1));
        order3.addItem(new Item(2004, 3, 22.3));
        order3.addItem(new Item(2003, 8, 12.1));
        order3.addItem(new Item(2002, 16, 94));
        order3.addItem(new Item(2005, 9, 44.1));
        order3.addItem(new Item(2006, 19, 90));
        orders.add(order3);
    }
    public double totalAmount() {
        double totalAmount = 0;
        for (Order order : this.orders) {
            for (Item item : order.getItems()) {
                totalAmount += item.getUnitPrice() * item.getQuantity();
            }
        }
        return totalAmount;
    }
    public double totalAveragePrice(){
        int totalItemCount = 0;
        double totalPriceSum = 0;
        for (Order order : orders) {
            for (Item item : order.getItems()) {
                totalPriceSum += item.getUnitPrice() * item.getQuantity();
                totalItemCount += item.getQuantity();
            }
        }

        return totalPriceSum / totalItemCount;
    }
    public Map<Integer, Double> avgPricePerProduct(){
        Map<Integer, Double> itemTotalPrices = new HashMap<>();
        Map<Integer, Integer> itemTotalQuantities = new HashMap<>();

        for (Order order : orders) {
            for (Item item : order.getItems()) {
                int itemNumber = item.getItemNumber();
                itemTotalPrices.putIfAbsent(itemNumber, 0.0);
                itemTotalQuantities.putIfAbsent(itemNumber, 0);

                itemTotalPrices.put(itemNumber,
                        itemTotalPrices.get(itemNumber) + item.getUnitPrice() * item.getQuantity());
                itemTotalQuantities.put(itemNumber,
                        itemTotalQuantities.get(itemNumber) + item.getQuantity());
            }
        }

        Map<Integer, Double> avgPrices = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : itemTotalPrices.entrySet()) {
            int itemNumber = entry.getKey();
            double totalItemPrice = entry.getValue();
            int totalItemQuantity = itemTotalQuantities.get(itemNumber);
             double avgPrice = totalItemPrice / totalItemQuantity;
             avgPrices.put(itemNumber,avgPrice);

        }
        return avgPrices;

    }

}
