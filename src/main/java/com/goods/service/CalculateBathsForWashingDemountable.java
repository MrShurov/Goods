package com.goods.service;

import com.goods.entities.Details;
import com.goods.entities.Materials;
import com.goods.entities.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculateBathsForWashingDemountable {

    @Autowired
    WorksService worksService;
    @Autowired
    DetailsService detailsService;
    @Autowired
    MaterialsService materialsService;

    private Double calculateWorks(int count, String type){
        Double sumNorma = 0.0;
        Works work = worksService.worksRepository.getWorksByWorkName("Заготовительные");
        Double norma = (0.15 + 0.15 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Штамповочные");
        norma = (0.1 + 0.15 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Гибочные");
        norma = (0.15 + 0.2 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Слесарно-сварочные (контактная сварка)");
        norma = 0.3 * count * work.getCount() * count;
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Обварка");
        norma = 0.0002 * count * work.getCount() * count;
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Полимерная");
        if(type.equals("полимер")){
            norma = 0.15 * count * work.getCount();
        } else {
            norma = (double)0;
        }
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Слесарные(зачистка полировка)");
        norma = (0.05 + 0.05 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Комплектовочные");
        norma = 0.1 * work.getCount();
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Упаковочные");
        norma = (0.15 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.worksRepository.getWorksByWorkName("Транспортные");
        norma = 0.2 * work.getCount();
        sumNorma += norma;
        return sumNorma;
    }

    private Map<String,Double> calculateDetails(int count, String type, Double length, Double width, Double height, Double depth){
        Map<String,Double> map = new HashMap<String,Double>();
        Details details = detailsService.detailsRepository.getDetailsByDetailName("Стенка  передняя 0,8");
        Double norma = (length / count + 21) * (depth + 40) * 0.8 * 1.1 * 8 * count / 1000000;
        map.put(details.getDetailName(),norma);
        details = detailsService.detailsRepository.getDetailsByDetailName("Скоба 0,8");
        norma = (width - 56)*((length / count - 36)+ depth * 2 - 4 + 64 - 4)*0.8 * 1.1 * 8 * count / 1000000;
        map.put(details.getDetailName(),norma);
        details = detailsService.detailsRepository.getDetailsByDetailName("Стенка задняя 0,8");
        norma = (length / count + 21) * (depth + 78) * 0.8 * 8 * 1.1 * count / 1000000;
        map.put(details.getDetailName(),norma);
        details = detailsService.detailsRepository.getDetailsByDetailName("обвязка (группа)");
        if(type.equals("полимер")){
            norma = (496 * (width * 2 - 54)* 7.85 * 0.8 * 1.1) / 1000000 * count;
        } else {
            norma = (496 * (width * 2 - 54) * 0.8 * 8 * 1.1) / 1000000 * count;
        }
        map.put(details.getDetailName(),norma);
        details = detailsService.detailsRepository.getDetailsByDetailName("Стойка 1,2 390.002.002");
        if(type.equals("полимер")){
            norma = (77 * (height - 30 ) * 1.2 * 7.85 * 1.1 * 4 * count) / 1000000;
        } else {
            norma = (496 * (width * 2 - 54) * 0.8 * 8 * 1.1) / 1000000 * count;
        }
        map.put(details.getDetailName(),norma);
        return map;
    }

    private Double calculateMaterials(int count, String type, Double length, Double width, Double height, Double depth, Map<String,Double> map){
        Double sum = 0.0;
        Double norma = 0.0;
        Materials materials = materialsService.getByName("Лист 0,8  ст 430");
        if(type.equals("нерж")) {
            norma = map.get("Стенка  передняя 0,8") + map.get("Скоба 0,8") + map.get("Стенка задняя 0,8") + map.get("обвязка (группа)");
        } else {
            norma = map.get("Стенка  передняя 0,8") + map.get("Скоба 0,8") + map.get("Стенка задняя 0,8");
        }
        sum += norma;
        materials = materialsService.getByName("Лист 1,2 ст 430");
        if(type.equals("нерж")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double)0;
        }
        sum += norma;
        materials = materialsService.getByName("Лист 0,8 чёрн");
        if(type.equals("полимер")) {
            norma = map.get("обвязка (группа)");
        } else {
            norma = (double)0;
        }
        sum += norma;
        materials = materialsService.getByName("Лист 1,2 чёрн");
        if(type.equals("полимер")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double)0;
        }
        sum += norma;
        materials = materialsService.getByName("Лист 0,8 оцинк");
        if(type.equals("полимер")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double)0;
        }
        sum += norma;
        return sum;
    }
}
