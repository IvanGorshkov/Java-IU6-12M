package com.java.lab;

// 6.	interface Корабль <- abstract class Военный Корабль <- class Авианосец.

public class Main {

    public static void main(String[] args) {
        AircraftCarrier aircraft = new AircraftCarrier( 190,  35);
        aircraft.sail();
        aircraft.attack();

    }
}

interface Ship {
    void sail();
}

abstract class WarShip implements Ship {
    private int speed;
    public WarShip(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    abstract void attack();

    @Override
    public void sail() {
        System.out.println("Военный корабль плывет cо скоростью " + getSpeed());
    }
}

class AircraftCarrier extends WarShip {
    private int numberOfAircraft;
    public AircraftCarrier(int speed, int numberOfAircraft) {
        super(speed);
        this.numberOfAircraft = numberOfAircraft;
    }

    @Override
    public void sail() {
        System.out.println("Авианосец плывет cо скоростью " + getSpeed());
    }

    public int getNumberOfAircraft() {
        return numberOfAircraft;
    }

    public void setNumberOfAircraft(int numberOfAircraft) {
        this.numberOfAircraft = numberOfAircraft;
    }

    @Override
    public void attack() {
        System.out.println(numberOfAircraft + " самолета вылетели на атаку");
    }
}