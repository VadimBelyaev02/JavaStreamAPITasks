package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);

        animals.stream()
                .filter(animal -> animal.getAge() > 30 && animal.getOrigin().startsWith("A"))
                .map(Animal::getOrigin)
                .distinct()
                .forEach(System.out::println);

    }
}
/*
  {"id":3,"bread":"Tern, arctic","age":28,"origin":"Oriya","gender":"Male"},
Задача №3 -
Отобрать всех животных старше 30 лет и вывести все страны происхождения без дубликатов начинающиеся на "A"

 */
