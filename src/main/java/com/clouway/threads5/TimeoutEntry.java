package com.clouway.threads5;

import java.util.Hashtable;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class TimeoutEntry<K, V> extends Thread {

    private K key;
    private V value;
    private boolean resetFlag;
    private Integer timeoutInterval;
    private Hashtable<K, TimeoutEntry<K, V>> hashtable;

    public TimeoutEntry(K key, V value, Integer timeoutInterval, Hashtable<K, TimeoutEntry<K, V>> hashtable) {
        this.key = key;
        this.value = value;
        this.timeoutInterval = timeoutInterval;
        this.hashtable = hashtable;
        resetFlag = true;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                while (resetFlag) {
                    resetFlag = false;
                    wait(timeoutInterval);
                }
                System.out.println(hashtable.remove(key).getValue() + " - timed out.");
            } catch (InterruptedException ie) {
                return;
            }
        }
    }

    public synchronized void replaceValue(V value) {
        this.value = value;
        resetFlag = true;
        this.notifyAll();
    }

    public synchronized V getValue() {
        return value;
    }
}
