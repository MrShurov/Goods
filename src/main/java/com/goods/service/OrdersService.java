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

    public Date getDateFromString(String createDate) throws java.text.ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.mm.yyyy");
        return format.parse(createDate);

    }

    public void createOrder(Integer userId, Date createDate) {
        Orders order = new Orders(userService.getUserById(userId), createDate);
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
