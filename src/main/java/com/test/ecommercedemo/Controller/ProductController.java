package com.test.ecommercedemo.Controller;

import com.test.ecommercedemo.PojoClass.OrdersPojo;
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

    @GetMapping("/listproducts")
    List<ProductPojo> ListProducts() { return productService.ListProducts(); }

    @GetMapping("/getproduct/{id}")
    ProductPojo findProduct(@PathVariable("id") int id){ return productService.findProductById(id); }

    @PostMapping("/addproduct")
    void addUser(@RequestBody ProductPojo productPojo){  productService.addProduct(productPojo);}

}
