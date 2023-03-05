package com.java.lab;

import java.util.Scanner;

class Fraction {
    int m, n;

    public Fraction() {
        this.m = 0;
        this.n = 1;
    }

    public Fraction(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public Fraction add(Fraction addedFraction) {
        var sum = new Fraction();
        sum.n = this.n * addedFraction.n;
        sum.m = m * addedFraction.n + addedFraction.m * n;
        return sum;
    }

    public Fraction multiply(Fraction multipliedFraction) {
        return new Fraction(
                m * multipliedFraction.m,
                n * multipliedFraction.n
        );
    }

    public Fraction subtract(Fraction subtractedFraction) {
        Fraction invertedFraction = new Fraction(-subtractedFraction.m, subtractedFraction.n);
        return add(invertedFraction);
    }
    public Fraction divide(Fraction dividedFraction) {
        Fraction switchedFraction = new Fraction(dividedFraction.n, dividedFraction.m);
        return this.multiply(switchedFraction);
    }

    public String toString() {
        return m + "/" + n;
    }
}

// Определить класс Дробь в виде пары (m,n). Класс должен содержать несколько конструкторов. Реализовать методы для сложения, вычитания, умножения и деления дробей. Объявить массив из k дробей, ввести/вывести значения для массива дробей. Создать массив объектов и передать его в метод, который изменяет каждый элемент массива с четным индексом путем добавления следующего за ним элемента массива.
public class Main {

    public static void main(String[] args) {
        System.out.println("k: ");

        Scanner console = new Scanner(System.in);
        var k = console.nextInt();

        Fraction[] fractions = new Fraction[k];

        for (var i = 0; i < k; i++) {
            System.out.println("input m for Fraction No. " + (i + 1) + ":");
            var m = console.nextInt();
            System.out.println("input n for Fraction No. " + (i + 1) + ":");
            var n = console.nextInt();

            fractions[i] = new Fraction(m, n);
        }

        print(fractions);
        System.out.println("sum:");
        System.out.println((fractions[0].add(fractions[1]).toString()));
        System.out.println("subtract:");
        System.out.println((fractions[0].subtract(fractions[1]).toString()));
        System.out.println("multiply:");
        System.out.println((fractions[0].multiply(fractions[1]).toString()));
        System.out.println("divide:");
        System.out.println((fractions[0].divide(fractions[1]).toString()));
        changeFraction(fractions);
        print(fractions);
    }

    private static void changeFraction(Fraction[] fractions) {
        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i] = fractions[i].add(fractions[i + 1]);
        }
    }

    private static void print(Fraction[] array) {
        System.out.println("-----");
        for (var i = 0; i < array.length; i++) {
            System.out.print(array[i].toString());
            if (i != array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("\n-----");
    }
}