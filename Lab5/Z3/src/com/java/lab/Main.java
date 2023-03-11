package com.java.lab;

import java.util.InputMismatchException;
import java.util.Scanner;

// House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания, Срок эксплуатации. Создать массив объектов. Вывести: a) список квартир, имеющих заданное число комнат; b) список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке; c) список квартир, имеющих площадь, превосходящую заданную.
// Выполнить задания из варианта 2 лабораторной работы 3, реализуя собственные обработчики исключений и исключения ввода/вывода.
public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        Flat[] arr;
        int n;
        try {
            System.out.print("n: ");
            n = scanner.nextInt();
            arr = new Flat[n];
            for(var i = 0; i < n; i++) {
                arr[i] = new Flat();
                System.out.print("input id for " + (i+1) + " flat: ");
                arr[i].setId(scanner.nextInt());
                System.out.print("input flatNum for " + (i+1) + " flat: ");
                arr[i].setFlatNum(scanner.nextInt());
                System.out.print("input S for " + (i+1) + " flat: ");
                arr[i].setS(scanner.nextDouble());
                System.out.print("input flour for " + (i+1) + " flat: ");
                arr[i].setFlour(scanner.nextInt());
                System.out.print("input roomNum for " + (i+1) + " flat: ");
                arr[i].setRoomNum(scanner.nextInt());
                System.out.print("input street for " + (i+1) + " flat: ");
                arr[i].setStreet(scanner.next());
                System.out.print("input type for " + (i+1) + " flat: ");
                arr[i].setType(scanner.next());
                System.out.print("input duration for " + (i+1) + " flat: ");
                arr[i].setDuration(scanner.nextInt());
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input " + e.getLocalizedMessage());
            return;
        } catch (OutOfMemoryError e) {
            System.out.println("Memory Error " + e.getLocalizedMessage());
            return;
        } catch (InvalidFlatException e) {
            System.out.println("InvalidFlatException " + e.getLocalizedMessage());
            return;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return;
        }

        try {
            System.out.print("count roomNum: ");
            var countRoomNum = scanner.nextInt();
            for (var i = 0; i < n; i++) {
                if (arr[i].getRoomNum() == countRoomNum) {
                    System.out.println();
                    arr[i].printFlat();
                    System.out.println();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input" + e.getLocalizedMessage());
            return;
        }

        try {
            System.out.println();
            System.out.print("count roomNum and range flour");
            var countRoomNum = scanner.nextInt();
            var rangeMin = scanner.nextInt();
            var rangeMax = scanner.nextInt();
            for (var i = 0; i < n; i ++) {
                if (arr[i].getRoomNum() == countRoomNum) {
                    if (arr[i].getFlour() >= rangeMin && arr[i].getFlour() <= rangeMax) {
                        System.out.println();
                        arr[i].printFlat();
                        System.out.println();
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input" + e.getLocalizedMessage());
            return;
        }
        try {
            System.out.print("S: ");
            var S = scanner.nextDouble();
            for (int i = 0; i < n; i++)  {
                if (arr[i].getS() >= S) {
                    System.out.println();
                    arr[i].printFlat();
                    System.out.println();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input" + e.getLocalizedMessage());
        }
    }
}

class Flat {
    private int id;
    private int flatNum;
    private double S;
    private int flour;
    private int roomNum;
    private String street;
    private String type;
    private int duration;

    public Flat() {
        id = 0;
        flatNum = 0;
        S = 0;
        flour = 0;
        roomNum = 0;
        street = "";
        type = "";
        duration = 0;
    }

    public Flat(int id, int flatNum, double S, int flour, int roomNum, String street, String type, int duration) {
        this.id = id;
        this.flatNum = flatNum;
        this.S = S;
        this.flour = flour;
        this.roomNum = roomNum;
        this.street = street;
        this.type = type;
        this.duration = duration;
    }

    public void printFlat() {
        System.out.println("id: " + id);
        System.out.println("flatNum: " + flatNum);
        System.out.println("S: " + S);
        System.out.println("flour: " + flour);
        System.out.println("roomNum: " + roomNum);
        System.out.println("street: " + street);
        System.out.println("type: " + type);
        System.out.println("duration: " + duration);

    }

    public double getS() {
        return S;
    }

    public void setS(double s) throws Exception {
        if (s <= 0) {
            throw new InvalidFlatException("S mast be > 0");
        }
        S = s;
    }

    public int getFlour() {
        return flour;
    }

    public void setFlour(int flour) {
        this.flour = flour;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {

        if (id <= 0) {
            throw new InvalidFlatException("ID mast be > 0");
        }

        this.id = id;
    }

    public int getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(int flatNum)  throws Exception {
        if (flatNum <= 0) {
            throw new InvalidFlatException("flatNum mast be > 0");
        }
        this.flatNum = flatNum;
    }

}

class InvalidFlatException extends Exception {
    public InvalidFlatException (String str) {
        super(str);
    }
}