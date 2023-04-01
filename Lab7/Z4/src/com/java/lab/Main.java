package com.java.lab;

// В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
public class Main {

    public static void main(String[] args) {
        var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce luctus.";

        var words = text.split(" ");

        var maxLength = 0;
        var minLength = words[0].length();

        for (var word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
            if (word.length() < minLength) {
                minLength = word.length();
            }
        }

        System.out.println("Max (" + maxLength + "):");
        for (var word : words) {
            if (word.length() == maxLength) {
                System.out.println(word);
            }
        }

        System.out.println("Min(" + minLength + "):");
        for (var word : words) {
            if (word.length() == minLength) {
                System.out.println(word);
            }
        }
    }
}