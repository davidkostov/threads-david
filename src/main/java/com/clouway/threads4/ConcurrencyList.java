package com.clouway.threads4;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class ConcurrencyList{

    private Object[] list;
    private int index;

    public ConcurrencyList(int size){
        list = new Object[size];
        index=-1;
    }

    public synchronized void add(Object elementData) throws ArrayIndexOutOfBoundsException{
        while (index == list.length-1){
            try{
                System.out.println("Too many elements in the list, waiting for issue to be resolved...");
                wait();
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }

        list[++index] = elementData;
        notify();
    }

    public synchronized void remove(){
        while (index < 0){
            try{
                System.out.println("No elements to remove, waiting for issue to be resolved...");
                wait();
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }

        list[index--] = null;
        notify();
    }

    public synchronized void printAllElements(){
        for(int i=0; i<list.length; i++){
            if(list[i]!=null){
                System.out.print(list[i]+" ");
            }
        }
        System.out.println();
    }

}
