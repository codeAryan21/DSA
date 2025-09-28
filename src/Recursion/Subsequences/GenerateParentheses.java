package Recursion.Subsequences;

import java.util.*;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }

    static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        parentheses("",n,0,0,ans);
        return ans;
    }

    static void parentheses(String s,int n,int open,int close,List<String> list){
        // when the string length is 2*n (all parentheses used)
        if(s.length() == 2*n){
            list.add(s);
            return;
        }
        // At any point, the number of ( used must not exceed n.
        if(open < n){
            parentheses(s + "(",n,open + 1,close,list);
        }
        // At any point, the number of ) used must not exceed the number of ( used (to keep balance).
        if(close < open){
            parentheses(s + ")",n,open,close + 1,list);
        }
    }
}
