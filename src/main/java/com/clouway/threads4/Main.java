package com.clouway.threads4;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Main{
    public static void main(String[] args){
        ConcurrencyList list = new ConcurrencyList(10);
        Thread thread1 = new Thread(new Producer(list));
        Thread thread2 = new Thread(new Producer(list));
        Thread thread3 = new Thread(new Consumer(list));
        Thread thread4 = new Thread(new Consumer(list));
        Thread thread5 = new Thread(new Consumer(list));
        Thread thread6 = new Thread(new Producer(list));
        thread1.start();
        thread3.start();
        thread4.start();
        thread2.start();
        thread6.start();
        thread5.start();
    }
}
