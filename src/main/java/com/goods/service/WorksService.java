package com.goods.service;

import com.goods.entities.Works;
import com.goods.repository.IWorksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksService {
    @Autowired
    IWorksRepository worksRepository;
    @Autowired
    GoodsService goodsService;

    public void createWork(String workName,Integer count,Integer goodId){
        Works work = new Works(goodsService.getGoodById(goodId),workName,count);
        worksRepository.save(work);
    }

    public List<Works> getAll(){
        return (List<Works>)worksRepository.findAll();
    }

    public Works getWorksByWorkName(String workName){
        return worksRepository.getWorksByWorkName(workName);
    }
}
