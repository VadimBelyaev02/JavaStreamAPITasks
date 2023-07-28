package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class Task8 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);

        OptionalInt optionalInt = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max();

        optionalInt.ifPresentOrElse(System.out::println, () -> System.out.println("Value is not present"));
    }
}
/*
Задача №8 -
Взять всех животных. Отсортировать их породу в стандартном порядке и взять первые 100.
Вывести в консоль возраст самого старого животного
 */
