package com.goods.service;

import com.goods.entities.Orders;
import com.goods.repository.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    IOrdersRepository ordersRepository;
    @Autowired
    UserService userService;

    public void createOrder(Integer userId) {
        Orders order = new Orders(userService.getUserById(userId));
        ordersRepository.save(order);
    }

    public List<Orders> getAll() {
        return (List<Orders>) ordersRepository.findAll();
    }

    public Orders getOrderById(Integer id){
        Optional<Orders> order = ordersRepository.findById(id);
        return order.get();
    }

}
