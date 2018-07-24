package com.goods.controller;

import com.goods.entities.Materials;
import com.goods.service.MaterialsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MaterialController {

    @Autowired
    MaterialsService materialsService;

    @GetMapping("/material")
    public String getAll(Model model){
        model.addAttribute("materials",materialsService.getAll()) ;
        return "/material";
    }
}
