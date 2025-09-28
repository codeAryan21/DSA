package Recursion.Basic;

import java.util.Arrays;

public class ReverseAndCheckPalindrome {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5};
        int n = arr.length;
        reverse(arr,0,n-1);
        reverse1(0,arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        String s = "Madam";
        System.out.println(isPalindrome(s,0));
    }

    static void reverse(int []arr,int left,int right){
        if(left >= right) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        swap(arr,left,right);
        reverse(arr,left+1,right-1);
    }

    static void reverse1(int i,int []arr){
        if(i >= arr.length/2) return;
        swap(arr,i, arr.length-i-1);
        reverse1(i+1,arr);
    }

    static void swap(int []arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static boolean isPalindrome(String s,int i){
        s = s.toLowerCase();
        if(i >= s.length()/2) return true;
        if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return isPalindrome(s,i+1);
    }
}
