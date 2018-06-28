package com.goods.controller;

import com.goods.entities.Goods;
import com.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/createGood", method = RequestMethod.POST, produces = "application/json")
    public void createGood(@RequestBody String goodName){
        goodsService.createGood(goodName);
    }

    @GetMapping("/getAll")
    public List<Goods> getAll(){
        return goodsService.getAll();
    }
}
