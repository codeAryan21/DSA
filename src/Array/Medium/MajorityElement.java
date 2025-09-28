package Array.Medium;

// https://leetcode.com/problems/majority-element/description/?envType=problem-list-v2&envId=array
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        System.out.println("The majority element in the array is : " + findMajorityElement(arr));
    }

    static int findMajorityElement(int []arr){
        int element = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (counter == 0){
                counter = 1;
                element = arr[i];
            } else if (element == arr[i]) { // the element == the array of current element then counter++
                counter++;
            }else {
                counter--;
            }
        }
        // checking if the stored element is the majority element:
        int cntr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element){
                cntr++;
            }
        }
        if(cntr > (arr.length/2)){
            return element;
        }
        return -1;
    }
}

/*
Moore's voting algorithm
verify if the element we got is the majority or not
 */