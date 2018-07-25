package com.goods.repository;

import com.goods.entities.Works;
import org.springframework.data.repository.CrudRepository;

public interface IWorksRepository extends CrudRepository<Works, Integer> {
    Works getWorksByWorkName(String workName);
}
