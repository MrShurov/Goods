package com.goods.controller;

import com.goods.entities.Orders;
import com.goods.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @GetMapping("/createOrder")
    public void createOrder(@RequestBody Integer userId, String createDate) throws java.text.ParseException{
        ordersService.createOrder(userId,ordersService.getDateFromString(createDate));
    }

    @GetMapping("/getAll")
    public List<Orders> getAll(){
        return ordersService.getAll();
    }
}
