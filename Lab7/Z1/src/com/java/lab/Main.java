package com.java.lab;

// После каждого слова текста, заканчивающегося заданной подстрокой, вставить указанное слово.
public class Main {

    public static void main(String[] args) {
        var text = "They are conducting more tests.";
        System.out.println(makeStringWithWordAfterSubstring(text, "more", "lord"));
    }

    public static String makeStringWithWordAfterSubstring(String text, String substring, String word) {
        var builder = new StringBuilder();
        var words = text.split(" ");

        for (String s : words) {
            builder.append(s);
            if (s.endsWith(substring)) {
                builder.append(" ");
                builder.append(word);
            }
            builder.append(" ");
        }

        return builder.toString();
    }
}
