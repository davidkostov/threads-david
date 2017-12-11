package com.clouway.threads3;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter(0, 200, "a");
        Counter c2 = new Counter(50, 100, "b");
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        c1.syncWithCounterThread(t2);
        c2.syncWithCounterThread(t1);

        t1.start();
        t2.start();
    }
}
