package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.List;

public class Task7 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);
        String origin = "Oceania";

        boolean noneMatch = animals
                .stream()
                .noneMatch(animal -> animal.getOrigin().equals(origin));
        System.out.println(noneMatch);
    }
}
/*
Задача №7 -
        Взять всех животных. Узнать что ни одно из них не имеет страну происхождения Oceania.
        Ответ вывести в консоль
*/