package com.goods.repository;

import com.goods.entities.Goodslist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGoodListRepository extends CrudRepository<Goodslist,Integer> {
}
