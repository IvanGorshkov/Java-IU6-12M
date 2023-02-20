package com.java.lab;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Создать приложение, выводящее фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания. Для получения последней даты и времени использовать класс Calendar из пакета java.util
public class Main {

    public static void main(String[] args) {
        var developer = "Gorshkov";
        var startedTime = new GregorianCalendar();
        var finishedTime = new GregorianCalendar(2023, Calendar.MARCH, 3, 16, 0);
        System.out.println("Developer surname: " + developer);
        System.out.println("Task started: " + startedTime.getTime());
        System.out.println("Task finished: " + finishedTime.getTime());
    }
}
