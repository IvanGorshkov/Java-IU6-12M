package com.java.lab;

import java.util.InputMismatchException;
import java.util.Scanner;


// Определить класс Цепная дробь.
// Определить методы сложения, вычитания, умножения, деления. Вычислить значение для заданного n, x, a[n].
// Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя состояние потоков ввода/вывода. При возникновении ошибок, связанных с корректностью выполнения математических операций, генерировать и обрабатывать исключительные ситуации. Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.

public class Main {
    public static void main(String[] args) {

        try {
            ContinuedFraction firstContinuedFraction = makeChainFraction();
            System.out.println("Total value: " + firstContinuedFraction.getValue());
            ContinuedFraction secondContinuedFraction = makeChainFraction();
            System.out.println("Total value: " + secondContinuedFraction.getValue());

            System.out.println("sum: " + firstContinuedFraction.add(secondContinuedFraction));
            System.out.println("subtract: " + firstContinuedFraction.subtract(secondContinuedFraction));
            System.out.println("multiply: " + firstContinuedFraction.multiply(secondContinuedFraction));
            System.out.println("divide: " + firstContinuedFraction.divide(secondContinuedFraction));
        } catch (InputMismatchException e) {
            System.out.println("Wrong input" + e.getLocalizedMessage());
        } catch (OutOfMemoryError e) {
            System.out.println("Memory Error" + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static ContinuedFraction makeChainFraction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("number of coefficients: ");
        var n = scanner.nextInt();

        System.out.print("continued fraction numerator: ");
        var x = scanner.nextInt();

        var a = new double[n];
        for (var i = 0; i < n; i++) {
            System.out.print("Enter coefficient No. " + (i) + " : ");
            a[i] = scanner.nextInt();
        }

        return new ContinuedFraction(x, n, a);
    }
}

class ContinuedFraction {
    private final double[] a;
    private final int n;
    private final int x;

    ContinuedFraction(int x, int n, double[] a) {
        this.x = x;
        this.n = n;
        this.a = a;
    }

    double getValue() {
        var value = a[n-1];
        for (var i = n - 2; i >= 0; i--) {
            value = a[i] + x / value;
        }
        return value;
    }

    double add(ContinuedFraction continuedFraction) {
        try {
            return this.getValue() + continuedFraction.getValue();
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    double subtract(ContinuedFraction continuedFraction) {
        try {
        return this.getValue() - continuedFraction.getValue();
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    double multiply(ContinuedFraction continuedFraction) {
        try {
            return this.getValue() * continuedFraction.getValue();
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    double divide(ContinuedFraction continuedFraction) {
        try {
            return this.getValue() / continuedFraction.getValue();
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}