package com.java.lab;
import java.util.Scanner;

// В зависимости от признака (0 или 1) в каждой строке текста удалить указанный символ везде, где он встречается, или вставить его после k-гo символа.
public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var text = "They are conducting more tests.";

        System.out.println("symbol:");
        var symbol = scanner.nextLine().charAt(0);

        System.out.println("flag:");
        var flag = scanner.nextInt();

        System.out.println("k:");
        var k = scanner.nextInt();

        var lines = text.split("\n");
        for (var line : lines) {
            if (flag == 0) {
                line = line.replaceAll(Character.toString(symbol), "");
                System.out.println(line);
            } else {
                StringBuilder builder = new StringBuilder(line);
                builder.insert(k, symbol);
                System.out.println(builder.toString());
            }
        }
    }
}