package com.goods.controller;

import com.goods.service.CalculateBathsForWashingDemountable;
import com.goods.service.CalculateBathsForWashingWelded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/calculate")
public class CalculateController {
    private final
    CalculateBathsForWashingDemountable calculateBathsForWashingDemountable;
    private final
    CalculateBathsForWashingWelded calculateBathsForWashingWelded;

    @Autowired
    public CalculateController(CalculateBathsForWashingDemountable calculateBathsForWashingDemountable, CalculateBathsForWashingWelded calculateBathsForWashingWelded) {
        this.calculateBathsForWashingDemountable = calculateBathsForWashingDemountable;
        this.calculateBathsForWashingWelded = calculateBathsForWashingWelded;
    }

    @RequestMapping(value = "/BathDemountable", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Double> calculateBathDemountable(@RequestBody Map<String, Object> object) {
        return new ResponseEntity<>(calculateBathsForWashingDemountable.finalePrice(object), HttpStatus.OK);
    }

    @RequestMapping(value = "/BathWelded", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Double> calculateBathWelded(@RequestBody Map<String, Object> object) {
        return new ResponseEntity<>(calculateBathsForWashingWelded.finalePrice(object), HttpStatus.OK);
    }
}
