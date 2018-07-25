package com.goods.service;

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
    MaterialsService materialsService;

    private Double calculateWorks(Map<String, Object> mapObject) {
        Double sumNorma = 0.0;
        Works work = worksService.getWorksByWorkName("Заготовительные");
        Double norma = (0.15 + 0.15 * (Integer) mapObject.get("count")) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Штамповочные");
        norma = (0.1 + 0.15 * (Integer) mapObject.get("count")) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Гибочные");
        norma = (0.15 + 0.2 * (Integer) mapObject.get("count")) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Слесарно-сварочные (контактная сварка)");
        norma = 0.3 * (Integer) mapObject.get("count") * work.getCount() * (Integer) mapObject.get("count");
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Обварка");
        norma = 0.0002 * (Integer) mapObject.get("length") * work.getCount() * (Integer) mapObject.get("count");
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Полимерная");
        if (mapObject.get("type").equals("полимер")) {
            norma = 0.15 * (Integer) mapObject.get("count") * work.getCount();
        } else {
            norma = (double) 0;
        }
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Слесарные(зачистка полировка)");
        norma = (0.05 + 0.05 * (Integer) mapObject.get("count")) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Комплектовочные");
        norma = 0.1 * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Упаковочные");
        norma = (0.15 * (Integer) mapObject.get("count")) * work.getCount();
        sumNorma += norma;
        work = worksService.getWorksByWorkName("Транспортные");
        norma = 0.2;
        sumNorma += norma;
        return sumNorma;
    }

    private Map<String, Double> calculateDetails(Map<String, Object> mapObject) {
        Map<String, Double> map = new HashMap<String, Double>();
        Double norma = ((Integer) mapObject.get("length") / (Integer) mapObject.get("count") + 21) * ((Integer) mapObject.get("depth") + 40) * 0.8 * 1.1 * 8 * (Integer) mapObject.get("count") / 1000000;
        map.put("Стенка  передняя 0,8", norma);
        norma = ((Integer) mapObject.get("width") - 56) * (((Integer) mapObject.get("length") / (Integer) mapObject.get("count") - 36) + (Integer) mapObject.get("depth") * 2 - 4 + 64 - 4) * 0.8 * 1.1 * 8 * (Integer) mapObject.get("count") / 1000000;
        map.put("Скоба 0,8", norma);
        norma = ((Integer) mapObject.get("length") / (Integer) mapObject.get("count") + 21) * ((Integer) mapObject.get("depth") + 78) * 0.8 * 8 * 1.1 * (Integer) mapObject.get("count") / 1000000;
        map.put("Стенка задняя 0,8", norma);
        if (mapObject.get("type").equals("полимер")) {
            norma = (496 * ((Integer) mapObject.get("width") * 2 - 54) * 7.85 * 0.8 * 1.1) / 1000000 * (Integer) mapObject.get("count");
        } else {
            norma = (496 * ((Integer) mapObject.get("width") * 2 - 54) * 0.8 * 8 * 1.1) / 1000000 * (Integer) mapObject.get("count");
        }
        map.put("обвязка (группа)", norma);
        if (mapObject.get("type").equals("полимер")) {
            norma = (77 * ((Integer) mapObject.get("height") - 30) * 1.2 * 7.85 * 1.1 * 4 * (Integer) mapObject.get("count")) / 1000000;
        } else {
            norma = (77 * ((Integer) mapObject.get("height") - 30) * 1.2 * 8 * 1.1 * 4 * (Integer) mapObject.get("count")) / 1000000;
        }
        map.put("Стойка 1,2 390.002.002", norma);
        norma = (496.0 * ((Integer) mapObject.get("width") - 54) * 2 * (Integer) mapObject.get("count") / 1000000);
        map.put("КФ1", norma);
        norma = 77.0 * ((Integer) mapObject.get("height") - 30) * 2 * 4 * (Integer) mapObject.get("count") / 1000000;
        map.put("КФ2", norma);
        return map;
    }

    private Double calculateMaterials(Map<String, Object> mapObject, Map<String, Double> map) {
        Double sum = 0.0;
        Double norma = 0.0;
        Materials materials = materialsService.getByName("Лист 0,8 ст 430");
        if (mapObject.get("type").equals("нерж")) {
            norma = map.get("Стенка  передняя 0,8") + map.get("Скоба 0,8") + map.get("Стенка задняя 0,8") + map.get("обвязка (группа)");
        } else {
            norma = map.get("Стенка  передняя 0,8") + map.get("Скоба 0,8") + map.get("Стенка задняя 0,8");
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 1,2 ст 430");
        if (mapObject.get("type").equals("нерж")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double) 0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 0,8 чёрн");
        if (mapObject.get("type").equals("полимер")) {
            norma = map.get("обвязка (группа)");
        } else {
            norma = (double) 0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 1,2 чёрн");
        if (mapObject.get("type").equals("полимер")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double) 0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 0,8 оцинк");
        if (mapObject.get("type").equals("оцинк")) {
            norma = map.get("обвязка (группа)");
        } else {
            norma = (double) 0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Лист 1,2 оцинк");
        if (mapObject.get("type").equals("оцинк")) {
            norma = map.get("Стойка 1,2 390.002.002");
        } else {
            norma = (double) 0;
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Тр. 25х25х1,2нерж");
        norma = (Integer) mapObject.get("count") * 0.08;
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Проволока сварочн.нерж.Ф1,2 кг");
        norma = ((Integer) mapObject.get("depth") * 4 * 0.22 / 1000 + (Integer) mapObject.get("width") * 2 * 0.22 / 1000 + 40 * 4 * 0.22 / 1000) * (Integer) mapObject.get("count") * 0.12;
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Вольфрам лантана Ф2 г");
        norma = ((Integer) mapObject.get("depth") * 4 * 0.22 / 1000 + (Integer) mapObject.get("width") * 2 * 0.22 / 1000 + 40 * 4 * 0.22 / 1000) * (Integer) mapObject.get("count");
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Газ аргон л");
        norma = ((Integer) mapObject.get("depth") * 4 * 0.22 / 1000 + (Integer) mapObject.get("width") * 2 * 0.22 / 1000 + 40 * 4 * 0.22 / 1000) * (Integer) mapObject.get("count") * 170 / 0.27;
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Опора пластиковая уголок 40х40 с грибком (Лида)");
        norma = (double) (4 * (Integer) mapObject.get("count"));
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Сифон универсальный");
        norma = (Integer) mapObject.get("count") * 1.0;
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Порошковая краска 7035 89/70220");
        if (mapObject.get("type").equals("полимер")) {
            norma = ((map.get("КФ1") + map.get("КФ2")) * 0.11);
        }
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Винт ww М5х16 КВ-РН");
        norma = (Integer) mapObject.get("count") * 16.0;
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Гайка М5");
        norma = (Integer) mapObject.get("count") * 16.0;
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Болт М6х40");
        norma = (Integer) mapObject.get("count") * 3.0;
        sum += norma * materials.getPrice();
        materials = materialsService.getByName("Гайка М6");
        norma = (Integer) mapObject.get("count") * 3.0;
        sum += norma * materials.getPrice();
        return sum;
    }

    @SuppressWarnings("Duplicates")
    private Double getLaborIntensity(Double works, Map<String, Object> object) {
        if ((Integer) object.get("count") > 30) {
            return works * 0.75;
        } else if ((Integer) object.get("count") > 20) {
            return works * 0.8;
        } else if ((Integer) object.get("count") > 10) {
            return works * 0.9;
        } else return works;
    }

    public Double finalePrice(Map<String, Object> object) {
        Double works = calculateWorks(object);
        works = getLaborIntensity(works, object);
        Map<String, Double> map = calculateDetails(object);
        Double materials = calculateMaterials(object, map);
        return (materials + works * 6) * 1.3;
    }
}
