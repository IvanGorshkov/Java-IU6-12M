package com.java.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 7. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        var scan = new Scanner(new File("in.txt"));
        ArrayList<String> arrStr = new ArrayList<>();

        while (scan.hasNext()) {
            arrStr.add(scan.nextLine());
        }

        arrStr.sort(Collections.reverseOrder());
        System.out.println(arrStr);
    }
}