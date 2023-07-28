package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.List;

public class Task6 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);
        String firstGender = "MALE";
        String secondGender = "FEMALE";

        boolean allMath = animals.stream()
                .allMatch(animal -> animal.getGender().equals(firstGender) || animal.getGender().equals(secondGender));
        System.out.println(allMath);
    }
}
/*
Задача №6 -
Взять всех животных. Все ли они пола Male и Female ?
Ответ вывести в консоль
 */