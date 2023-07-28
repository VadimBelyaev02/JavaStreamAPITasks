package com.vadim.solutions;

import com.vadim.model.Car;
import com.vadim.utils.CarListWrapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task13 {

    public static void main(String[] args) {
        List<Car> cars = CarListWrapper.getCars(true);
        List<String> secondCountryBrands = Stream.of("BMW", "Lexus", "Chrysler", "Toyota").toList();
        List<String> fifthCountryColors = Stream.of("Yellow", "Red", "Green", "Blue").toList();

        Predicate<Car> isFirstCountry = car -> "Jaguar".equals(car.getCarMake()) || "White".equals(car.getColor());
        Predicate<Car> isSecondCountry = car -> car.getMass() <= 1500 || secondCountryBrands.stream().anyMatch(b -> b.equals(car.getCarMake()));
        Predicate<Car> isThirdCountry = car -> ("Black".equals(car.getColor()) && car.getMass() > 4000)
                || "GMC".equals(car.getCarMake()) || "Dodge".equals(car.getCarMake());
        Predicate<Car> isFourthCountry = car -> car.getReleaseYear() < 1982
                || "Civic".equals(car.getCarModel()) || "Cherokee".equals(car.getCarModel());
        Predicate<Car> isFifthCountry = car -> fifthCountryColors.stream().noneMatch(c -> c.equals(car.getColor()))
                || car.getPrice() > 40000;
        Predicate<Car> isSixthCountry = car -> Objects.nonNull(car.getVin()) && car.getVin().contains("59");

        Map<Integer, List<Map.Entry<Integer, Car>>> groupedCars = cars.stream()
                .map(car -> Map.entry(
                        isFirstCountry.test(car) ? 1 :
                                isSecondCountry.test(car) ? 2 :
                                        isThirdCountry.test(car) ? 3 :
                                                isFourthCountry.test(car) ? 4 :
                                                        isFifthCountry.test(car) ? 5 :
                                                                isSixthCountry.test(car) ? 6 : 7, car))
                .filter(entry -> entry.getKey() < 7)
                .collect(Collectors.groupingBy(Map.Entry::getKey));

        double costsSum = groupedCars.values().stream()
                .map(list -> list.stream()
                        .map(Map.Entry::getValue)
                        .mapToDouble(Car::getMass)
                        .sum() * 7.14)
                .peek(System.out::println)
                .mapToDouble(cost -> cost)
                .sum();

        System.out.println(costsSum);
    }
}

/*
[{"id":2,"vin":"KMHDB8AE9BU199951","carMake":"Ford","carModel":"Mustang","releaseYear":2009,"color":"Goldenrod",
"mass":3716,"price":43736},

Задача №13 -
Из перечня автомобилей приходящих на рынок Азии логистическому агентству предстоит отсортировать их в порядке следования
1.Туркменистан - 2.Узбекистан - 3.Казахстан - 4.Кыргызстан - 5.Россия - 6.Монголия.
Все автомобили марки "Jaguar" а так же все авто цвета White идут в первую страну.
Из оставшихся все автомобили с массой до 1500 кг и марок BMW, Lexus, Chrysler и Toyota идут во второй эшелон.
Из оставшихся все автомобили Черного цвета с массой более 4000 кг и все GMC и Dodge идут в третий эшелон.
Из оставшихся все автомобили года выпуска до 1982 или все модели "Civic" и "Cherokee" идут в четвёртый эшелон.
Из оставшихся все автомобили цветов НЕ Yellow, Red, Green и Blue или же по стоимости дороже 40000 в пятый эшелон
Из оставшиеся все автомобили в vin номере которых есть цифра "59" идут в последний шестой эшелон.
Оставшиеся автомобили отбрасываем, они никуда не идут.
Измерить суммарные массы автомобилей всех эшелонов для каждой из стран и подсчитать сколько для каждой страны
будет стоить транспортные расходы если учесть что на 1 тонну транспорта будет потрачено 7.14 $.
Вывести суммарные стоимости в консоль. Вывести общую выручку логистической кампании.

 */