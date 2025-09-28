package Recursion.Subsequences;

import java.util.*;

public class GenerateAllBinaryStrings {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateBinaryStrings(n);
        System.out.println(ans);
    }

    static List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        subStrings("",n,ans);
        return ans;
    }

    static void subStrings(String s,int n,List<String> list){
        if (s.length() == n){
            list.add(s);
            return;
        }
        // we can always add "0"
        subStrings(s + "0",n,list);
        // Add "1" only if last char is not '1'
        if (s.isEmpty() || s.charAt(s.length()-1) != '1'){
            subStrings(s + "1",n,list);
        }
    }

}
