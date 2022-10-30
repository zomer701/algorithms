package google;

import java.util.HashMap;
import java.util.Map;

public class Leetcod_76 {

    public static void main(String[] args) {
       // "aefgc"
        //"cwae"

        System.out.println(new Leetcod_76().minWindow2("defgddaaecfceffccsdadase", "ccae"));
    }


    public String minWindow2(String s, String t) {
        if (s.length() < 1 || t.length() < 1) {
            return "";
        }

        if (t.length() > s.length()) {
            return "";
        }


        Map<Character, Integer> nextValues = new HashMap<>();

        for (char val: t.toCharArray()) {
            nextValues.put(val, nextValues.getOrDefault(val, 0) + 1);
        }

        boolean found = false;
        int i = 0;
        int j = 0;
        int left = 0;
        int count = nextValues.size();
        int r = s.length() -1;
        int min = s.length();

        while (j < s.length()) {
            char endChar = s.charAt(j++);
            if (nextValues.containsKey(endChar)) {
                nextValues.put(endChar, nextValues.get(endChar) -1);
                if (nextValues.get(endChar) == 0) {
                    count -= 1;
                }
            }


            if (count > 0) {
                continue;
            }

            while (count == 0) {
                char startChar = s.charAt(i++);
                if (nextValues.containsKey(startChar)) {
                    nextValues.put(startChar, nextValues.get(startChar) + 1);
                    if (nextValues.get(startChar) > 0) {
                        count += 1;
                    }
                }
            }

            if ((j - i) < min) {
                left = i;
                r = j;
                min = j - i;
                found = true;
            }
        }

        return !found ? "" : s.substring(left-1, r);
    }

    public String minWindow(String s, String t) {
        if (s.length() < 1 || t.length() < 1) {
            return "";
        }

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tList = new HashMap<>();
        int minSlide = Integer.MAX_VALUE;
        String result = "";

        for (char val: t.toCharArray()) {
            tList.put(val, tList.getOrDefault(val, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Character firstChar = s.charAt(i);

            if (tList.containsKey(firstChar)) {

                Map<Character, Integer> newMap  = new HashMap<>(tList);
                StringBuilder partResult = new StringBuilder();

                for (int j = i ; j < s.length(); j++) {
                    partResult.append(s.charAt(j));

                    Integer val = newMap.get(s.charAt(j));
                    if (val != null) {
                        int newVal = val - 1;
                        if (newVal <= 0) {
                            newMap.remove(s.charAt(j));
                        }

                        if (newMap.isEmpty()) {
                            if (j - i < minSlide) {
                                result = partResult.toString();
                                minSlide = j - i;
                            }
                            break;
                        }
                        if (newVal > 0) {
                            newMap.put(s.charAt(j), newVal);
                        }
                    }

                }
            }
        }

        return result;
    }
}
