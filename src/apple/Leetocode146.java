package apple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetocode146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        System.out.println("failed " + cache.get(2));
    }
}

class LRUCache {
    private int capacity;
    private final Map<Integer, Integer> memo;
    private final LinkedList<Integer> orderSet;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.memo = new HashMap<>();
        this.orderSet = new LinkedList<>();
    }

    public int get(int key) {
        if (memo.containsKey(key)) {
            orderSet.remove((Object) key);
            orderSet.addFirst(key);
            return memo.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (memo.containsKey(key)) {
            memo.put(key, value);

            orderSet.remove((Object) key);
            orderSet.addFirst(key);
        } else {
            if (memo.size() >= capacity) {
                Integer lastKey = orderSet.removeLast();
                memo.remove(lastKey);
            }

            memo.put(key, value);
            orderSet.addFirst(key);
        }
    }
}