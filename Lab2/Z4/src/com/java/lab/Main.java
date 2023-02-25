package com.java.lab;

import java.util.Random;
import java.util.Scanner;

// Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.

class Matrix {
    int[][] matrix;
    int size;
    int angle;

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

    public void setAngle(int angle) {
        this.angle = angle;
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

    public void rotate() {
        do {
            for (int topIndex = 0; topIndex < size / 2; topIndex++) {
                int bottomIndex = size - 1 - topIndex;
                for (int j = topIndex; j < bottomIndex; j++) {
                    int tmpIJMatrixValue = matrix[topIndex][j];
                    int tmpIndex = bottomIndex - j - topIndex;
                    matrix[topIndex][j] = matrix[j][bottomIndex];
                    matrix[j][bottomIndex] = matrix[bottomIndex][tmpIndex];
                    matrix[bottomIndex][tmpIndex] = matrix[tmpIndex][topIndex];
                    matrix[tmpIndex][topIndex] = tmpIJMatrixValue;
                }
            }
            angle -= 90;
        } while (angle > 0);
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
        System.out.print("Поворот матрицы на 90(180, 270) градусов: ");
        var angle = in.nextInt();
        if (angle == 90 || angle == 180 || angle == 270) {
            matrix.setAngle(angle);
            System.out.println("Идет поворот матрицы на " + angle + " градусов ...");
            matrix.rotate();
            matrix.outputMatrix();
            return;
        }
        System.out.println("Не тот угол");
    }
}