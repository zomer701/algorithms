package leetcode;

import java.util.ArrayList;
import java.util.List;

//comples 2^n  space n
public class Tower_Hanoi {
    public static void main(String[] args) {

        towerHanoi(4, 'x', 'z' , 'c');
    }

    static void towerHanoi(int n, char from, char to, char aux) {
        if (n == 1) {

        } else {
            towerHanoi(n-1, from, aux, to);
            towerHanoi(n-1, aux, to, from);

        }
    }
}
