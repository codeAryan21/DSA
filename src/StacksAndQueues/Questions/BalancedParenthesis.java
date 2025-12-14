package StacksAndQueues.Questions;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
public class BalancedParenthesis {
    public static void main(String[] args) {
//        String s = "()[{}()]";
        String s = "()[{}(])";
        System.out.println(checkBalancedParenthesis(s));
    }

    static boolean checkBalancedParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{'){
                stack.push(str.charAt(i));
            }else {
                if(stack.isEmpty()) return false;
                Character ch = stack.peek();
                stack.pop();
                if (str.charAt(i) == ')' && ch == '(' || str.charAt(i) == ']' && ch == '[' || str.charAt(i) == '}' && ch == '{') {

                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
