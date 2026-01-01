package nvidia;

import java.util.HashMap;
import java.util.Map;

public class Leetcode146 {
}



class LRUCache {

    class Node {
        int value;
        int key;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private final Map<Integer, Node> memo;
    private Node tail;
    private Node header;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.memo = new HashMap<>();
        tail = new Node(1, 1);
        header = new Node(1, 1);
        tail.next = header;
        header.prev = tail;
    }

    public int get(int key) {
        if (memo.containsKey(key)) {
            Node current = memo.get(key);
            delete(current.key);
            insert(current);
            return current.value;

        }
        return -1;
    }

    public void put(int key, int value) {
        Node newNode = memo.getOrDefault(key, new Node(key, value));
        newNode.value = value;
        delete(key);
        insert(newNode);

        memo.put(key, newNode);

        if (memo.size() > capacity) {
            Node lru = tail.next;
            delete(lru.key);
            memo.remove(lru.key);
        }
    }

    private void insert(Node node) {
        Node prev = this.header.prev;
        Node next = this.header;

        prev.next = node;
        node.prev = prev;

        next.prev = node;
        node.next = next;
    }

    private void delete(int key) {
        if (memo.containsKey(key)) {
            Node current = memo.get(key);
            Node prev = current.prev;
            Node next = current.next;

            prev.next = next;
            next.prev = prev;
        }
    }
}