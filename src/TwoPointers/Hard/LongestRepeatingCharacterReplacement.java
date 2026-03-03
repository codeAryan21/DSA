package TwoPointers.Hard;

import java.util.*;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println("Longest repeating character after replacement is: " + characterReplacement(s,k));
    }

    // length of substring/string - maxFrequency of a character
    public static int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxFreq = 0, maxLength = 0;
        int []hash = new int[26];
        Arrays.fill(hash,0);

        while(r < s.length()){
            // Increment the frequency of current character
            hash[s.charAt(r) - 'A']++;
            // Update the max frequency seen so far
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

            // if it is not a valid one then we have to trim it down from the left
            if((r - l + 1) - maxFreq > k){
                hash[s.charAt(l) - 'A'] --;
                l++;
            }
            if((r - l + 1) - maxFreq <= k){
                int length = r - l + 1;
                maxLength = Math.max(maxFreq, length);
            }
            r++;
        }
        return maxLength;
    }
}
