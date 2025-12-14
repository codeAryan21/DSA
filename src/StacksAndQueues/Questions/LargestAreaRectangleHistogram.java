package StacksAndQueues.Questions;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestAreaRectangleHistogram {
    public static void main(String[] args) {
        int []arr = {2,1,5,6,2,3};
//        int []arr = {3,2,10,11,5,10,6,3};
        System.out.println("The largest area in the histogram is: " + largestRectangleArea(arr));
    }

    static int largestRectangleArea(int []heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int element = stack.peek();
                stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea,(heights[element] * (nse - pse -1)));
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int nse = heights.length;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int element = stack.peek();
            stack.pop();

            maxArea = Math.max(maxArea,(heights[element] * (nse - pse -1)));
        }
        return maxArea;
    }
}
