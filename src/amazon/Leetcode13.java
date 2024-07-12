package amazon;

import java.util.HashMap;
import java.util.Map;

//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
public class Leetcode13 {
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public static void main(String[] args) {
        System.out.print(romanToInt("MCMXCIV")); //58
    }

//M = 1000, CM = 900, XC = 90 and IV = 4.

    public static int romanToInt(String s) {
        int result = 0;

        int leng = s.length();
        int count = 0;
        while (count < leng) {

            if (count+1 < leng && values.containsKey(""+s.charAt(count) + s.charAt(count + 1))) {
                result+=values.get(""+s.charAt(count) + s.charAt(count + 1));
                count=count+2;
            } else {
                result+=values.get(String.valueOf(s.charAt(count)));
                count=count+1;
            }


        }

        return result;
    }
}
