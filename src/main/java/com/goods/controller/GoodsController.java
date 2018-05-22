package com.goods.controller;

import com.goods.entities.Goods;
import com.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/test")
    public void test(){
        goodsService.test();
    }

    @GetMapping("/getAll")
    public List<Goods> getAll(){
        return goodsService.getAll();
    }
}
