package ru.rsatu.mainpackage;

import ru.rsatu.testpackage.TestClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Class mTestClass = TestClass.class;
        getFields(mTestClass);
        getMethods(mTestClass);
        System.out.println("\nИерархия классов для " + mTestClass.getName());
        showHierarchy(mTestClass);
        System.out.println("\nВызов метода printStr1");
        callMethod(mTestClass, "printStr1");
        System.out.println("\nВызов метода printStr2");
        callMethod(mTestClass, "printStr2");
    }

    static void showHierarchy(Class<?> c) {
        if (c.getSuperclass() == null) {
            System.out.println(c.getName());
            return;
        }
        showHierarchy(c.getSuperclass());
        System.out.println(c.getName());
    }

    static void callMethod(Class mClass ,String methodName) {
        try {
            mClass.getMethod(methodName, null).invoke(null, null);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static void getFields(Class mTestClass){
        System.out.println("Поля класса " + mTestClass.getName());
        for (Field field : mTestClass.getFields()) {
            System.out.println(field);
        }

    }

    static void getMethods(Class mTestClass){
        System.out.println("\nМетоды класса " + mTestClass.getName());
        for (Method method : mTestClass.getMethods()) {
            System.out.println(method);
        }
    }
}
