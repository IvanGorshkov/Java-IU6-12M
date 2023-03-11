package com.java.lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

// Phone: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Дебет, Кредит, Время городских и междугородных разговоров. Создать массив объектов. Вывести: a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное; b) сведения об абонентах, которые пользовались междугородной связью; c) сведения об абонентах в алфавитном порядке.
// Выполнить задания из варианта 2 лабораторной работы 3, реализуя собственные обработчики исключений и исключения ввода/вывода.
public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n ;
        Phone[] arr;
        try {
            n = scanner.nextInt();
            arr = new Phone[n];
            for(var i = 0; i < n; i++) {
                arr[i] = new Phone();
                System.out.print("input id for " + (i+1) + " Phone: ");
                arr[i].setId(scanner.nextInt());
                System.out.print("input surname for " + (i+1) + " Phone: ");
                arr[i].setSurname(scanner.next());
                System.out.print("input name for " + (i+1) + " Phone: ");
                arr[i].setName(scanner.next());
                System.out.print("input lastname for " + (i+1) + " Phone: ");
                arr[i].setLastname(scanner.next());
                System.out.print("input address for " + (i+1) + " Phone: ");
                arr[i].setLastname(scanner.next());
                System.out.print("input cardNumber for " + (i+1) + " Phone: ");
                arr[i].setCardNumber(scanner.nextLong());
                System.out.print("input debit for " + (i+1) + " Phone: ");
                arr[i].setDebit(scanner.nextInt());
                System.out.print("input credit for " + (i+1) + " Phone: ");
                arr[i].setCredit(scanner.nextInt());
                System.out.print("input cityTime for " + (i+1) + " Phone: ");
                arr[i].setCityTime(scanner.nextInt());
                System.out.print("input outsideCityTime for " + (i+1) + " Phone: ");
                arr[i].setOutsideCityTime(scanner.nextInt());
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input " + e.getLocalizedMessage());
            return;
        } catch (OutOfMemoryError e) {
            System.out.println("Memory Error " + e.getLocalizedMessage());
            return;
        } catch (InvalidPhoneException e) {
            System.out.println("InvalidPhoneException " + e.getLocalizedMessage());
            return;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return;
        }
        System.out.print("direction cityTime >: ");
        var direction = scanner.nextInt();
        for (var i = 0; i < n; i++) {
            if (arr[i].getCityTime() > direction) {
                System.out.println();
                arr[i].printPhone();
                System.out.println();
            }
        }

        System.out.println();
        System.out.print("use outsideCityTime");
        for (var i = 0; i < n; i ++) {
            if (arr[i].getOutsideCityTime() > 0) {
                System.out.println();
                arr[i].printPhone();
                System.out.println();
            }
        }

        System.out.print("sorted phones: ");
        Arrays.stream(arr).sorted(new PhoneComparator()).forEach(Phone::printPhone);

    }
}

class PhoneComparator implements Comparator<Phone> {

    public int compare(Phone a, Phone b){

        return a.getSurname().toUpperCase().compareTo(b.getSurname().toUpperCase());
    }
}

class Phone {
    private int id;
    private String surname;
    private String name;
    private String lastname;
    private String address;
    private long cardNumber;
    private int debit;
    private int credit;
    private int cityTime;
    private int outsideCityTime;


    public Phone(int id, String surname, String name, String lastname, String address, long cardNumber, int debit, int credit, int cityTime, int outsideCityTime) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.cardNumber = cardNumber;
        this.debit = debit;
        this.credit = credit;
        this.cityTime = cityTime;
        this.outsideCityTime = outsideCityTime;
    }

    public Phone() {
        this.id = 0;
        this.surname = "surname";
        this.name = "name";
        this.lastname = "lastname";
        this.address = "address";
        this.cardNumber = 0;
        this.debit = 0;
        this.credit = 0;
        this.cityTime = 0;
        this.outsideCityTime = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidPhoneException {
        if (id <= 0 ) {
            throw new InvalidPhoneException("id must be >0");
        }
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws InvalidPhoneException {
        if (surname.length() <= 0 ) {
            throw new InvalidPhoneException("surname must be >0");
        }
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidPhoneException {
        if (name.length() <= 0 ) {
            throw new InvalidPhoneException("name must be >0");
        }
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCityTime() {
        return cityTime;
    }

    public void setCityTime(int cityTime) {
        this.cityTime = cityTime;
    }

    public int getOutsideCityTime() {
        return outsideCityTime;
    }

    public void setOutsideCityTime(int outsideCityTime) {
        this.outsideCityTime = outsideCityTime;
    }
    public void printPhone() {
        System.out.println("id: " + id);
        System.out.println("surname: " + surname);
        System.out.println("name: " + name);
        System.out.println("lastname: " + lastname);
        System.out.println("address: " + address);
        System.out.println("cardNumber: " + cardNumber);
        System.out.println("debit: " + debit);
        System.out.println("credit: " + credit);
        System.out.println("cityTime: " + cityTime);
        System.out.println("outsideCityTime: " + outsideCityTime);
    }
}

class InvalidPhoneException extends Exception {
    public InvalidPhoneException (String str) {
        super(str);
    }
}