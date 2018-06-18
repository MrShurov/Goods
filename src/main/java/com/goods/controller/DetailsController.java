package com.goods.controller;

import com.goods.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    private DetailsService detailsService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @GetMapping("/createDetail")
    public void createDetail(String detailName, double price){
        detailsService.createDetail(detailName,price);
    }

    @GetMapping("/updatePrice")
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public void setDetailPrice(Integer detailId, double price){
        detailsService.setDetailPrice(detailId,price);
    }
}
