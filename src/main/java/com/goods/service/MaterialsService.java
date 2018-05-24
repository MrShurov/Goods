package com.goods.service;

import com.goods.entities.Materials;
import com.goods.repository.IMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialsService {
    @Autowired
    private IMaterialsRepository materialsRepository;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private MeasureService measureService;

    public void createMaterial(String materialName, String goodName, String measureName,Boolean mandatory, Double price){
        Materials material = new Materials();
        material.setMaterialName(materialName);
        material.setGoods(goodsService.getGoodByGoodName(goodName));
        material.setMeasures(measureService.getMeasuresByMeasureName(measureName));
        material.setMandatory(mandatory);
        material.setPrice(price);
        materialsRepository.save(material);
    }

    public List<Materials> getAll(){
        return (List<Materials>)materialsRepository.findAll();
    }

    @Modifying
    @Query("update materials m set m.price = ?1 where materialname = ?2")
    public void updatePrice(Double price, String materialName){
    }

    public Materials getByName(String materialName){
        return materialsRepository.getMaterialsByMaterialName(materialName);
    }
}