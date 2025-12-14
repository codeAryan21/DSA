package StacksAndQueues.Conversions;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String s = "AB-DE+F*/";
//        String s = "abcd^e-fgh*+^*+i-";

        System.out.println("Postfix Expression: " + s);
        System.out.println("Infix Expression: " + postfixToInfix(s));
    }

    static String postfixToInfix(String s){
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < s.length()){
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                stack.push(String.valueOf(s.charAt(i)));
            }else {
                String t1 = stack.peek();
                stack.pop();
                String t2 = stack.peek();
                stack.pop();
                String newVal = "(" + t2 + s.charAt(i) + t1 + ")";
                stack.push(newVal);
            }
            i++;
        }
        return stack.peek();
    }
}
