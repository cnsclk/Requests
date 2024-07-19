package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Merhaba Dünya!";
    }
    @GetMapping("/totalamount")
    public double getTotalAmount() {
        Store store1= new Store();

        return store1.totalAmount();
    }
    @GetMapping("/totalavarageprice")
    public double totalAveragePrice() {
        Store store2= new Store();

        return store2.totalAveragePrice();
    }
    @GetMapping("/avgpriceperproduct")
    public Map<Integer, Double> avgPricePerProduct() {
        Store store3= new Store();

        return store3.avgPricePerProduct();
    }




}
