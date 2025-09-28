package Recursion.Subsequences;

import java.util.*;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> ans = partition(s);
        System.out.println(ans);
    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitioning(0,s,new ArrayList<>(),ans);
        return ans;
    }

    static void partitioning(int index,String s,List<String> list,List<List<String>> ans){
        if (index >= s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                partitioning(i+1,s,list,ans);
                list.remove(list.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
