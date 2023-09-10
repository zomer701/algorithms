package meta;

public class Leetcode_225 {
    public static void main(String[] args) {
        var stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("top = " + stack.top());
        System.out.println("pop = " + stack.pop());
        System.out.println("empty = " + stack.empty());
        System.out.println("top = " + stack.top());
        System.out.println("pop = " + stack.pop());
        System.out.println("empty = " + stack.empty());
        stack.push(3);
        System.out.println("top = " + stack.top());
        System.out.println("pop = " + stack.pop());
    }
}
