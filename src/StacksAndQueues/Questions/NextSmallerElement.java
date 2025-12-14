package StacksAndQueues.Questions;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int []arr = {4,5,2,10,8};
//        int []arr = {5,7,9,6,7,4,5,1,3,7};

        int []ans = nextSmallerElement(arr);
        System.out.print("The next smaller elements are: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int[] nextSmallerElement(int []arr){
        int []nse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = -1;
            }else {
                nse[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return nse;
    }
}
