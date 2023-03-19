package com.java.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 6. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные – в начало этого списка.
public class Main {

    public static void main(String[] args) {
       var list = new ArrayList<>(List.of(1, 2, -4, -2, 2, 4, 10, 424, -34));

        System.out.println(list);

        list.sort(Collections.reverseOrder());

        System.out.println("sorted: " + list);
    }
}
