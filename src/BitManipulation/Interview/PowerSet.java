package BitManipulation.Interview;

import java.util.*;

// https://leetcode.com/problems/subsets/description/
public class PowerSet {
    public static void main(String[] args) {
        int []arr = {1,2,3};
        List<List<Integer>> ans = subsets(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
        }
    }
    // no of subset is 2^n or (1 << n) in bitwise
    static List<List<Integer>> subsets(int []arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        int noOfSubsets = 1 << n;
        for (int num = 0; num < noOfSubsets; num++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0){ // // check if i-th bit is set
                    list.add(arr[i]);  // add arr[i] in subset
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

/*
000 → []
001 → [1]
010 → [2]
011 → [1,2]
100 → [3]
101 → [1,3]
110 → [2,3]
111 → [1,2,3]
 */