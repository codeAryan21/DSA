package StacksAndQueues.Conversions;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
//        String s = "a+b*(c^d-e)";
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + s);
        System.out.println("Postfix Expression: " + infixToPostfix(s));
    }

    static int Prec(char ch){
        if(ch == '^'){
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }
        return -1;
    }

    static String infixToPostfix(String s){
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)){
                ans = ans + c;
            }else if(c == '('){
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '('){
                    ans = ans + stack.peek();
                    stack.pop();
                }
                stack.pop();
            }else {
                while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    ans = ans + stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            if (stack.peek() == '(') return "Invalid Expression";
            ans = ans + stack.peek();
            stack.pop();
        }
        return ans;
    }
}
