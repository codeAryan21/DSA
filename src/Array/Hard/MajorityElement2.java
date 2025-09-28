package Array.Hard;

import java.util.*;

// https://leetcode.com/problems/majority-element-ii/description/?envType=problem-list-v2&envId=array
public class MajorityElement2 {
    public static void main(String[] args) {
        int []arr = {1,2,3,1,1,3,2,3};
        List<Integer> ans = findMajorityElement(arr);
        System.out.print("The majority element in the array is : ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    static List<Integer> findMajorityElement(int []arr){
        int counter1 = 0;
        int counter2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(counter1 == 0 && element2 != arr[i]){
                counter1 = 1;
                element1 = arr[i];
            }else if(counter2 == 0 && element1 != arr[i]){
                counter2 = 1;
                element2 = arr[i];
            } else if (arr[i] == element1) {
                counter1++;
            } else if (arr[i] == element2) {
                counter2++;
            }else {
                counter1--;
                counter2--;
            }
        }

        List<Integer> list = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in element1 and element2 are the majority elements
        counter1 = 0; counter2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == element1) counter1++;
            if(arr[i] == element2) counter2++;
        }
        int minimum = (arr.length/3) + 1;
        if(counter1 >= minimum) list.add(element1);
        if(counter2 >= minimum) list.add(element2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        // Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return list;
    }
}
