package TwoPointers.Hard;

import java.util.*;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSubstringAtMostKDintinctChar {
    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
        System.out.println("The length of longest substring with at most K distinct characters is: " + longestSubstring(s,k));
        System.out.println("Length of longest substring with at most K distinct characters is: " + lengthOfLongestSubstringKDistinct(s,k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k){
        int l = 0, r = 0, maxLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            // Add or update frequency in the map
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0) + 1);

            // Shrink window if more than k distinct chars
            if(map.size() > k){
                // remove the frequency of a char from a map
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                // if the count/frequency of the characters is 0 in the map then remove the character
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }

            if(map.size() <= k){
                int length = r - l + 1;
                maxLength = Math.max(maxLength,length);
            }
            r++;
        }
        return maxLength;
    }

    public static int longestSubstring(String s,int k){
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            // Use map to store character frequencies
            Map<Character,Integer> map = new HashMap<>();
            for(int j=i;j<s.length();j++){
                // Add or update frequency in the map
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0) + 1);

                if(map.size() <= k){
                    int length = j - i + 1;
                    maxLength = Math.max(maxLength,length);
                }else {
                    break;
                }
            }
        }
        return maxLength;
    }
}