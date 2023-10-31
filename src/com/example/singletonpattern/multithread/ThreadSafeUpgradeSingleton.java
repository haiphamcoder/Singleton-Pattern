package com.example.singletonpattern.multithread;

public class ThreadSafeUpgradeSingleton {
    private static ThreadSafeUpgradeSingleton instance;
    public int value;

    private ThreadSafeUpgradeSingleton(int value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static ThreadSafeUpgradeSingleton getInstance(int value) {
        if (instance == null) {
            synchronized (ThreadSafeUpgradeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeUpgradeSingleton(value);
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("ThreadSafeUpgradeSingleton " + value + " instance created! " + instance.hashCode());
    }
}
