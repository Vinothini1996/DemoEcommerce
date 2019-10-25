package com.test.ecommercedemo.Service;

import com.test.ecommercedemo.Entity.*;
import com.test.ecommercedemo.PojoClass.*;
import com.test.ecommercedemo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrdersRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CartRepository cartRepository;

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

    public void buyProduct(OrderPostPojo order1Pojo){
        Optional<User> user=userRepository.findById(order1Pojo.getUserPojo().getId());
        if(user.isPresent()) {
            Orders orders = new Orders();
            orders.setUser(user.get());
            orders.setDate(order1Pojo.getDate());
            orders.setDeliveryAddress(order1Pojo.getDeliveryAddress());
            Orders newOrder=orderRepository.save(orders);

            Optional<Product> product=productRepository.findById(order1Pojo.getProductPojo().getId());
            if(product.isPresent()) {
                OrderItems orderItems = new OrderItems();
                orderItems.setOrders(newOrder);
                orderItems.setProduct(product.get());
                orderItemRepository.save(orderItems);
            }

            PaymentDetails paymentDetails=new PaymentDetails();
            paymentDetails.setOrders(newOrder);
            paymentDetails.setPaymentType(order1Pojo.getPaymentPojo().getPaymentType());
            paymentDetails.setAmount(order1Pojo.getProductPojo().getPrice());
            paymentRepository.save(paymentDetails);

        }
    }

    public void buyFromCart(OrderByCartPojo orderByCartPojo){
        Optional<CartItems> cartItems=cartRepository.findById(orderByCartPojo.getCartItemsPojo().getId());
        if(cartItems.isPresent()){
            Orders orders = new Orders();
            Optional<User> optionalUser = userRepository.findById(cartItems.get().getUser().getId());
            orders.setUser(optionalUser.get());
            orders.setDate(orderByCartPojo.getDate());
            orders.setDeliveryAddress(orderByCartPojo.getDeliveryAddress());
            Orders newOrder=orderRepository.save(orders);

            OrderItems orderItems = new OrderItems();
            Optional<Product> optionalProduct = productRepository.findById(cartItems.get().getProduct().getId());
            orderItems.setOrders(newOrder);
            orderItems.setProduct(optionalProduct.get());
            orderItemRepository.save(orderItems);

            PaymentDetails paymentDetails=new PaymentDetails();
            paymentDetails.setOrders(newOrder);
            paymentDetails.setPaymentType(orderByCartPojo.getPaymentPojo().getPaymentType());
            paymentDetails.setAmount(orderByCartPojo.getProductPojo().getPrice());
            paymentRepository.save(paymentDetails);

        }
        cartRepository.delete(cartItems.get());
    }

}
