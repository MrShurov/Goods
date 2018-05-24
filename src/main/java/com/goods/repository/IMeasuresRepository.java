package com.goods.repository;

import com.goods.entities.Measures;
import org.springframework.data.repository.CrudRepository;

public interface IMeasuresRepository extends CrudRepository<Measures,Integer> {
    Measures getMeasuresByMeasureName(String measureName);
}
