package com.goods.repository;

import com.goods.entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<Users,Integer> {
}
