package com.goods.controller;

import com.goods.entities.Materials;
import com.goods.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/material")
public class RestMaterialController {

    private final MaterialsService materialsService;

    @Autowired
    public RestMaterialController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @RequestMapping(value = "/updatePrice", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Materials> updatePrice(Double price, String materialName){
        return new ResponseEntity<>(materialsService.updatePrice(price,materialName), HttpStatus.OK);
    }
}
