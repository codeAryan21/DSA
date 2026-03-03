package TwoPointers.Medium;

import java.util.*;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int []arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("The maximum fruits is: " + totalFruit(arr));
    }

    public static int totalFruit(int []fruits){
        int l = 0, r = 0, maxLength = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r < fruits.length){
            // Add or update frequency in the map
            map.put(fruits[r],map.getOrDefault(fruits[r],0) + 1);
            // If more than 2 fruit types, shrink window from left
            if(map.size() > 2){
                // reduce the frequency of a digit from a map
                map.put(fruits[l], map.get(fruits[l]) - 1);
                // if the count/frequency of the digits is 0 in the map then remove the digit
                if(map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }
            if(map.size() <= 2){
                int length = r - l + 1;
                maxLength = Math.max(maxLength,length);
            }
            r++;
        }
        return maxLength;
    }
}