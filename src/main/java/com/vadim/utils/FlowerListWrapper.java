package com.vadim.utils;

import com.vadim.model.Flower;

import java.util.List;
import java.util.Objects;

public class FlowerListWrapper {

    private static List<Flower> flowers;

    private FlowerListWrapper() {
    }

    public static List<Flower> getFlowers(boolean isReadOnly) {
        if (isReadOnly) {
            if (Objects.isNull(flowers)) {
                flowers = JsonMapper.getFlowers();
            }
            return flowers;
        }
        return JsonMapper.getFlowers();
    }
}
