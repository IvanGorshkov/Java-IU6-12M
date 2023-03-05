package com.java.lab;
import java.util.Arrays;
import java.util.Objects;

// Создать объект класса Дерево, используя классы Лист. Методы: зацвести, опасть листьям, покрыться инеем, пожелтеть листьям.
public class Main {

    public static void main(String[] args) {
        Leaf[] leaves = new Leaf[4];
        leaves[0] = new Leaf(1);
        leaves[1] = new Leaf(2);
        leaves[2] = new Leaf(3);
        leaves[3] = new Leaf(4);
        Tree tree = new Tree(leaves);
        tree.blooming();
        tree.turningYellowLeaves();
        tree.fallingDown();
        tree.frostingOver();
        System.out.println(tree.toString());
    }
}

class Tree {
    private Leaf[] leaves;

    public Tree(Leaf[] leaves) {
        this.leaves = leaves;
    }

    public void blooming() {
        for (Leaf value : leaves) {
            value.blooming();
        }
        System.out.println("The tree's leaves has blossomed");
    }

    public void fallingDown() {
        for (Leaf value : leaves) {
            value.fallingDown();
        }
        System.out.println("The tree's leaves has falled down");
    }

    public void frostingOver() {
        for (Leaf value : leaves) {
            value.frostingOver();
        }
        System.out.println("The tree's leaves has frosted over");
    }

    public void turningYellowLeaves() {
        for (Leaf value : leaves) {
            value.turningYellowLeaves();
        }
        System.out.println("The tree's leaves has turned yellow");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tree tree)) return false;
        return Arrays.equals(leaves, tree.leaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaves);
    }

    @Override
    public String toString() {
        return "Rose {\n" +
                "leaves: " + Arrays.toString(leaves)  + "\n" +
                "}";
    }
}

 class Leaf {
     private int id;

     public Leaf(int id) {
         this.id = id;
     }

     public void blooming() {
         System.out.println("The Leaf has blossomed");
     }

     public void fallingDown() {
         System.out.println("The Leaf has falled down");
     }

     public void frostingOver() {
         System.out.println("The Leaf has frosted over");
     }

     public void turningYellowLeaves() {
         System.out.println("The Leaf has turned yellow");
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leaf leaf)) return false;
        return Objects.equals(id, leaf.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Leaf {" + " id:" + id + " }";
    }
}
