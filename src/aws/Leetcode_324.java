package aws;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode_324 {
    public static void main(String[] args) {
        int [] data = new int[]{1,3,2,2,3,1};
        wiggleSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i =0;i<len;i++){

            pq.offer(nums[i]);


        }
        for(int i=0;i<len;i++){

            if(i%2!=0){
                nums[i]=pq.poll();
            }


        }
        for(int i=0;i<len;i++){
            if(i%2==0 ){
                nums[i]= pq.poll();

            }

        }
    }
}
