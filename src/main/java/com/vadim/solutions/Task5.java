package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.List;

public class Task5 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);
        String origin = "Hungarian";

        boolean anyMatch = animals.stream()
                .filter(animal -> 20 < animal.getAge() && animal.getAge() < 30)
                .anyMatch(animal -> animal.getOrigin().equals(origin));
        System.out.println(anyMatch);
    }
}
//[{"id":2,"bread":"Antelope, roan","age":29,"origin":"Spanish","gender":"Male"},
/*
Задача №5 -
Взять всех животных возрастом 20 - 30 лет. Есть ли среди нах хоть один из страны Венгрия (Hungarian)?
Ответ вывести в консоль
 */