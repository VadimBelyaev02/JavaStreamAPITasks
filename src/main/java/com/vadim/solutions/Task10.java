package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.List;

public class Task10 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);

        int sumOfAges = animals.stream()
                .mapToInt(Animal::getAge)
                .reduce(0, Integer::sum);

        System.out.println(sumOfAges);
    }
}
/*
Задача №10 -
Взять всех животных. Подсчитать суммарный возраст всех животных. Вывести результат в консоль
 */