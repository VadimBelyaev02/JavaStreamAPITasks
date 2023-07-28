package com.vadim.utils;

import com.vadim.model.Animal;

import java.util.List;
import java.util.Objects;

public class AnimalListWrapper {

    private static List<Animal> animals;

    private AnimalListWrapper() {
    }

    public static List<Animal> getAnimals(boolean isReadOnly) {
        if (isReadOnly) {
            if (Objects.isNull(animals)) {
                animals = JsonMapper.getAnimals();
            }
            return animals;
        }
        return JsonMapper.getAnimals();
    }
}
