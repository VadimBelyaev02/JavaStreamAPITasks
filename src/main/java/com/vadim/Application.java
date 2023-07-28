package com.vadim;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Application {
    public static void main(String[] args) throws ClassNotFoundException {
        String packageName = "com.vadim.solutions";
        Class<?> task1Class = Class.forName(packageName + ".Task1");
        Package pkg = task1Class.getPackage();

        List<Class<?>> classes = new ArrayList<>(getClassesInPackage(pkg.getName()));


        try {
            for (Class<?> clazz : classes) {
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println(clazz.getName());
                Method method = clazz.getDeclaredMethod("main", String[].class);
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object instance = constructor.newInstance();
                method.invoke(instance, (Object) args);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static List<Class<?>> getClassesInPackage(String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        String packagePath = packageName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            URL packageURL = classLoader.getResource(packagePath);
            File packageDir = new File(Objects.requireNonNull(packageURL).getFile());
            if (packageDir.exists()) {
                for (java.io.File file : Objects.requireNonNull(packageDir.listFiles())) {
                    if (file.isFile() && file.getName().endsWith(".class")) {
                        String className = packageName + "." + file.getName().substring(0, file.getName().lastIndexOf('.'));
                        Class<?> clazz = Class.forName(className);
                        classes.add(clazz);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classes;
    }
}