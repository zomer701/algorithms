package chargelab;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class CLPriorityQueue<E> {

    private final ReentrantLock lock = new ReentrantLock();

    private final LinkedList<Pair> queue;
    private ThrottleRateState state;

    private int initialCapacity;

    public CLPriorityQueue(int initialCapacity) {
        this.queue = new LinkedList<>();
        this.initialCapacity = initialCapacity;
        state = new ThrottleRateState();
    }

    void add(Integer item) {
       add((E) item, item);
    }

    void add(E item, int priority) {
        if (priority < 1) {
            throw new IllegalArgumentException("priority must be >= 1");
        }

        if (item == null) {
            throw new NullPointerException();
        }

        if (queue.size() == initialCapacity) {
            throw new IllegalArgumentException("queue is full");
        }

        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            queue.add(new Pair<>(item, priority));
            queue.sort(Comparator.comparingInt(Pair::getPriority));
        } finally {
            lock.unlock();
        }
    }

    public int getSize() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();

        try {
            if (queue.size() == 0) {
                throw new IllegalArgumentException("queue is empty");
            }

            if (state.isThrottle()) {
                Integer newPriority = state.getLast() + 1;
                for (Pair item: queue) {
                    if (Objects.equals(item.getPriority(), newPriority)) {
                        queue.remove(item);
                        state.addPriority(item.getPriority());
                        return (E) item.getValue();
                    }
                }
            }

            Pair item = queue.getFirst();
            queue.remove(0);
            state.addPriority(item.getPriority());
            return (E) item.getValue();
        } finally {
            lock.unlock();
        }
    }

    private class ThrottleRateState {

        public ThrottleRateState() {
            this.memo = new HashMap<>();
        }

        private Integer prev;
        private final HashMap<Integer, Boolean> memo;

        public void addPriority(int priority) {
            if (memo.containsKey(priority)) {
                memo.put(priority, true);
            } else {
                memo.put(priority, false);
            }
            prev = priority;
        }

        public boolean isThrottle() {
            boolean isTh = prev != null && Boolean.TRUE == memo.get(prev);
            if (isTh) {
                memo.remove(prev);
            }

            return isTh;
        }

        public Integer getLast() {
            return prev;
        }
    }

    private class Pair<E> {
        private final E val;
        private final Integer priority;

        public Pair(E val, Integer priority) {
            this.val = val;
            this.priority = priority;
        }

        public E getValue() {
            return val;
        }

        public Integer getPriority() {
            return priority;
        }
    }
}
