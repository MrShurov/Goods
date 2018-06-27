package com.goods.service;

import com.goods.entities.Materials;
import com.goods.entities.Works;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculateBathsForWashingDemountable {

    @Autowired
    WorksService worksService;
    @Autowired
    MaterialsService materialsService;

    /*private Double calculateWorks(Map<String,Object> mapObject){
        Double sumNorma = 0.0;
        Works work = worksService.getWorksByWorkName("Заготовительные");
        Double norma = (0.15 + 0.15 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Штамповочные");
        norma = (0.1 + 0.15 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Гибочные");
        norma = (0.15 + 0.2 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Слесарно-сварочные (контактная сварка)");
        norma = 0.3 * count * work.getCount() * count;
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Обварка");
        norma = 0.0002 * count * work.getCount() * count;
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Полимерная");
        if(type.equals("полимер")){
            norma = 0.15 * count * work.getCount();
        } else {
            norma = (double)0;
        }
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Слесарные(зачистка полировка)");
        norma = (0.05 + 0.05 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Комплектовочные");
        norma = 0.1 * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Упаковочные");
        norma = (0.15 * count) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Транспортные");
        norma = 0.2 * work.getCount();
        sumNorma += norma;
        return sumNorma;
    }

    private Map<String,Double> calculateDetails(Map<String,Object> mapObject){
        Map<String,Double> map = new HashMap<String,Double>();
        Double norma = (length / count + 21) * (depth + 40) * 0.8 * 1.1 * 8 * count / 1000000;
        map.put("Стенка  передняя 0,8",norma);
        norma = (width - 56)*((length / count - 36)+ depth * 2 - 4 + 64 - 4)*0.8 * 1.1 * 8 * count / 1000000;
        map.put("Скоба 0,8",norma);
        norma = (length / count + 21) * (depth + 78) * 0.8 * 8 * 1.1 * count / 1000000;
        map.put("Стенка задняя 0,8",norma);
        if(type.equals("полимер")){
            norma = (496 * (width * 2 - 54)* 7.85 * 0.8 * 1.1) / 1000000 * count;
        } else {
            norma = (496 * (width * 2 - 54) * 0.8 * 8 * 1.1) / 1000000 * count;
        }
        map.put("обвязка (группа)",norma);
        if(type.equals("полимер")){
            norma = (77 * (height - 30 ) * 1.2 * 7.85 * 1.1 * 4 * count) / 1000000;
        } else {
            norma = (496 * (width * 2 - 54) * 0.8 * 8 * 1.1) / 1000000 * count;
        }
        map.put("Стойка 1,2 390.002.002",norma);
        return map;
    }

    private Double calculateMaterials(Map<String,Object> mapObject, Map<String,Double> map){
        Double sum = 0.0;
        Double norma = 0.0;
        Materials materials = materialsService.getByName("Лист 0,8 ст 430");
        if(type.equals("нерж")) {
            norma = map.get("Стенка  передняя 0,8") + map.get("Скоба 0,8") + map.get("Стенка задняя 0,8") + map.get("обвязка (группа)");
        } else {
            norma = map.get("Стенка  передняя 0,8") + map.get("Скоба 0,8") + map.get("Стенка задняя 0,8");
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 1,2 ст 430");
        if(type.equals("нерж")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double)0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 0,8 чёрн");
        if(type.equals("полимер")) {
            norma = map.get("обвязка (группа)");
        } else {
            norma = (double)0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 1,2 чёрн");
        if(type.equals("полимер")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double)0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 0,8 оцинк");
        if(type.equals("оцинк")) {
            norma = map.get("обвязка (группа)");
        } else {
            norma = (double)0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 1,2 оцинк");
        if(type.equals("оцинк")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double)0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Тр. 25х25х1,2нерж");
        norma = count * 0.08;
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Проволока сварочн.нерж.Ф1,2 кг");
        norma = count * 0.12;
        sum += norma * materials.getPrice();
        return sum;
    }

    public Double finalePrice(JSONObject object){
        Map<String,Object> mapObject = object.toMap();
        Double works = calculateWorks(mapObject);
        Map<String,Double> map = calculateDetails(mapObject);
        Double materials = calculateMaterials(mapObject, map);
        return (materials + works * 6) * 1.3;
    }*/
}
