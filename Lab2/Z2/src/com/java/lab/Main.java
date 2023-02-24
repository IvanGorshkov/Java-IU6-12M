package com.java.lab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


// В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания. Для получения последней даты и времени следует использовать класс Date. Ввести n слов с консоли. Найти слово, состоящее только из различных символов. Если таких слов несколько, найти первое из них.
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("n: ");
        int n = in.nextInt();
        String[] words = new String[n];

        System.out.print("Введите слова:\n");
        in.nextLine();
        for(int i = 0; i < n; i++){
            words[i] = in.nextLine();
        }

        System.out.println("Слова:");
        Arrays.stream(words).forEach(System.out::println);

        System.out.println("Ответ:");
        System.out.println(wordWithUniqueSymbols(words));

        System.out.println("\nГоршков Иван Алексадрович");
        System.out.println("Задание выдано: 17.02.2023 17:25");
        System.out.println("Задание сдано: " + LocalDate.now() + " " + LocalTime.now());
    }

    public static String wordWithUniqueSymbols(String[] words) {

        for (String word : words) {
            var hashSet = new HashSet<Character>();

            word.chars().forEach(c -> hashSet.add((char) c));

            if (hashSet.size() == word.length()) {
                return word;
            }
        }

        return "-";
    }
}
