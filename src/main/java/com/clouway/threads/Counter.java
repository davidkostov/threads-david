package com.clouway.threads;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Counter implements Runnable {

    private Integer count;

    public synchronized Integer get() {
        return count;
    }

    @Override
    public void run() {
        for (count = 1; count < 50; count++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
