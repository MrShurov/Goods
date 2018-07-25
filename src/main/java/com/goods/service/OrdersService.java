package com.goods.service;

import com.goods.entities.Orders;
import com.goods.repository.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final
    IOrdersRepository ordersRepository;
    private final
    UserService userService;

    @Autowired
    public OrdersService(IOrdersRepository ordersRepository, UserService userService) {
        this.ordersRepository = ordersRepository;
        this.userService = userService;
    }

    public Orders createOrder(Integer userId) {
        Orders order = new Orders(userService.getUserById(userId));
        ordersRepository.save(order);
        return order;
    }

    public List<Orders> getAll() {
        return (List<Orders>) ordersRepository.findAll();
    }

    public Orders getOrderById(Integer id) {
        Optional<Orders> order = ordersRepository.findById(id);
        return order.get();
    }

}
