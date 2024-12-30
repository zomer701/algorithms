package amazon;

import structures.ListNode;

public class Leetcode1290 {
    public static void main(String[] args) {

    }

    public static int getDecimalValue(ListNode head) {
        int asn = 0;
        while (head != null) {
            asn = asn  * 2 + (int)head.data;
            head = head.next;
        }

        return asn;
    }

    public static int getDecimal(int binary){
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int temp = binary%10;
                decimal += (int) (temp*Math.pow(2, n));
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }
}
