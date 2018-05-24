package com.goods.service;

import com.goods.entities.Goods;
import com.goods.repository.IGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private IGoodsRepository goodsRepository;

    public void createGood(String goodName){
        goodsRepository.save(new Goods(goodName));
    }

    public List<Goods> getAll(){
        return (List<Goods>)goodsRepository.findAll();
    }

    public Goods getGoodByGoodName(String goodName){
        return goodsRepository.getGoodsByGoodName(goodName);
    }
}
