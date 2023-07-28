package com.vadim.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.vadim.model.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

    public static final String ANIMALS_PATH = "src\\main\\resources\\animals.json";
    public static final String RECRUITS_PATH = "src\\main\\resources\\recruits.json";
    public static final String CARS_PATH = "src\\main\\resources\\cars.json";
    public static final String FLOWERS_PATH = "src\\main\\resources\\flowers.json";
    public static final String PERFORMERS_PATH = "src\\main\\resources\\performers.json";
    public static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");


    public static List<Animal> getAnimals() {
        try {
            return newMapper().readValue(new File(ANIMALS_PATH), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Recruit> getRecruits() {
        try {
            return newMapper().readValue(new File(RECRUITS_PATH), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Car> getCars() {
        try {
            return newMapper().readValue(new File(CARS_PATH), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Flower> getFlowers() {
        try {
            return newMapper().readValue(new File(FLOWERS_PATH), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Performer> getPerformers() {
        try {
            return newMapper().readValue(new File(PERFORMERS_PATH), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObjectMapper newMapper() {
        final ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(df);
        mapper.setLocale(Locale.ENGLISH);
        mapper.registerModule(new Jdk8Module());
//        mapper.registerModule(new SimpleModule());
        return mapper;
    }

}
