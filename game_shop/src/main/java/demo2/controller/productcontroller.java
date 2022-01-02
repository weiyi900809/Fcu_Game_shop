package demo2.controller;


import demo2.model.product;
import demo2.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productcontroller {

    @Autowired
    productservice productmanager;
    @GetMapping("/products")
    public List<product> getProducts(){

        return productmanager.getProducts();
    }
    @GetMapping("/products/{keyword}")
    public List<product> getProducts(@PathVariable("keyword")String keyword){

        return productmanager.getProducts(keyword);
    }



}
