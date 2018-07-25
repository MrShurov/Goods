package com.goods.service;

import com.goods.entities.Works;
import com.goods.repository.IWorksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorksService {
    private final
    IWorksRepository worksRepository;

    @Autowired
    public WorksService(IWorksRepository worksRepository) {
        this.worksRepository = worksRepository;
    }

    Works getWorksByWorkName(String workName) {
        return worksRepository.getWorksByWorkName(workName);
    }
}
