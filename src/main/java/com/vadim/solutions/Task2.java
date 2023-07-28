package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);
        String origin = "Japanese";
        String gender = "Female";

        animals.stream()
                .filter(a -> a.getOrigin().equals(origin))
                .map(a -> a.getGender().equals(gender) ? a.getBread().toUpperCase() : a.getBread())
                .forEach(System.out::println);
    }
}
//[{"id":2,"bread":"Antelope, roan","age":29,"origin":"Spanish","gender":"Male"},
/*
Задача №2 -
Отобрать всех животных из Японии (Japanese) и записать породу UPPER_CASE в если пол Female
преобразовать к строкам породы животных и вывести в консоль
 */
