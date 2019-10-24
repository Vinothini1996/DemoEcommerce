package com.test.ecommercedemo.Service;

import com.test.ecommercedemo.Entity.CartItems;
import com.test.ecommercedemo.Entity.Orders;
import com.test.ecommercedemo.Entity.User;
import com.test.ecommercedemo.PojoClass.CartItemsPojo;
import com.test.ecommercedemo.PojoClass.OrdersPojo;
import com.test.ecommercedemo.PojoClass.UserPojo;
import com.test.ecommercedemo.Repository.OrdersRepository;
import com.test.ecommercedemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrdersRepository orderRepository;

    private UserPojo getUserDetail(User user){
        UserPojo userPojo = new UserPojo();
        List<CartItemsPojo> cartItemsPojoList=new ArrayList<>();
        userPojo.setId(user.getId());
        userPojo.setName(user.getName());
        userPojo.setUsername(user.getUsername());
        userPojo.setPassword(user.getPassword());
        userPojo.setMobileNo(user.getMobileNo());
        userPojo.setEmailId(user.getEmailId());
        userPojo.setAddress(user.getAddress());
        userPojo.setZipCode(user.getZipCode());

//        user.getCartItems().forEach(cartItems -> {
//            cartItemsPojoList.add(getCartItemDetails(cartItems));
//        });
        //userPojo.setCartItemsPojo(cartItemsPojoList);
        return userPojo;
    }

//    public CartItemsPojo getCartItemDetails(CartItems cartItems){
//        CartItemsPojo cartItemsPojo=new CartItemsPojo();
//        cartItemsPojo.setId(cartItems.getId());
//        //cartItemsPojo.setUserId(cartItems.getUserId());
//        //cartItemsPojo.setProductId(cartItems.getProductId());
//        return cartItemsPojo;
//    }


    public List<UserPojo> ListUsers() {
        List<User> userList = userRepository.findAll();
        List<UserPojo> userPojoList = new ArrayList<>();
        userList.forEach(user -> {
            UserPojo userPojo=getUserDetail(user);
            userPojoList.add(userPojo);
        });
        return userPojoList;
    }


    public UserPojo findUserById(int id){
        User user = userRepository.findById(id).get();
        return getUserDetail(user);
    }


    public List<OrdersPojo> listOrderByUserId(Integer userId) {
        List<Orders> orderList = orderRepository.findByUserId(userId);
//        List<OrdersPojo> orderPojoList = new ArrayList<>();
//        orderList.forEach(order -> {
//            OrdersPojo orderPojo = new OrdersPojo();
//            orderPojo.setId(order.getId());
//            orderPojo.setUserId(order.getUserId());
//            orderPojo.setDate(order.getDate());
//            orderPojo.setTime(order.getTime());
//            orderPojo.setDeliveryAddress(order.getDeliveryAddress());
//            orderPojoList.add(orderPojo);
//        });

        List<OrdersPojo> ordersPojos=orderList.stream().map(this::mapOrder).collect(Collectors.toList());
        return ordersPojos;
    }

    private OrdersPojo mapOrder(Orders order){
        OrdersPojo orderPojo = new OrdersPojo();
        orderPojo.setId(order.getId());
        //orderPojo.setUserId(order.getUserId());
        orderPojo.setDate(order.getDate());
        //orderPojo.setTime(order.getTime());
        orderPojo.setDeliveryAddress(order.getDeliveryAddress());

        return orderPojo;
    }

    public void addUser(UserPojo userPojo){
        User user=new User();
        user.setName(userPojo.getName());
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        user.setMobileNo(userPojo.getMobileNo());
        user.setEmailId(userPojo.getEmailId());
        user.setAddress(userPojo.getAddress());
        user.setZipCode(userPojo.getZipCode());
        userRepository.save(user);
    }


}
