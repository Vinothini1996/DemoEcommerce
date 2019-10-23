package com.test.ecommercedemo.Controller;

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

    @GetMapping("/listUsers")
    List<UserPojo> ListUsers(){
        return userService.ListUsers();
    }

    @GetMapping("/getUser/{id}")
    UserPojo findUser(@PathVariable("id") Integer id){ return userService.findUserById(id); }

    @GetMapping("/getOrderByUserId/{id}")
    List<OrdersPojo> listOrder(@PathVariable("id") Integer userId){ return userService.listOrderByUserId(userId);}

    @PostMapping("/addUser")
    void addUser(@RequestBody UserPojo userPojo){ userService.addUser(userPojo);}

}
