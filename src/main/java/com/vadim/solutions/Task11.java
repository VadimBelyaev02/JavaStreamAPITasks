package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.List;
import java.util.OptionalDouble;

public class Task11 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);
        String origin = "Indonesian";

        OptionalDouble optionalDouble = animals.stream()
                .filter(animal -> animal.getOrigin().equals(origin))
                .mapToInt(Animal::getAge)
                .average();

        optionalDouble.ifPresentOrElse(System.out::println, () -> System.out.println("No matching animals"));
    }
}
/*
Задача №11 -
Взять всех животных. Подсчитать средний возраст всех животных из индонезии (Indonesian). Вывести результат в консоль
 */