package com.vadim.utils;

import com.vadim.model.Car;

import java.util.List;
import java.util.Objects;

public class CarListWrapper {

    private static List<Car> cars;

    private CarListWrapper() {
    }

    public static List<Car> getCars(boolean isReadOnly) {
        if (isReadOnly) {
            if (Objects.isNull(cars)) {
                cars = JsonMapper.getCars();
            }
            return cars;
        }
        return JsonMapper.getCars();
    }
}
