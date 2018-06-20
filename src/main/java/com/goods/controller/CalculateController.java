package com.goods.controller;

import com.goods.service.CalculateBathsForWashingDemountable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculateController {
    @Autowired
    CalculateBathsForWashingDemountable calculateBathsForWashingDemountable;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @GetMapping("/bath")
    public Double createGood(@RequestBody int count, String type, Double length, Double width, Double height, Double depth){
        return calculateBathsForWashingDemountable.finalePrice(count,type,length,width,height,depth);
    }
}
