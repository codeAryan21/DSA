package StacksAndQueues.Questions;

import java.util.*;

// https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElement1 {
    public static void main(String[] args) {
//        int []arr = {5,7,1,2,6,0};
        int []arr = {4,12,5,3,1,2,5,3,1,2,4,6};

        int []ans = nextGreaterElement(arr);
        System.out.print("The next greater elements are: ");
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int[] nextGreaterElement(int []arr){
        int []nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = -1;
            }else {
                nge[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return nge;
    }
}
