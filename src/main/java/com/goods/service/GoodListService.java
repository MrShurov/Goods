package com.goods.service;

import com.goods.entities.Goods;
import com.goods.entities.Goodslist;
import com.goods.entities.Orders;
import com.goods.repository.IGoodListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodListService {
    @Autowired
    IGoodListRepository goodListRepository;
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrdersService ordersService;

    public Goodslist getGoodListById(Integer id){
        Optional<Goodslist> goodsList = goodListRepository.findById(id);
        return goodsList.get();
    }

    public void createGoodList(Integer goods, Integer orders, int count, String length, String width, String height, String depth){
        Goodslist goodslist = new Goodslist(null,null,count,length,width,height,depth);
        goodslist.setGoods(goodsService.getGoodById(goods));
        goodslist.setOrders(ordersService.getOrderById(orders));
        goodListRepository.save(goodslist);
    }
}