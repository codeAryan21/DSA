package Array.Hard;

import java.util.*;

// https://leetcode.com/problems/pascals-triangle/?envType=problem-list-v2&envId=array
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println("The element at that position is : " + findElement(6,2)); // Type 1
        printRow(4); // Type 2
        System.out.println();

        List<List<Integer>> ans = pascalTriangle(5);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    // Type 1: Given row and col find the element at that place by nCr method;
    static long nCr(int n,int r){
        long resultant = 1;

        // calculating nCr
        for (int i = 0; i < r; i++) {
            resultant = resultant * (n-i); // numerator keeps on multiplying
            resultant = resultant  / (i+1);
        }
        return resultant;
    }

    static int findElement(int r,int c){ // r(row) -> n, c(col) -> r
        int element = (int) nCr(r-1,c-1);
        return element;
    }

    // Type 2: Given the row number n. Print the n-th row of Pascal’s triangle.
    // formula : currentElement = prevRowElement * (row - colIndex) / colIndex
    // https://leetcode.com/problems/pascals-triangle-ii/?envType=problem-list-v2&envId=array
     static void printRow(int n){
        long ans = 1;
         System.out.print(ans + " "); // first element of the row
         for (int i = 1; i < n; i++) {
             ans = ans * (n-i); // prevRowElement * (row - colIndex)
             ans = ans / i; // ans / colIndex
             System.out.print(ans + " ");
         }
         System.out.println();
     }

     // Type 3: Print the entire pascal triangle of N size;
    static  List<Integer> getRow(int row) {
        List<Integer> list = new ArrayList<>();
        long ans = 1;
        list.add(1);// inserting the 1st element

        //calculate the rest of the elements:
        for(int i=1;i<row;i++){ // i = col
            ans = ans * (row - i);
            ans = ans / i;
            list.add((int)ans);
        }
        return list;
    }

    static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> ans = new ArrayList<>();
        //store the entire pascal's triangle
        for (int row=1;row<=n;row++){
            ans.add(getRow(row));
        }
        return ans;
    }
}