package com.example.designpattern.singleton;

public final class SingletonStaticHolder {
    private String res1;
    private String res2;

    private SingletonStaticHolder() {
        this.res1 = createResource();
        this.res2 = createResource();
    }

    private static class Holder {
        static final SingletonStaticHolder INSTANCE = new SingletonStaticHolder();
    }

    public static SingletonStaticHolder getInstance() {
        return Holder.INSTANCE;
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
