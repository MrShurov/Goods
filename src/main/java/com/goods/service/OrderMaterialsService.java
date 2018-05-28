package com.goods.service;

import com.goods.entities.Ordermaterials;
import com.goods.repository.IOrdermaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMaterialsService {
    @Autowired
    IOrdermaterialsRepository ordermaterialsRepository;
    @Autowired
    GoodListService goodListService;
    @Autowired
    MaterialsService materialsService;

    public void createOrderMaterial(Integer goodListId, Integer materialId, Double koefficient, double price, double total) {
        Ordermaterials ordermaterial = new Ordermaterials(goodListService.getGoodListById(goodListId),materialsService.getMaterialById(materialId),koefficient,price,total);
        ordermaterialsRepository.save(ordermaterial);
    }

    public List<Ordermaterials> getAll(){
        return (List<Ordermaterials>)ordermaterialsRepository.findAll();
    }
}
