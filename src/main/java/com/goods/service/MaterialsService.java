package com.goods.service;

import com.goods.entities.Materials;
import com.goods.repository.IMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MaterialsService {
    private final IMaterialsRepository materialsRepository;

    @Autowired
    public MaterialsService(IMaterialsRepository materialsRepository) {
        this.materialsRepository = materialsRepository;
    }

    public List<Materials> getAll() {
        return (List<Materials>) materialsRepository.findAll();
    }

    public Materials updatePrice(Map<String, Object> object) {
        Materials material = materialsRepository.getMaterialsByMaterialName((String) object.get("materialName"));
        material.setPrice((Double) object.get("price"));
        materialsRepository.save(material);
        return material;
    }

    Materials getByName(String materialName) {
        return materialsRepository.getMaterialsByMaterialName(materialName);
    }

    public Materials getMaterialById(Integer id) {
        Optional<Materials> material = materialsRepository.findById(id);
        return material.get();
    }
}
