package Array.Hard;

import java.util.*;

// https://leetcode.com/problems/merge-intervals/description/?envType=problem-list-v2&envId=array
public class MergeOverlappingInterval {
    public static void main(String[] args) {
        int [][]arr = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15, 18},{16,17}};
        List<List<Integer>> ans = mergeIntervals(arr);
        System.out.print("The merged intervals are: ");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();

        int[][] merged = merge(arr);
        System.out.print("Merged Intervals: ");
        for (int[] interval : merged) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }

    static int[][] merge(int [][]arr){
        // sort the given intervals
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>(); //  List<int[]> --> Each element in the list is an int[] (an array of integers).
        for (int i = 0; i < arr.length; i++) {
            // if the current interval does not lie in the last interval
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1)[1]){
                ans.add(arr[i]);
            }
            // if the current interval does lies in the last interval
            else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size() - 1)[1], arr[i][1]);
            }
        }
        // Converts the List<int[]> to a 2D array int[][]
        return ans.toArray(new int[ans.size()][]);
    }


    static List<List<Integer>> mergeIntervals(int [][]arr){
        // sort the given intervals
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0]; // arr[0][0] element i.e. start is the 1 { current interval's start }
            int end = arr[i][1]; // arr[0][1] element i.e. end is 3 { current interval's end }

            // Skip all the merged intervals if already covered in a previous merge
            if(!list.isEmpty() && end <= list.get(list.size() - 1).get(1)){
                continue;
            }
            // check the rest of the intervals
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j][0] <= end){
                    end = Math.max(end,arr[j][1]);
                }else {
                    break;
                }
            }
            list.add(Arrays.asList(start,end));
        }
        return list;
    }
}

/*
list.get(list.size() - 1).get(1)
list   -->   A List<List<Integer>> — it stores merged intervals like [[1, 3], [4, 8], [10, 12]]
list.size()-1   -->   Index of the last interval
list.get(ans.size()-1)   --> 	Gets the last interval, e.g., [10, 12]
.get(1)   --> 	Gets the second element, i.e., the end of the interval

Arrays.sort(arr, (a, b) -> a[0] - b[0]);
(a, b) -> a[0] - b[0]: This is a lambda expression (short function) used as a comparator.
It compares two intervals a and b based on their starting point a[0] and b[0].
Sorts the intervals in ascending order of start time.
 */
