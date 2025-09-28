package BitManipulation.Interview;

// https://leetcode.com/problems/single-number-ii/
public class SingleNumber2 {
    public static void main(String[] args) {
        int []arr = {1,2,3,1,2,3,1,2,3,4,5,5,5};
        System.out.println("Single number in the array is: " + singleNumber(arr));
    }

    static int singleNumber(int []arr){
        int ones = 0;
        int twos = 0;
        for (int i=0;i< arr.length;i++){
            // arr[i] will go to ones, if not in twos
            ones = (ones ^ arr[i]) & ~twos;
            // arr[i] will go to twos, if it has appeared twice (i.e., previously in ones)
            twos = (twos ^ arr[i]) & ~ones;
        }
        return ones;
    }
}