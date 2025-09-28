package Recursion.Subsequences;

import java.util.*;

// https://leetcode.com/problems/permutation-sequence/description/
public class KthPermutationSequence {
    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        String ans = getPermutation(n,k);
        System.out.println(ans);
    }

    static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        // we compute n-1 factorial
        //  If n was 4 so there are total 24 combinations we create 4 blocks each of size (n-1)!. i.e. (4-1)! --> 6
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            list.add(i); // it stores the number 1,2,3
        }
        list.add(n); // and 4 over here in a list
        String ans = "";
        k = k - 1; // this is because we solve via 0 based indexing
        while (true){
            ans = ans + list.get(k / fact);
            list.remove(k / fact);
            if (list.size() == 0){
                break;
            }

            k = k % fact;
            fact = fact / list.size();
        }
        return ans;
    }
}
/*
n = 4 , k = 17, ans = ""
k = k - 1 --> 17 - 1 = 16
fact till n-1 here n is 4 so factorial is 6
list = [1,2,3,4]

ans = ans + list.get(k / fact) --> (16 / 6) = 2
ans = "3"
list.remove(k / fact) --> (16 / 6) = 2
list = [1,2,4], here size is 3
k = k % fact --> 16 % 6 = 4
fact = fact / list.size() --> 6 / 3 = 2

k = k - 1 --> 4 - 1 = 3
ans = "3" + list.get(k / fact) --> (3 / 2) =  1
ans = "32"
list.remove(k / fact) -->  (3 / 2) =  1
list = [1,4] here size is 2
k = k % fact --> 3 % 2 = 1
fact = fact / list.size() --> 2 / 2 = 1

k = k - 1 --> 1 - 1 = 0
ans = "32" + list.get(k / fact) --> (0 / 1) =  0
ans = "321"
list.remove(k / fact) -->  (0 / 1) =  0
list = [4] here size is 1
k = k % fact --> 0 % 1 = 0
fact = fact / list.size() --> 1 / 1 = 1

Now we left with the last element simply add it to the ans
ans = "3214"

at last list.size() == 0 so we break out of the while loop
 */