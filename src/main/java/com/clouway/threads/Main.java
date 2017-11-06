package com.clouway.threads;

import java.util.Scanner;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Main {

    public static void main(String[] args) {
        String gate = "stop";
        Scanner scanner = new Scanner(System.in);

        Counter counter = new Counter();
        Thread thread1 = new Thread(counter);
        thread1.start();

        while(true) {
            if (gate.equals(scanner.nextLine())) {
                System.out.println("Counter is currently at - " + counter.get());
                thread1.interrupt();
                break;
            }
        }
    }

}
