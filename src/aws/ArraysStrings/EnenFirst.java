public class EnenFirst {

    void evenFirst(int [] arr) {
        int poin1 = 0;
        int poin2 = arr.length-1;

        while (poin1 <= poin2) {
            if (arr[poin1] % 2 == 0) {
                poin1++;
            } else {
                int temp = arr[poin1];
                arr[poin1] =  arr[poin2];
                arr[poin2--] = temp;
            }

        }
    }
}
