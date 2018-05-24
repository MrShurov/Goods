package com.goods.controller;

import com.goods.entities.Measures;
import com.goods.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measure")
public class MeasureController {
    @Autowired
    private MeasureService measureService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @GetMapping("/createMeasure")
    public void createMeasure(@RequestBody String goodMeasure){
        measureService.createMeasure(goodMeasure);
    }

    @GetMapping("/getAll")
    public List<Measures> getAll(){
        return measureService.getAll();
    }
}
