package com.java.lab;

// 7.	interface Врач <- class Хирург <- class Нейрохирург.

public class Main {

    public static void main(String[] args) {
        var surgeon = new Surgeon("Иван");
        var neurosurgeon = new Neurosurgeon("Стёпа");
        doOperation(surgeon);
        doOperation(neurosurgeon);
        checkNeurons(neurosurgeon);
    }

    static void doOperation(Doctor doctor) {
        doctor.doOperation();
    }

    static void checkNeurons(Neurosurgeon doctor) {
        doctor.checkNeurons();
    }
}

interface Doctor {
    void doOperation();
}

class Surgeon implements Doctor {

    String name;

    Surgeon(String name) {
        this.name = name;
    }

    @Override
    public void doOperation() {
        System.out.println("Врач хирург " + name + " оперирует");
    }
}

class Neurosurgeon extends Surgeon {
    Neurosurgeon(String name) {
        super(name);
    }

    @Override
    public void doOperation() {
        System.out.println("Нейрохирург " + name + " оперирует");
    }

    public void checkNeurons() {
        System.out.println("Проверить нервную систему");
    }
}
