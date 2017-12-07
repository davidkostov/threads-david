package com.clouway.threads5;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Main {
    public static void main(String[] args) {
        TimeoutHashtable<Integer, String> table = new TimeoutHashtable<>(5000);
        table.put(1, "Bai Ganio");
        table.put(2, "Kolio");
        table.put(1, "Ivancho");
        table.put(3, "Mariika");
        table.put(4, "Kircho");
        System.out.println(table.get(3));
        System.out.println(table.remove(4));
        System.out.println(table.get(1));
    }
}
