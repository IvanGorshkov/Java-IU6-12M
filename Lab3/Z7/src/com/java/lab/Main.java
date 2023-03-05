package com.java.lab;

// Система Конструкторское бюро. Заказчик представляет Техническое Задание (ТЗ) на проектирование многоэтажного Дома.
// Конструктор регистрирует ТЗ, определяет стоимость проектирования и строительства, выставляет Заказчику Счет за
// проектирование и создает Бригаду Конструкторов для выполнения Проекта.
public class Main {

    public static void main(String[] args) {
        House house = new House(7);
        TZ tz = new TZ(20000, house);
        ConsructorBuro constr = new ConsructorBuro(tz);
        System.out.println(constr.countCostString());

    }
}

class Brigada {
    private double price;
    private int n;

    public Brigada(double price, int n) {
        this.price = price;
        this.n = n;
    }

    public double getCost() {
        return n*price;
    }
}

class House {
    private final int floors;

    public House(int floors) {
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }
}

class TZ {
    double moneyForFlour;
    House house;

    public TZ(double moneyForFlour, House house) {
        this.moneyForFlour = moneyForFlour;
        this.house = house;
    }

    public double getCost() {
        return  house.getFloors() * moneyForFlour;
    }
}

class Designer {
    private final double price;

    public Designer(double price) {
        this.price = price;
    }

    public double getCost() {
        return price;
    }

}

//класс Конструктор
class ConsructorBuro {
    TZ tz;
    Brigada brigada;
    Designer designer;
    double brigadaK = 0.5;
    double designerK = 0.6;

    public ConsructorBuro(TZ tz) {
        this.tz = tz;
        this.designer = new Designer(tz.moneyForFlour * designerK);
        this.brigada = new Brigada(tz.moneyForFlour * brigadaK, 5);
    }

    public double countCost() {
        return tz.getCost() + designer.getCost() + brigada.getCost();
    }

    public String countCostString() {
        double houseCost = tz.getCost();
        double brigadaCost = brigada.getCost();
        double designerCost = designer.getCost();
        return "Цена дома: " + houseCost + "руб.\n" +
                "Цена работ бригады: " + brigadaCost + "руб.\n" +
                "Цена работ конструктора: " + designerCost + "руб.\n" +
                "Итого: " + countCost() + "руб.";
    }
}