package com.goods.repository;

import com.goods.entities.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGoodsRepository extends CrudRepository<Goods, Integer> {
    Goods getGoodsByGoodName(String goodName);
}
