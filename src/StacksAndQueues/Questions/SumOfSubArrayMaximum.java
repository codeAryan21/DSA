package StacksAndQueues.Questions;

import java.util.Stack;

public class SumOfSubArrayMaximum {
    public static void main(String[] args) {
        int []arr = {1,4,3,2};
        System.out.println("Sum of maximum subArray is: " + maximumSubArraySum(arr));
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
}
