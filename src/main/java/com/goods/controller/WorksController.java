package com.goods.controller;

import com.goods.entities.Works;
import com.goods.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/works")
public class WorksController {
    @Autowired
    WorksService worksService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @GetMapping("/createWork")
    public void createWork(@RequestBody String workName,Double norma,Integer count,Integer goodId){
        worksService.createWork(workName,norma,count,goodId);
    }

    @GetMapping("/getAll")
    public List<Works> getAll(){
        return worksService.getAll();
    }
}
