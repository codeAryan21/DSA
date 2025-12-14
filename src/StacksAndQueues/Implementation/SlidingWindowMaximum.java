package StacksAndQueues.Implementation;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int []arr = {1,3,-1,-3,5,3,7,1,6};
//        int []arr = {4,0,-1,3,5,3,6,8};
        int k = 3;

        int []ans = maxSlidingWindow(arr,k);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }

    static int[] maxSlidingWindow(int []arr,int k){
        int []ans = new int[arr.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int ind = 0;
        for(int i=0;i< arr.length;i++){
            // remove the number that are out of range
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            // remove smaller numbers in k range
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }

            dq.offer(i);
            if(i >= k - 1){
                ans[ind] = arr[dq.peekFirst()];
                ind++;
            }
        }
        return ans;
    }
}

/*
--> keep the track of K elements, keep the window elements
--> monotonic stack, keep elements in decreasing order
*/