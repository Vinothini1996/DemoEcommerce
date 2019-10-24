package com.test.ecommercedemo.Controller;

import com.test.ecommercedemo.PojoClass.ProductPojo;
import com.test.ecommercedemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listProducts")
    List<ProductPojo> ListProducts() { return productService.ListProducts(); }

    @GetMapping("/getProduct/{id}")
    ProductPojo findProduct(@PathVariable("id") int id){ return productService.findProductById(id); }

    @PostMapping("/addProduct")
    void addUser(@RequestBody ProductPojo productPojo){  productService.addProduct(productPojo);}
}
