package com.example.designpattern.singleton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SingletonLockingTest {
    private ExecutorService executor;

    @BeforeEach
    void setUp() {
        executor = Executors.newFixedThreadPool(5);
    }

    @AfterEach
    void tearDown() {
        try {
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getInstance() {
        Runnable task = () -> {
            SingletonLocking instance = SingletonLocking.getInstance();
            assertNotNull(instance, "Singleton instance is null");
            assertNotNull(instance.getRes1(), "Resource 1 is null");
            assertNotNull(instance.getRes2(), "Resource 2 is null");
            assertEquals("Resource", instance.getRes1());
            assertEquals("Resource", instance.getRes2());
        };
        executor.execute(task);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(task);
        executor.execute(task);
        executor.execute(task);
        executor.execute(task);
    }
}