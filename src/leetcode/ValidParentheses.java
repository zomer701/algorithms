package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("[["));
    }

    public boolean isValid(String s) {
        Stack<Character> values = new Stack<>();

        Map<Character, Character> temp = new HashMap<>();
        temp.put(')','(');
        temp.put('}','{');
        temp.put(']','[');



        for(int i =0;i<s.length();i++) {
            Character val = s.charAt(i);
            if(temp.get(val)==null) {
                values.push(val);
            }else{
                if(values.size() <= 0 || values.pop() != temp.get(val)) {
                    return false;
                }
            }

        }

        if (values.size() > 0) {
            return false;
        }
        return true;
    }
}
