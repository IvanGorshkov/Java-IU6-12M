package com.java.lab;

// Система Телефонная станция.
// Абонент оплачивает Счет за разговоры и Услуги, может попросить Администратора сменить номер и отказаться от услуг.
// Администратор изменяет номер, Услуги и временно отключает Абонента за неуплату.
public class Main {

    public static void main(String[] args) {
        var admin = new Admin();
        var subscriber = new  Subscriber("+79999999387", 123, true);
        admin.setSubscriber(subscriber);
        admin.updateNumber("+79999870140");
        admin.updateBalance(100);
        admin.updateService(false);
        admin.updateService(true);
        admin.updateBalance(-100);
        admin.disableServiceZeroBalance();
        System.out.println(subscriber.toString());
    }
}

class Subscriber {
    private String phoneNumber;
    private int balance;
    private boolean isServicesEnabled;

    public Subscriber(String phoneNumber, int balance, boolean isServicesEnabled) {
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.isServicesEnabled = isServicesEnabled;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isServicesEnabled() {
        return isServicesEnabled;
    }

    public void setServicesEnabled(boolean servicesEnabled) {
        isServicesEnabled = servicesEnabled;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                ", isServicesEnabled=" + isServicesEnabled +
                '}';
    }
}

class Admin {
    Subscriber subscriber;

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    void updateNumber(String newPhoneNumber) {
        subscriber.setPhoneNumber(newPhoneNumber);
    }

    void updateBalance(int newBalance) {
        subscriber.setBalance(newBalance);
    }

    void updateService(boolean servicesEnabled) {
        subscriber.setServicesEnabled(servicesEnabled);
    }

    void disableServiceZeroBalance() {
        if (subscriber.getBalance() <= 0){
            subscriber.setServicesEnabled(false);
        }
    }
}
