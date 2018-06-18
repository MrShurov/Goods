package com.goods.service;

import com.goods.entities.Details;
import com.goods.repository.IDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailsService {

    @Autowired
    IDetailsRepository detailsRepository;

    public void createDetail(String detailName, double price){
        Details detail = new Details(detailName,price);
        detailsRepository.save(detail);
    }

    public void setDetailPrice(Integer detailId, double price){
        Optional<Details> details = detailsRepository.findById(detailId);
        Details detail = details.get();
        detail.setPrice(price);
        detailsRepository.save(detail);
    }
}
