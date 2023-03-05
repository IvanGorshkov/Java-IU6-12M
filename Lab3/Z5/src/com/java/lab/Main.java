package com.java.lab;
import java.util.Arrays;
import java.util.Objects;

// Создать объект класса Роза, используя классы Лепесток, Бутон. Методы: расцвести, завять, вывести на консоль цвет бутона.
public class Main {

    public static void main(String[] args) {
        Petal[] petals = new Petal[4];
        petals[0] = new Petal();
        petals[1] = new Petal();
        petals[2] = new Petal();
        petals[3] = new Petal();
        Rose rose = new Rose(new Bud(petals, "White"));
        rose.getColor();
        rose.withering();
        rose.blooming();
        System.out.println(rose.toString());
    }
}

class Rose {
    private final Bud bud;
    private Boolean isBloomed = true;

    public Rose(Bud bud) {
        this.bud = bud;
    }

    public void blooming() {
        this.bud.blooming();
        this.isBloomed = true;
        System.out.println("The rose has blossomed");
    }

    public void withering() {
        this.bud.withering();
        this.isBloomed = false;
        System.out.println("Rose withered");
    }

    public void getColor() {
        System.out.println("Bud color: " + this.bud.getColor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rose rose)) return false;
        return bud.equals(rose.bud) && isBloomed.equals(rose.isBloomed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bud, isBloomed);
    }

    @Override
    public String toString() {
        return "Rose {\n" +
                "bud: " + bud + ",\n" +
                "isBloomed: " + isBloomed + "\n" +
                "}";
    }
}

class Bud {
    private Petal[] petal;
    private String color;
    private Boolean isBloomed = true;

    public Bud(Petal[] petal, String color) {
        this.petal = petal;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void blooming() {
        for (Petal value : petal) {
            value.blooming();
        }
        this.isBloomed = true;
        System.out.println("The bud has blossomed");
    }

    public void withering() {
        for (Petal value : petal) {
            value.withering();
        }
        this.isBloomed = false;
        System.out.println("Bud wilted");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bud bud)) return false;
        return Arrays.equals(petal, bud.petal) && color.equals(bud.color) && isBloomed.equals(bud.isBloomed);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(color, isBloomed);
        return result + Arrays.hashCode(petal);
    }

    @Override
    public String toString() {
        return "Bud {\n" +
                " petal: " + Arrays.toString(petal) + ",\n" +
                " color: '" + color + "'" + ",\n" +
                " isBloomed: " + isBloomed + "\n" +
                "}";
    }
}

 class Petal {
    private Boolean isBloomed = true;

     public void blooming() {
         this.isBloomed = true;
         System.out.println("petal blossomed");
     }

    public void withering() {
        this.isBloomed = false;
        System.out.println("petal withered");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Petal petal)) return false;
        return Objects.equals(isBloomed, petal.isBloomed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBloomed);
    }

    @Override
    public String toString() {
        return "Petal {" + " isBloomed:" + isBloomed + " }";
    }
}
