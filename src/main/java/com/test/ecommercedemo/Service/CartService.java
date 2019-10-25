package com.test.ecommercedemo.Service;

import com.test.ecommercedemo.Entity.CartItems;
import com.test.ecommercedemo.Entity.User;
import com.test.ecommercedemo.PojoClass.CartItemsPojo;
import com.test.ecommercedemo.PojoClass.ProductPojo;
import com.test.ecommercedemo.PojoClass.UserPojo;
import com.test.ecommercedemo.Repository.CartRepository;
import com.test.ecommercedemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CartItemsPojo> getCartDetails(int userId) {
        Optional<User> user= userRepository.findById(userId);
        if(user.isPresent()) {
            List<CartItems> cartItemsList=cartRepository.findByUser(user.get());
            List<CartItemsPojo> cartItemsPojoList=new ArrayList<>();
            cartItemsList.forEach(cartItems -> {
                CartItemsPojo cartItemsPojo=new CartItemsPojo();
                cartItemsPojo.setId(cartItems.getId());
                cartItemsPojo.setUser(new UserPojo(cartItems.getUser().getId(), cartItems.getUser().getName(),cartItems.getUser().getUsername(),cartItems.getUser().getPassword(),cartItems.getUser().getMobileNo(),cartItems.getUser().getEmailId(),cartItems.getUser().getAddress(),cartItems.getUser().getZipCode()));
                cartItemsPojo.setProduct(new ProductPojo(cartItems.getProduct().getId(), cartItems.getProduct().getName(),cartItems.getProduct().getDescription(),cartItems.getProduct().getPrice(),cartItems.getProduct().getStockAvailable()));
                cartItemsPojoList.add(cartItemsPojo);
            });
            return cartItemsPojoList;
        }
        else {
            return null;
        }
    }

}
