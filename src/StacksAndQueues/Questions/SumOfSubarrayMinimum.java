package StacksAndQueues.Questions;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumOfSubarrayMinimum {
    public static void main(String[] args) {
//        int []arr = {3,1,2,4};
        int []arr = {1,4,3,2};
        System.out.println("Sum of minimum subArray is: " + minimumSubArraySum(arr));
    }

    static int minimumSubArraySum(int []arr){
        int total = 0;
        int mod = (int)(1e9 + 7);
        int []pse = previousSmallerElement(arr);
        int []nse = nextSmallerElement(arr);
        for(int i=0;i<arr.length;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (total + (left * right * arr[i]) % mod) % mod;
        }
        return total;
    }

    static int[] previousSmallerElement(int []arr){
        int []pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }

    static int[] nextSmallerElement(int []arr){
        int []nse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = arr.length;
            }else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        return nse;
    }

    /*
    static int minimumSubArraySum(int []arr){
        int sum = 0;
//        int mod = (int)(1e9 + 7);
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min,arr[j]);
                sum += min;
//                sum = (sum + min) % mod;
            }
        }
        return sum;
    }
     */
}
