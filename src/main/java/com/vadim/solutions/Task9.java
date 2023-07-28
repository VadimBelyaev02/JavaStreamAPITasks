package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task9 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);

        Optional<char[]> optionalChars = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .min(Comparator.comparing(array -> array.length));

        optionalChars.ifPresentOrElse(c -> System.out.println(c.length), () -> System.out.println("Value is not present"));
    }
}

/*
Задача №9 -
Взять всех животных. Преобразовать их в породы, а породы в []char
Вывести в консоль длину самого короткого массива
 */