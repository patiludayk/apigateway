package com.example.demo.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    private int max = 10;

    private AtomicInteger number = new AtomicInteger(1);
    private int num = 1;

    public static void main(String[] args) {

        Test t = new Test();
        Thread even = new Thread(() -> t.printEven(), "even");
        Thread odd = new Thread(() -> t.printOdd(), "odd");

        even.start();
        odd.start();

        Thread evenWithoutAtomicVariable = new Thread(() -> t.printEvenWithoutAtomicVariable(), "evenWithoutAtomicVariable");
        Thread oddWithoutAtomicVariable = new Thread(() -> t.printOddWithoutAtomicVariable(), "oddWithoutAtomicVariable");

        evenWithoutAtomicVariable.start();
        oddWithoutAtomicVariable.start();

    }

    private synchronized void printEven() {
        while (number.get() <= max) {
            if (number.get() % 2 == 1) {     //not a even number
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(number.get() + ": " + Thread.currentThread().getName());
            number.incrementAndGet();
            notify();
        }
    }

    private synchronized void printOdd() {
        while (number.get() <= max) {
            if (number.get() % 2 == 0) {     //not a odd number
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(number.get() + ": " + Thread.currentThread().getName());
            number.incrementAndGet();

            notify();
        }
    }

    private void printEvenWithoutAtomicVariable() {
        synchronized (this) {
            while (num <= max) {
                if (num % 2 == 1) {  //not a even number
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(num + ": " + Thread.currentThread().getName());
                num++;
                notify();
            }
        }
    }

    private void printOddWithoutAtomicVariable() {
        synchronized (this) {
            while (num <= max) {
                if (num % 2 == 0) {  //not a odd number
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(num + ": " + Thread.currentThread().getName());
                num++;
                notify();
            }
        }
    }
}
