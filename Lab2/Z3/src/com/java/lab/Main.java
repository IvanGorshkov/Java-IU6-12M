package com.java.lab;

import java.util.Random;
import java.util.Scanner;

// Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел. Вычислить норму матрицы.

class Matrix {
    int[][] matrix;
    int size;

    public Matrix(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    public void fillingMatrix() {
        var random = new Random();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = size - random.nextInt(2 * size + 1);
            }
        }
    }

    public void outputMatrix() {
        System.out.println();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // https://yu-xuan.livejournal.com/134964.html?
    public double getMatrixNorm() {
        double matrixNorm = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixNorm += matrix[i][j] * matrix[i][j];
            }
        }
        return Math.sqrt(matrixNorm);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Размер матрицы: ");
        var size = in.nextInt();
        var matrix = new Matrix(size);
        matrix.fillingMatrix();
        matrix.outputMatrix();
        System.out.println("Вычисляю норму матрицы...");
        System.out.println("Норма матрицы: " + matrix.getMatrixNorm());

    }
}