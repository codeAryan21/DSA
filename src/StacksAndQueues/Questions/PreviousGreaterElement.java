package StacksAndQueues.Questions;

import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int []arr = {5,7,1,2,6,0};
//        int []arr = {4,12,5,3,1,2,5,3,1, 2,4,6};

        int []ans = previousGreaterElement(arr);
        System.out.print("The previous greater elements are: ");
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int[] previousGreaterElement(int []arr){
        int []pge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< arr.length;i++){
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pge[i] = -1;
            }else {
                pge[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return pge;
    }
}
