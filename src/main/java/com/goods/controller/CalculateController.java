package com.goods.controller;

import com.goods.service.CalculateBathsForWashingDemountable;
import com.goods.service.CalculateBathsForWashingWelded;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/calculate")
public class CalculateController {
    @Autowired
    CalculateBathsForWashingDemountable calculateBathsForWashingDemountable;
    @Autowired
    CalculateBathsForWashingWelded calculateBathsForWashingWelded;

    @RequestMapping(value = "/BathDemountable", method = RequestMethod.POST, produces = "application/json")
    public Double calculateBathDemountable(@RequestBody Map<String, Object> object){
        return calculateBathsForWashingDemountable.finalePrice(object);
    }

    @RequestMapping(value = "/BathWelded", method = RequestMethod.POST, produces = "application/json")
    public Double calculateBathWelded(@RequestBody Map<String, Object> object){
        return calculateBathsForWashingWelded.finalePrice(object);
    }
}
