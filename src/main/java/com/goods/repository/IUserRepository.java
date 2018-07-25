package com.goods.repository;

import com.goods.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
    User getUsersByUsername(String username);
}
