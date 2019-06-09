package com.example.designpattern.singleton;

public final class SingletonLocking {
    private static volatile SingletonLocking instance = null;
    private String res1;
    private String res2;

    private SingletonLocking() {
        this.res1 = createResource();
        this.res2 = createResource();
    }

    public static SingletonLocking getInstance() {
        if (instance == null) {
            synchronized (SingletonLocking.class) {
                if (instance == null) {
                    instance = new SingletonLocking();
                }
            }
        }
        return instance;
    }

    private String createResource() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Resource";
    }

    public String getRes1() {
        return res1;
    }

    public String getRes2() {
        return res2;
    }
}
