package StacksAndQueues.Questions;

import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int []arr = {4,5,2,10,8};
//        int []arr = {5,7,9,6,7,4,5,1,3,7};

        int []ans = previousSmallerElement(arr);
        System.out.print("The previous smaller elements are: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int[] previousSmallerElement(int []arr){
        int []pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< arr.length;i++){
            while (!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }else {
                pse[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return pse;
    }
}
