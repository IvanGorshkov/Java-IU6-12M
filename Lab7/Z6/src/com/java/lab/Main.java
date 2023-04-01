package com.java.lab;

// Текст шифруется по следующему правилу: из исходного текста выбирается 1, 4, 7, 10-й и т.д. (до конца текста) символы, затем 2, 5, 8, 11-й и т.д. (до конца текста) символы, затем 3, 6, 9, 12-й и т.д. Зашифровать заданный текст.
public class Main {

    public static void main(String[] args) {
        var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce luctus.";
        System.out.println(text);
        var encryptedText = encrypt(text);
        System.out.println(encryptedText);
    }

    public static String encrypt(String text) {
        var result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 3) {
            result.append(text.charAt(i));
        }
        for (int i = 1; i < text.length(); i += 3) {
            result.append(text.charAt(i));
        }
        for (int i = 2; i < text.length(); i += 3) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }
}
