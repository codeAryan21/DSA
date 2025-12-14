package StacksAndQueues.Conversions;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String s = "x+y*z/w+u";
//        String s = "(A-B/C)*(A/K-L)";
        System.out.println("Infix Expression: " + s);
        System.out.println("Prefix Expression: " + infixToPrefix(s));
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

    static String infixToPrefix(String s){
        // Step 1: Reverse and swap brackets
        StringBuilder input = new StringBuilder(s).reverse();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                input.setCharAt(i, ')');
            else if (input.charAt(i) == ')')
                input.setCharAt(i, '(');
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        // Step 2: Convert to postfix (on reversed string)
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }
            // Closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop(); // remove '('
            }
            // Operator
            else {
                while (!stack.isEmpty() && Prec(ch) <= Prec(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all remaining operators
        while (!stack.isEmpty())
            result.append(stack.pop());

        // Step 3: Reverse the result
        return result.reverse().toString();
    }
}

/*
Steps to convert Infix to Prefix :-
1- Reverse the infix
2- Infix to Postfix
3- Reverse the answer
*/
