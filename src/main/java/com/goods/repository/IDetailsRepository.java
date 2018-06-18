package com.goods.repository;

import com.goods.entities.Details;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailsRepository extends CrudRepository<Details,Integer> {
}
