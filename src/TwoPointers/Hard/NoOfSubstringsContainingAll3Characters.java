package TwoPointers.Hard;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
public class NoOfSubstringsContainingAll3Characters {
    public static void main(String[] args) {
        String s = "bbacba";
        System.out.println("The number of substrings containing all three characters is: " + numberOfSubstrings(s));
    }

    public static int numberOfSubstrings(String s) {
        int []lastSeen = {-1,-1,-1}; // array for the 3 characters initially not seen that's why marked as -1;
        int count = 0;
        for(int i=0;i<s.length();i++){
            // Convert characters to indices
            lastSeen[s.charAt(i) - 'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1],lastSeen[2])));
            }
        }
        return count;
    }
}
