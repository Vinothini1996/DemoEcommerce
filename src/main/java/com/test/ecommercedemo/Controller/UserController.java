package com.test.ecommercedemo.Controller;

import com.test.ecommercedemo.PojoClass.OrderByCartPojo;
import com.test.ecommercedemo.PojoClass.OrderPostPojo;
import com.test.ecommercedemo.PojoClass.OrdersPojo;
import com.test.ecommercedemo.PojoClass.UserPojo;
import com.test.ecommercedemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listusers")
    List<UserPojo> ListUsers(){
        return userService.ListUsers();
    }

    @GetMapping("/getuser/{id}")
    UserPojo findUser(@PathVariable("id") Integer id){ return userService.findUserById(id); }

    @GetMapping("/ordersbyuserid/{id}")
    List<OrdersPojo> listOrder(@PathVariable("id") Integer userId){ return userService.listOrderByUserId(userId);}

    @PostMapping("/adduser")
    void addUser(@RequestBody UserPojo userPojo){ userService.addUser(userPojo);}

    @PostMapping("/buyproduct")
    void buyProduct(@RequestBody OrderPostPojo order1Pojo){ userService.buyProduct(order1Pojo); }

    @PostMapping("/buyfromcart")
    void buyFromCart(@RequestBody OrderByCartPojo orderByCartPojo){ userService.buyFromCart(orderByCartPojo);}

}
