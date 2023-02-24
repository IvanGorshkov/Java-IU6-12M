package com.java.lab;

class Hello {
    public static void welcomeWith(String[] args) {
        System.out.println("Oh, WELCOME!");
        for (String arg: args) {
            System.out.println(arg);
        }
    }
}

// Создать класс Hello, который будет приветствовать любого пользователя, используя командную строку.
public class Main {

    public static void main(String[] args) {
        Hello.welcomeWith(args);
    }
}
