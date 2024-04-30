package trello;

import java.util.HashMap;
import java.util.Map;

public class HashMapTask {


    public static void main(String[] args) {
        int size = 'z' - 'a' + 1;

        String check = "abcdefghijklmnopqrstuvwx";

        Map<Character, Boolean> uniqueTrack = new HashMap<>(size);
        for (char alfa : getAlphabet(size)) {
            uniqueTrack.put(alfa, false);
        }

        for (char alfa : check.toCharArray()) {
            if (uniqueTrack.get(alfa) != null) {
                uniqueTrack.put(alfa, true);
            }
        }


        for (char alfa : uniqueTrack.keySet()) {

            if (!uniqueTrack.get(alfa)) {
                System.out.println(alfa);
            }
        }
    }

    private static char[] getAlphabet(int charAmount) {


        char[] alpha = new char[charAmount];
        for(int i = 0; i < charAmount ; i++){
            alpha[i] = (char)('a' + i);
        }

        return alpha;
    }

}
