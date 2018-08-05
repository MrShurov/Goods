package com.goods.controller;

import com.goods.entities.Materials;
import com.goods.service.CreateDocumentService;
import com.goods.service.MaterialsService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.Map;

@RestController
@RequestMapping(value = "/material")
public class MaterialController {

    private final MaterialsService materialsService;

    @Autowired
    public MaterialController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @RequestMapping(value = "/updatePrice", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Materials> updatePrice(@RequestBody Map<String, Object> object) {
        return new ResponseEntity<>(materialsService.updatePrice(object), HttpStatus.OK);
    }
}
