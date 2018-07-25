package com.goods.controller;

import com.goods.entities.Orders;
import com.goods.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final
    OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Orders> createOrder(@RequestBody Integer userId) {
        return new ResponseEntity<>(ordersService.createOrder(userId), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Orders>> getAll() {
        return new ResponseEntity<>(ordersService.getAll(), HttpStatus.OK);
    }
}
