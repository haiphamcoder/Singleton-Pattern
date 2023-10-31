package com.example.singletonpattern.multithread;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    public int value;

    private ThreadSafeSingleton(int value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static synchronized ThreadSafeSingleton getInstance(int value) {
        if (instance == null) {
            instance = new ThreadSafeSingleton(value);
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("ThreadSafeSingleton " + value + " instance created! " + instance.hashCode());
    }
}
