package com.test.ecommercedemo.Service;

import com.test.ecommercedemo.EntityModel.CartItems;
import com.test.ecommercedemo.EntityModel.Orders;
import com.test.ecommercedemo.EntityModel.Product;
import com.test.ecommercedemo.EntityModel.User;
import com.test.ecommercedemo.PojoClass.CartItemsPojo;
import com.test.ecommercedemo.PojoClass.OrdersPojo;
import com.test.ecommercedemo.PojoClass.ProductPojo;
import com.test.ecommercedemo.PojoClass.UserPojo;
import com.test.ecommercedemo.Repository.CartRepository;
import com.test.ecommercedemo.Repository.OrdersRepository;
import com.test.ecommercedemo.Repository.ProductRepository;
import com.test.ecommercedemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EcommerceService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrdersRepository orderRepository;

    public UserPojo getUserDetail(User user){
        UserPojo userPojo = new UserPojo();
        userPojo.setId(user.getId());
        userPojo.setName(user.getName());
        userPojo.setUsername(user.getUsername());
        userPojo.setPassword(user.getPassword());
        userPojo.setMobile_no(user.getMobileNo());
        userPojo.setEmail_id(user.getEmail_id());
        userPojo.setAddress(user.getAddress());
        userPojo.setZipcode(user.getZipcode());
        return userPojo;
    }

    public ProductPojo getProductDetail(Product product){
        ProductPojo productPojo=new ProductPojo();
        productPojo.setId(product.getId());
        productPojo.setName(product.getName());
        productPojo.setDescription(product.getDescription());
        productPojo.setPrice(product.getPrice());
        productPojo.setStock_available(product.getStock_available());
        return productPojo;
    }

/***--------------- Listing User Details   ---------***/
    public List<UserPojo> ListUserDetails() {
        List<User> userList = userRepository.findAll();
        List<UserPojo> userPojoList = new ArrayList<>();
        userList.forEach(user -> {
            UserPojo userPojo=getUserDetail(user);
            userPojoList.add(userPojo);
        });
        return userPojoList;
    }

/***----------- Find one user details by id  --------***/
    public UserPojo findUserById(int id){
        User user = userRepository.findById(id).get();
        return getUserDetail(user);
    }

/***--------- Listing Product Details  -----------***/
    public List<ProductPojo> ListProductDetails(){
        List<Product> productList = productRepository.findAll();
        List<ProductPojo> productPojoList=new ArrayList<>();
        productList.forEach(product -> {
            ProductPojo productPojo=getProductDetail(product);
            productPojoList.add(productPojo);
        });
        return productPojoList;
    }

/***--------- Find one product by id  -------------***/
    public ProductPojo findProductById(int id){
        Product product = productRepository.findById(id).get();
        ProductPojo productPojo = getProductDetail(product);
        return productPojo;
    }

/***----------- Listing cart items ------------***/
    public List<CartItemsPojo> listCartItems(){
        List<CartItems> cartItemsList = cartRepository.findAll();
        List<CartItemsPojo> cartItemsPojoList = new ArrayList<>();
        cartItemsList.forEach(cartItems -> {
            CartItemsPojo cartItemsPojo=new CartItemsPojo();
            cartItemsPojo.setId(cartItems.getId());
            cartItemsPojo.setUser_id(cartItems.getUser_id());
            cartItemsPojo.setProduct_id(cartItems.getProduct_id());
            cartItemsPojoList.add(cartItemsPojo);
        });
        return  cartItemsPojoList;
    }

/***------------- Listing Order details -------------***/
    public List<OrdersPojo> listOrder(){
        List<Orders> orderList = orderRepository.findAll();
        List<OrdersPojo> orderPojoList =new ArrayList<>();
        orderList.forEach(order -> {
            OrdersPojo orderPojo=new OrdersPojo();
            orderPojo.setId(order.getId());
            orderPojo.setUser_id(order.getUser_id());
            orderPojo.setDate(order.getDate());
            orderPojo.setTime(order.getTime());
            orderPojo.setDelivery_address(order.getDelivery_address());
            orderPojoList.add(orderPojo);
        });
        return orderPojoList;

    }
}
