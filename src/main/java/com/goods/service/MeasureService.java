package com.goods.service;

import com.goods.entities.Measures;
import com.goods.repository.IMeasuresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureService {
    @Autowired
    private IMeasuresRepository measuresRepository;

    public void createMeasure(String goodMeasure){
        measuresRepository.save(new Measures(goodMeasure));
    }

    public List<Measures> getAll(){
        return (List<Measures>)measuresRepository.findAll();
    }

    public Measures getMeasuresByMeasureName(String measureName){
        return measuresRepository.getMeasuresByMeasureName(measureName);
    }
}
