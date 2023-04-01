package com.java.lab;

import java.util.concurrent.Semaphore;

// 3.	Реализовать многопоточное приложение “Магазин”. Вся цепочка: производитель-магазин-покупатель. Пока производитель не поставит на склад продукт, покупатель не может его забрать. Реализовать приход товара от производителя в магазин случайным числом. В том случае, если товара в магазине не хватает– вывести сообщение.
class Main {
    public static void main(String[] args) {
        var shop = new Shop(10);
        var producerThread = new Thread(() -> {
            while (true) {
                var amount = (int) (Math.random() * 5) + 1;
                shop.put(amount);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        var consumerThread = new Thread(() -> {
            while (true) {
                var amount = (int) (Math.random() * 3) + 1;
                shop.get(amount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}

class Shop {
    private int stock;
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;

    public Shop(int stock) {
        this.stock = stock;
        producerSemaphore = new Semaphore(1);
        consumerSemaphore = new Semaphore(0);
    }

    public void put(int amount) {
        try {
            producerSemaphore.acquire();
            stock += amount;
            System.out.println("Producer put new " + amount + " items, stock: " + stock);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumerSemaphore.release();
        }
    }

    public void get(int amount) {
        try {
            consumerSemaphore.acquire();
            if (stock < amount) {
                System.out.println("Consumer wants " + amount + ", but there are " + stock + " items in stock");
            } else {
                stock -= amount;
                System.out.println("Consumer bought " + amount + " items, stock: " + stock);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            producerSemaphore.release();
        }
    }
}