package fcu.fcu.controller;


import fcu.fcu.model.account;
import fcu.fcu.model.product;
import fcu.fcu.service.accountRegister;
import fcu.fcu.service.productservice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
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
