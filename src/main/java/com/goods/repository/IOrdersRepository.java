package com.goods.repository;

import com.goods.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface IOrdersRepository extends CrudRepository<Orders, Integer> {
}
