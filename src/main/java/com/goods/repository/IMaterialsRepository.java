package com.goods.repository;

import com.goods.entities.Materials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialsRepository extends CrudRepository<Materials,Integer> {
    Materials getMaterialsByMaterialName(String materialName);
}
