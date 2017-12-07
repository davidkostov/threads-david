package com.clouway.threads4;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Consumer implements Runnable{

    private ConcurrencyList list;

    public Consumer(ConcurrencyList list){
        this.list = list;
    }

    @Override
    public void run() {
        list.add(new Integer(45));
        list.printAllElements();
        list.remove();
        try {
            Thread.sleep(200);
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
        list.remove();
        list.printAllElements();
    }

}
