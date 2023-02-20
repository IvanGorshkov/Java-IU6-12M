package com.java.lab;

import java.util.Arrays;

// Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
public class Main {

    public static void main(String[] args) {
        Arrays.stream(args)
                .map(Integer::valueOf)
                .filter(value -> value > 99 && value < 1000)
                .filter(value ->
                                value.toString().charAt(0) != value.toString().charAt(1) &&
                                value.toString().charAt(1) != value.toString().charAt(2) &&
                                value.toString().charAt(2) != value.toString().charAt(0)
                        )
                .forEach(System.out::println);
    }
}
