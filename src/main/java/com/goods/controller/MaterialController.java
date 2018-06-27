package com.goods.controller;

import com.goods.entities.Materials;
import com.goods.service.MaterialsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialsService materialsService;

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
