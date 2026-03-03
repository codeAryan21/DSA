package TwoPointers.Medium;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubStringWithoutRepeating {
    public static void main(String[] args) {
        String s = "cadbzabcd";
//        System.out.println("The length of the longest substring without repeating characters is: " + lengthOfLongestSubstring(s));
        System.out.println("The length of the longest substring without repeating characters is: " + sizeOfLongestSubstring(s));
    }

    public static int sizeOfLongestSubstring(String str){
        int []hash = new int[256];
        Arrays.fill(hash,-1);
        int l = 0, r = 0, maxLength = 0;

        while(r < str.length()){
            // If current character s.charAt(r) is already in the substring
            if(hash[str.charAt(r)] != -1){  // check the character is in the map
                if(hash[str.charAt(r)] >= l){
                    // Move left pointer to the right of the last occurrence of s.charAt(r)
                    l = hash[str.charAt(r)] + 1;
                }
            }
            // Calculate the current substring length
            int length = r - l + 1;
            maxLength = Math.max(maxLength,length);

            // store the index of the current character in the hash table
            hash[str.charAt(r)] = r;
            r++; // Move right pointer to next position
        }
        return maxLength;
    }

    // Brute force
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            int []hash = new int[256];
            Arrays.fill(hash,0);

            for(int j=i;j<s.length();j++){
                if(hash[s.charAt(j)] == 1) break; // if the character is found repeated then stop/break it
                hash[s.charAt(j)] = 1; // put it into the hash
                int length = j - i + 1;
                maxLength = Math.max(maxLength,length);
            }
        }
        return maxLength;
    }
}
