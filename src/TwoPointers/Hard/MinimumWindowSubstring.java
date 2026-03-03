package TwoPointers.Hard;

// https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("The substring with minimum window is: " + minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int l = 0, r = 0, count = 0, startIdx = -1;
        int minLength = Integer.MAX_VALUE;
        int []hash = new int[256];

        // pre insert the characters of string t / store frequency of t
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }

        while(r < s.length()){
            // include character
            if(hash[s.charAt(r)] > 0) count++;
            hash[s.charAt(r)]--;

            // shrink window
            while(count == t.length()){
                if((r - l + 1) < minLength){
                    minLength = r - l + 1;
                    startIdx = l;
                }
                // remove from left
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);
    }
}
