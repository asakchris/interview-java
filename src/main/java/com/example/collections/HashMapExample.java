package com.example.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<>();

        Key one = new Key(1);
        Key two = new Key(2);
        Key three = new Key(3);
        Key four = new Key(4);

        map.put(one, "One");
        map.put(two, "Two");
        map.put(three, "Three");
        map.put(four, "Four");

        System.out.println("map size: " + map.size());
        System.out.println("one: " + map.get(one));
        System.out.println("two: " + map.get(two));
        System.out.println("three: " + map.get(three));
        System.out.println("four: " + map.get(four));
    }
}

class Key {
    int id;

    public Key(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return id == key.id;
    }

    @Override
    public int hashCode() {
        return id % 2;
    }
}
