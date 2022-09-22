package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode_735 {
    public static void main(String[] args) {
        //10,2,-5
        //5,10,-5
        int[] values = {10,2,-5};
        System.out.println(Arrays.toString(asteroidCollision(values)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length <= 1) {
            return asteroids;
        }
        Stack<Integer> memory = new Stack<>();

        for (int asteroid: asteroids) {
            if (memory.isEmpty() || asteroid > 0) {
                memory.push(asteroid);
            } else {
                while (true) {
                    int peek = memory.peek();
                    if (peek < 0) {
                        memory.push(asteroid);
                        break;
                    } else if (peek == -asteroid) {
                        memory.pop();
                        break;
                    } else if (peek > -asteroid) {
                        break;
                    } else {
                        memory.pop();
                        if (memory.isEmpty()) {
                            memory.push(asteroid);
                            break;
                        }
                    }
                }
            }

        }

       int size = memory.size();
       int [] result = new int[size];
        for (int i = size -1  ; i >= 0; i--) {
            result[i] = memory.pop();
        }

       return result;
    }
}
