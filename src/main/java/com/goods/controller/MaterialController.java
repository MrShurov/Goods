package com.goods.controller;

import com.goods.entities.Materials;
import com.goods.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialsService materialsService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @GetMapping("/createMaterial")
    public void createGood(@RequestBody String materialName, String goodName, String measureName, Boolean mandatory, Double price){
        materialsService.createMaterial(materialName,goodName,measureName,mandatory,price);
    }

    @GetMapping("/getAll")
    public List<Materials> getAll(){
        return materialsService.getAll();
    }

    @GetMapping("/updatePrice")
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public void updatePrice(Double price, String materialName){
        materialsService.updatePrice(price,materialName);
    }
}
