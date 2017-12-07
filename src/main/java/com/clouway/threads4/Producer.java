package com.clouway.threads4;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Producer implements Runnable{

    private ConcurrencyList list;

    public Producer(ConcurrencyList list){
        this.list = list;
    }

    @Override
    public void run() {
        list.add(new Integer(50));
        list.add(true);
        list.add(false);
        list.add(new Double(21.21));
        list.printAllElements();
    }
}
