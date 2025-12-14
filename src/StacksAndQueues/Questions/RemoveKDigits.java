package StacksAndQueues.Questions;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/description/
public class RemoveKDigits {
    public static void main(String[] args) {
        String nums = "1432219";
        int k = 3;
        System.out.println("The smallest possible integer after removing k digits is: " + removeKDigits(nums,k));
    }

    static String removeKDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            // Pop last digits if a smaller digit is found and k > 0
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)){
                stack.pop();
                k = k -1;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0){
            stack.pop();
            k--;
        }

        // Handle edge case: if stack is empty
        if (stack.isEmpty()) return "0";

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.peek());
            stack.pop();
        }

        // Trim the leading zeros
        while (result.length() > 0 && result.charAt(result.length()-1) == '0'){
            result.deleteCharAt(result.length()-1);
        }
        // Reverse the string to get the correct number
        result.reverse();

        // If result is empty, return "0"
        if (result.length() == 0) return "0";

        return result.toString();
    }
}
