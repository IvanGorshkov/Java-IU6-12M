package com.java.lab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;


// В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания. Для получения последней даты и времени следует использовать класс Date. Ввести n слов с консоли. Найти слово, символы в котором идут в строгом порядке возрастания их кодов. Если таких слов несколько, найти первое из них.
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
        System.out.println("Коды:");
        Arrays.stream(words).forEach(s -> {
            s.chars().forEach(c -> System.out.print(c + " "));
            System.out.println();
        });
        System.out.println("Ответ:");
        System.out.println(wordWithMaxCodeChars(words));

        System.out.println("\nГоршков Иван Алексадрович");
        System.out.println("Задание выдано: 17.02.2023 17:25");
        System.out.println("Задание сдано: " + LocalDate.now() + " " + LocalTime.now());
    }

    public static String wordWithMaxCodeChars(String[] args) {
        boolean isPreviousCharLessThenNextChar = true;
        for (String word : args) {
            for (int i = 0; i < word.length() - 1; ++i) {

                if (word.charAt(i) > word.charAt(i + 1)) {
                    isPreviousCharLessThenNextChar = false;
                    break;
                }
            }

            if (isPreviousCharLessThenNextChar) {
                return word;
            }
            isPreviousCharLessThenNextChar = true;
        }
        return "-";
    }

}
