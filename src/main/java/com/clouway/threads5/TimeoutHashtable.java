package com.clouway.threads5;

import java.util.Hashtable;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class TimeoutHashtable<K, V> {

    private Hashtable<K, TimeoutEntry<K, V>> hashtable;
    private Integer timeoutInterval;

    public TimeoutHashtable(Integer timeoutInterval) {
        hashtable = new Hashtable<>();
        this.timeoutInterval = timeoutInterval;
    }

    public synchronized void put(K key, V value) {
        if (!hashtable.containsKey(key)) {
            TimeoutEntry<K, V> entry = new TimeoutEntry<>(key, value, timeoutInterval, hashtable);
            hashtable.put(key, entry);
            entry.start();
        } else {
            hashtable.get(key).replaceValue(value);
        }
    }

    public synchronized V get(K key) {
        if (!hashtable.containsKey(key)) {
            return null;
        } else {
            return hashtable.get(key).getValue();
        }
    }

    public synchronized V remove(K key) {
        if (!hashtable.containsKey(key)) {
            return null;
        } else {
            hashtable.get(key).interrupt();
            return hashtable.remove(key).getValue();
        }
    }
}
