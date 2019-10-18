package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.EntityModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
