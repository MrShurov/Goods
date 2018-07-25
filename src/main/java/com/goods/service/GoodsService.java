package com.goods.service;

import com.goods.entities.Goods;
import com.goods.repository.IGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsService {
    private final IGoodsRepository goodsRepository;

    @Autowired
    public GoodsService(IGoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public void createGood(String goodName) {
        goodsRepository.save(new Goods(goodName));
    }

    public List<Goods> getAll() {
        return (List<Goods>) goodsRepository.findAll();
    }

    public Goods getGoodByGoodName(String goodName) {
        return goodsRepository.getGoodsByGoodName(goodName);
    }

    public Goods getGoodById(Integer goodId) {
        Optional<Goods> good = goodsRepository.findById(goodId);
        return good.get();
    }
}
