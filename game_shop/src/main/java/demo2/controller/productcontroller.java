package demo2.controller;


import demo2.model.product;
import demo2.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addProducts")
    @ResponseBody
    public void addProducts(@RequestParam("Name") String Name, @RequestParam("ImageURL")String ImageURL, @RequestParam("Price")int Price, @RequestParam("Description")String Description){

        productmanager.addProducts(Name, ImageURL, Price, Description);


    }


}
