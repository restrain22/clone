package com.coupang.clone.controller;

import com.coupang.clone.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ProductController {


    @GetMapping("/ProductList")
    public ArrayList<Product> getProductList(){
        ArrayList<Product> list = new ArrayList<>();
        return list;
    }
}
