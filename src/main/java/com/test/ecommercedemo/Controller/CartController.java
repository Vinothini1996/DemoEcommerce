package com.test.ecommercedemo.Controller;

import com.test.ecommercedemo.PojoClass.CartItemsPojo;
import com.test.ecommercedemo.Repository.CartRepository;
import com.test.ecommercedemo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("listcartbyuserid/{id}")
    List<CartItemsPojo> getCartDetailsByUserId(@PathVariable("id") int userId){ return cartService.getCartDetails(userId); }
}
