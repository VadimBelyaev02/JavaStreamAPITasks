package com.vadim.solutions;

import com.vadim.model.Flower;
import com.vadim.utils.FlowerListWrapper;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Task14 {

    public static void main(String[] args) {
        List<Flower> flowers = FlowerListWrapper.getFlowers(true);
        char firstLetter = 'S';
        char lastLetter = 'C';
        Predicate<String> predicate = s -> s.equals("Glass") || s.equals("Aluminum") || s.equals("Steel");
        double waterPrice = 1.39;
        int years = 5;

        double result = flowers.stream()
                .filter(flower -> flower.getCommonName().charAt(0) == firstLetter
                        && flower.getCommonName().charAt(flower.getCommonName().length() - 1) == lastLetter
                        && flower.isShadePreferred() && flower.getFlowerVaseMaterial().stream().anyMatch(predicate))
                .sorted(Comparator.comparing(Flower::getOrigin, Comparator.reverseOrder())
                        .thenComparing(Comparator.comparingInt(Flower::getPrice).reversed())
                        .thenComparing(Comparator.comparingDouble(Flower::getWaterConsumptionPerDay).reversed()))
                .mapToDouble(flower -> flower.getPrice() + years * flower.getWaterConsumptionPerDay() * 365 * waterPrice)
                .sum();
        // task description is terrible so I except the answer to be zero
        System.out.println(result);
    }
}
/*
[{"id":2,"commonName":"Hetch Hetchy Monkeyflower","plantFamily":"Scrophulariaceae",
"waterConsumptionPerDay":2.76,"shadePreferred":false,"origin":"Central African Republic",
"price":765,"flowerVaseMaterial":["Granite","Plexiglass","Aluminum","Steel","Granite","Granite","Plastic"]},

Задача №14 -
Для оранжереи нужно подобрать растения соответствующие требованиям.
Во-первых, нужно произвести сложную сортировку каталога растений. Отсортировать их по странам происхождения в обратном порядке
После по стоимости и еще по водопотреблению в обратном порядке. Из этого списка взять растения название которых
от буквы "S" до буквы "C". Если растения тенелюбивые и им подходит горшок из стекла, алюминия или стали - то выбираем их.
Далее на каждое растение надо рассчитать стоимость растения + стоимость потребления воды за 5 лет c учётом того
что кубометр воды стоит 1.39 $. Суммировать общую стоимость обслуживания всех растений. Во сколько это обойдётся бюджету?

 */