package com.goods.repository;

import com.goods.entities.Ordermaterials;
import org.springframework.data.repository.CrudRepository;

public interface IOrdermaterialsRepository extends CrudRepository<Ordermaterials,Integer> {
}
