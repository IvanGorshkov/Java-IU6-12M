package com.java.lab;

import java.util.Arrays;

// Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
public class Main {

    public static void main(String[] args) {
        var array = Arrays.stream(args)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        var gcdRes = array[0];
        for (var i = 1; i < args.length; i++)
            gcdRes = gcd(gcdRes, array[i]);
        System.out.println("НОД: " + gcdRes);

        var lcmRes = array[0];
        for (int i = 1; i < args.length; i++)
            lcmRes = lcm(lcmRes, array[i]);
        System.out.println("НОК: " + lcmRes);
    }

    public static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    public static int lcm(int a, int b) { return a / gcd(a,b) * b; }
}
