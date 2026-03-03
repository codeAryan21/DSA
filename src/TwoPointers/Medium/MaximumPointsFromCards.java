package TwoPointers.Medium;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class MaximumPointsFromCards {
    public static void main(String[] args) {
        int []arr = {6,2,3,4,7,2,1,7,1};
        int k = 4;
        System.out.println("The maximum points we obtain from the cards is: " + maxScore(arr,k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0, maxSum = 0; // first we initialize the leftSum, rightSum & maxSum with 0;
        for(int i=0;i<k;i++){
            lSum = lSum + cardPoints[i]; // calculate the sum of first k elements
            maxSum = lSum; // store this as a maxSum
        }

        // from here we remove one element from the left and take that one element from right and do this until left become 0
        int rightIdx = cardPoints.length - 1;
        for(int i=k-1;i>=0;i--){
            lSum = lSum - cardPoints[i]; // removed one element from left
            rSum = rSum + cardPoints[rightIdx]; // added one element from right
            rightIdx--;
            maxSum = Math.max(maxSum, lSum + rSum); // calculate the maxSum
        }
        return maxSum;
    }
}
