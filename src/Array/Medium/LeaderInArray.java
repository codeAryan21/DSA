package Array.Medium;

import java.util.ArrayList;

public class LeaderInArray {
    public static void main(String[] args) {
        int []arr = {10,22,12,3,0,6};
        ArrayList<Integer> ans = superiorElement(arr);
        System.out.println("The leaders of the array are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    static ArrayList<Integer> superiorElement(int []arr){
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i] > max){
                list.add(arr[i]);
            }
            max = Math.max(max,arr[i]);
        }
        return list;
    }
}