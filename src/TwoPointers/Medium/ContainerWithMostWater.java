package TwoPointers.Medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int []arr = {1,8,6,2,5,4,8,3,7};
//        int []arr = {1,1};
        System.out.println("The area with the maximum water is: " + maxArea(arr));
    }

    // formula to calculate area is height * width / length * breadth;
    public static int maxArea(int []arr){
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;
        while(left < right){
            int length = Math.min(arr[left], arr[right]);
            int breadth = right - left;
            int area = length * breadth;
            maxArea = Math.max(maxArea, area);

            // we want maxArea that's why we move the left or right pointers according to the which one is lesser
            // because we have to increase the area value so we look for the greater one.
            if(arr[left] < arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
