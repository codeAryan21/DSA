package StacksAndQueues.Conversions;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String s = "/-AB*+DEF";
        System.out.println("Prefix Expression: " + s);
        System.out.println("Postfix Expression: " + prefixToPostfix(s));
    }

    static String prefixToPostfix(String s){
        int i = s.length()-1;
        Stack<String> stack = new Stack<>();
        while (i >= 0){
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                stack.push(String.valueOf(s.charAt(i)));
            }else {
                String t1 = stack.peek();
                stack.pop();
                String t2 = stack.peek();
                stack.pop();
                String newVal = t1 + t2 + s.charAt(i);
                stack.push(newVal);
            }
            i--;
        }
        return stack.peek();
    }
}
