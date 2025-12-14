package StacksAndQueues.Questions;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-ranges/
public class SumOfSubArrayRanges {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        System.out.println("Sum of subArray in ranges is: " + sumOfSubArrayRanges(arr));
    }

    static int sumOfSubArrayRanges(int []arr){
        return maximumSubArraySum(arr) - minimumSubArraySum(arr);
    }

    static int maximumSubArraySum(int []arr){
        int total = 0;
        int mod = (int)(1e9 + 7);
        int []pge = previousGreaterElement(arr);
        int []nge = nextGreaterElement(arr);
        for(int i=0;i<arr.length;i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            total = (total + (left * right * arr[i]) % mod) % mod;
        }
        return total;
    }

    static int[] previousGreaterElement(int []arr){
        int []pge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pge[i] = -1;
            }else {
                pge[i] = stack.peek();
            }
            stack.push(i);
        }
        return pge;
    }

    static int[] nextGreaterElement(int []arr){
        int []nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = arr.length;
            }else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        return nge;
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
    // Difference between the largest and smallest in the subArray ranges
    static int sumOfSubArrayRanges(int []arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int largest = arr[i];
            int smallest = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                largest = Math.max(largest,arr[j]);
                smallest = Math.min(smallest,arr[j]);
                sum = sum + (largest - smallest);
            }
        }
        return sum;
    }
     */
}
