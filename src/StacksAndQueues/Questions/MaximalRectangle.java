package StacksAndQueues.Questions;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        int [][]matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        System.out.println("The largest rectangle area containing all 1s is: " + maximalRectangle(matrix));
    }

    static int maximalRectangle(int[][] matrix) {
        int n = matrix.length; // no. of rows
        int m = matrix[0].length; // no. of cols
        int maxArea = 0;
        int [][]prefixSum = new int[n][m];

        // storing the prefixSum of each row that's why we traverse col wise
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + matrix[i][j];
                if(matrix[i][j] == 0){
                    prefixSum[i][j] = 0;
                    sum = 0;
                }
                prefixSum[i][j] = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea,largestRectangleArea(prefixSum[i]));
        }
        return maxArea;
    }

    static int largestRectangleArea(int []arr){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int element = stack.peek();
                stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();

                maxArea = Math.max(maxArea,(arr[element] * (nse - pse - 1)));
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int element = stack.peek();
            stack.pop();
            int nse = arr.length;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            maxArea = Math.max(maxArea,(arr[element] * (nse - pse - 1)));
        }

        return maxArea;
    }
}
