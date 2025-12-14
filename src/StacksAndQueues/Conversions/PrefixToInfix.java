package StacksAndQueues.Conversions;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String s = "*+PQ-MN";

        System.out.println("Prefix Expression: " + s);
        System.out.println("Infix Expression: " + prefixToInfix(s));
    }

    static String prefixToInfix(String s){
        int i = s.length() - 1;
        Stack<String> stack = new Stack<>();
        while (i >= 0){
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                stack.push(String.valueOf(s.charAt(i)));
            }else {
                String t1 = stack.peek();
                stack.pop();
                String t2 = stack.peek();
                stack.pop();
                String newVal = "(" + t1 + s.charAt(i) + t2 + ")";
                stack.push(newVal);
            }
            i--;
        }
        return stack.peek();
    }
}
