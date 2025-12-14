package StacksAndQueues.Implementation;

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int []arr = {7,2,1,3,3,1,8};

        int []ans = stockSpanner(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }

    // Stock Span:- maximum consecutive days for which the stock price was less that or equal to current days.
    static int[] stockSpanner(int []arr){
        int []pge = previousGreaterElement(arr);
        int []ans = new int[arr.length]; // ans to store the final span result

        //  compute the span for each element using the pge
        for(int i=0;i<arr.length;i++){
            ans[i] = i - pge[i]; // calculate the span days based on the previous greater element. we subtract the current index i - pge[i]
        }
        return ans;
    }

    static int[] previousGreaterElement(int []arr){
        Stack<Integer> stack = new Stack<>();
        int []pge = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
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
}
