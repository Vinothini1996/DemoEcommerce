package com.test.ecommercedemo.Controller;

import com.test.ecommercedemo.PojoClass.CartItemsPojo;
import com.test.ecommercedemo.PojoClass.OrdersPojo;
import com.test.ecommercedemo.PojoClass.ProductPojo;
import com.test.ecommercedemo.PojoClass.UserPojo;
import com.test.ecommercedemo.Repository.UserRepository;
import com.test.ecommercedemo.Service.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
//@RequestMapping("/ecommerce")
public class EcommerceController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EcommerceService ecommerceService;

    @GetMapping("/users")
    List<UserPojo> ListUserDetails(){
        return ecommerceService.ListUserDetails();
    }

    @GetMapping("/user/{id}")
    UserPojo findUser(@PathVariable("id") int id){ return ecommerceService.findUserById(id); }

    @GetMapping("/products")
    List<ProductPojo> ListProductDetails() { return ecommerceService.ListProductDetails(); }

    @GetMapping("/product/{id}")
    ProductPojo findProduct(@PathVariable("id") int id){ return ecommerceService.findProductById(id); }

    @GetMapping("/cartItems")
    List<CartItemsPojo> listCartItems(){ return ecommerceService.listCartItems(); }

    @GetMapping("/orders")
    List<OrdersPojo> listOrder(){ return ecommerceService.listOrder();}
}
