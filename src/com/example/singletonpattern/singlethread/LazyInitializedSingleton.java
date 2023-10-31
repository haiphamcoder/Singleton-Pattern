package com.example.singletonpattern.singlethread;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    public int value;

    private LazyInitializedSingleton(int value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;

    }

    public static LazyInitializedSingleton getInstance(int value) {
        if (instance == null) {
            instance = new LazyInitializedSingleton(value);
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("LazyInitializedSingleton " + value + " instance created! " + instance.hashCode());
    }
}
