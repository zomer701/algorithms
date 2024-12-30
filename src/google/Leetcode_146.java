package google;

import structures.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetcode_146 {
    public static void main(String[] args) {

    }


    class LRUCache {
        private int capacity;
        private Map<Integer, Integer> hashMemo;
        private ListNode  v;
        public LRUCache(int capacity) {
            this.capacity = capacity;
             v = new ListNode(-1);
            hashMemo = new HashMap<>();
        }

        public int get(int key) {
          hashMemo.getOrDefault(key, -1);
          return -1;
        }

        // no value
        // exist value replace
        //
        public void put(int key, int value) {
//            if (hashMemo.size() == capacity) {
//                ListNode temp =  v;
//                ListNode prev = null;
//                for (int i = 0; i < capacity ; i ++) {
//                    if ((Integer) temp.data == key || i == capacity {
//                        ListNode tempNext = prev.next.next;
//                        prev.next = new ListNode(key);
//                        prev.next.next = tempNext;
//                        break;
//                    }
//                    prev = temp;
//                    temp = temp.next;
//                }
//
//
//            } else {
//                hashMemo.put(key, value);
//                v.next = new ListNode(value);
//            }
        }
    }
}
