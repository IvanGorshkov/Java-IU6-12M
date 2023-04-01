package com.java.lab;

import java.util.Arrays;

// 	Вывести в заданном тексте все слова, расположив их в алфавитном порядке.
public class Main {

    public static void main(String[] args) {
        var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam venenatis eleifend consequat. Praesent bibendum euismod quam, a rutrum ex consectetur.";
        var words = text.toLowerCase().split("[\\p{Punct}\\s]+");
        Arrays.sort(words);
        for (var word : words) {
            System.out.println(word);
        }
    }
}
