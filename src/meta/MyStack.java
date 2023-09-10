package meta;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
        private final Queue<Integer> queueOne;
        private final Queue<Integer> queueSecond;


        public MyStack() {
            queueOne = new LinkedList<>();
            queueSecond = new LinkedList<>();
        }

        public void push(int x) {
            if (!queueSecond.isEmpty()) {
                queueOne.add(queueSecond.poll());
            }

            queueSecond.add(x);
        }

        public int pop() {
            var value = queueSecond.poll();
            if (queueOne.size() == 1) {
                queueSecond.add(queueOne.poll());
            } else {
                while (!queueOne.isEmpty()) {
                    queueSecond.add(queueOne.poll());
                }

                while (!queueSecond.isEmpty() && queueSecond.size() != 1) {
                    queueOne.add(queueSecond.poll());
                }
            }


            return value;
        }

        public int top() {
            return queueSecond.peek();
        }

        public boolean empty() {
            return queueSecond.isEmpty();
        }
}
