package com.felix.common.concurrent;

import static java.util.Objects.requireNonNull;

public class Threads {

    public static Thread run(Runnable runnable) {
        requireNonNull(runnable);
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
