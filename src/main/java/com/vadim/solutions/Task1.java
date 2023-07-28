package com.vadim.solutions;

import com.vadim.model.Animal;
import com.vadim.utils.AnimalListWrapper;

import java.util.Comparator;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        List<Animal> animals = AnimalListWrapper.getAnimals(true);

        animals.stream()
                .filter(a -> 10 < a.getAge() && a.getAge() < 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .limit(21)
                .skip(14)
                .forEach(System.out::println);
    }
}
//[{"id":2,"bread":"Antelope, roan","age":29,"origin":"Spanish","gender":"Male"},

/*
Задача №1 -
Из представленных животных отобрать все молодые особи от 10 до 20 лет и отсортировать по возрасту (по возрастанию)
далее - распределить по 7 на каждый зоопарк. Зоопарков неограниченное кол-во а вы - директор 3-го по счёту зоопарка.
Полученных животных вывести в консоль.
 */