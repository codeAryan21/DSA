package StacksAndQueues.Questions;

import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-ii/description/
public class NextGreaterElement2 {
    public static void main(String[] args) {
//        int []arr = {2,10,12,1,11};
        int []arr = {5,7,1,2,6,0};
        int []ans = nextGreaterElement(arr);
        System.out.print("The next greater elements are: ");
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int[] nextGreaterElement(int []arr){
        int []nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i % arr.length]){
                stack.pop();
            }
            if(i < arr.length){
                if (stack.isEmpty()) {
                    nge[i] = -1;
                }else {
                    nge[i] = stack.peek();
                }
            }
            stack.push(arr[i % arr.length]);
        }
        return nge;
    }
}
