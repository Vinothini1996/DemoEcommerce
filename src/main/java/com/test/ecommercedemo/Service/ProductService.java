package com.test.ecommercedemo.Service;

import com.test.ecommercedemo.Entity.Orders;
import com.test.ecommercedemo.Entity.Product;
import com.test.ecommercedemo.Entity.User;
import com.test.ecommercedemo.PojoClass.OrdersPojo;
import com.test.ecommercedemo.PojoClass.ProductPojo;
import com.test.ecommercedemo.Repository.ProductRepository;
import com.test.ecommercedemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductPojo getProductDetail(Product product){
        ProductPojo productPojo=new ProductPojo();
        productPojo.setId(product.getId());
        productPojo.setName(product.getName());
        productPojo.setDescription(product.getDescription());
        productPojo.setPrice(product.getPrice());
        productPojo.setStockAvailable(product.getStockAvailable());
        return productPojo;
    }

    public List<ProductPojo> ListProducts(){
        List<Product> productList = productRepository.findAll();
        List<ProductPojo> productPojoList=new ArrayList<>();
        productList.forEach(product -> {
            ProductPojo productPojo=getProductDetail(product);
            productPojoList.add(productPojo);
        });
        return productPojoList;
    }

//    public ProductPojo findProductById(int id){
//        Product product = productRepository.findById(id).get();
//        ProductPojo productPojo = getProductDetail(product);
//        return productPojo;
//    }
    public ProductPojo findProductById(int id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            ProductPojo productPojo = getProductDetail(product.get());
            return productPojo;
        }
        return null;
    }


    public void addProduct(ProductPojo productPojo){
        Product product=new Product();
        product.setName(productPojo.getName());
        product.setDescription(productPojo.getDescription());
        product.setPrice(productPojo.getPrice());
        product.setStockAvailable(productPojo.getStockAvailable());
        productRepository.save(product);
    }



}
