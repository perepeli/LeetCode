package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap {
}

class Bucket {
    private List<PairKV<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<PairKV<Integer, Integer>>();
    }

    public Integer get(Integer key) {
        for(PairKV<Integer, Integer> pair : this.bucket) {
            if(pair.key.equals(key)) {
                return pair.value;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value) {
        boolean found = false;
        for(PairKV<Integer, Integer> pair: this.bucket) {
            if(pair.key.equals(key)) {
                pair.value = value;
                found = true;
            }
        }
        if(!found)
            this.bucket.add(new PairKV<Integer, Integer>(key, value));
    }

    public void remove(Integer key) {
        for(PairKV<Integer, Integer> pair : this.bucket) {
            if(pair.key.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}

class MyHashMap {
    private int key_space;
    private List<Bucket> hash_table;

    public MyHashMap() {
        this.key_space = 2069;
        this.hash_table = new ArrayList<Bucket>();
        for(int i = 0; i < this.key_space; i++) {
            this.hash_table.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).update(key, value);
    }

    public int get(int key) {
        int hash_key = key % this.key_space;
        return this.hash_table.get(hash_key).get(key);
    }

    public void remove(int key) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).remove(key);
    }
}

class PairKV<K, V> {
    public K key;
    public V value;

    public PairKV(K key, V value) {
        this.key = key;
        this.value = value;
    }
}