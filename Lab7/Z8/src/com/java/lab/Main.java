package com.java.lab;

// Подсчитать, сколько слов в заданном тексте начинается с прописной буквы.
public class Main {

    public static void main(String[] args) {
        var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam venenatis eleifend consequat. Praesent bibendum euismod quam, a rutrum ex consectetur.";
        System.out.println(text);
        System.out.println(countCapitalizedWords(text));
    }

    public static int countCapitalizedWords(String text) {
        var words = text.split("\\s+");
        var count = 0;
        for (String word : words) {
            if (word.matches("[А-ЯA-Z][а-яa-z]*")) {
                count++;
            }
        }
        return count;
    }
}