package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.List;

public class Task4 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);
        String gender = "Male";

        long cnt = animals.stream()
                .filter(animal -> animal.getGender().equals(gender))
                .count();
        System.out.println(cnt);
    }
}
//[{"id":2,"bread":"Antelope, roan","age":29,"origin":"Spanish","gender":"Male"},

//Подсчитать количество всех животных пола = Female. Вывести в консоль