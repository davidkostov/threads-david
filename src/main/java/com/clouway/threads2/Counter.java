package com.clouway.threads2;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Counter implements Runnable {

    private Integer from;
    private Integer to;
    private Thread syncCounterThread;
    private String name;

    public Counter(Integer from, Integer to, String name) {
        this.from = from;
        this.to = to;
        this.name = name;
    }

    public void syncWithCounterThread(Thread threadToSyncWith) {
        syncCounterThread = threadToSyncWith;
    }

    public void run() {
        for (int i = from; i <= to; i++) {
            System.out.println(name + " - " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                break;
            }
        }
        System.out.println("Thread " + name + " [" + from + " - " + to + "] has stopped working...");
        if (syncCounterThread.isAlive()) {
            syncCounterThread.interrupt();
        }
    }
}
