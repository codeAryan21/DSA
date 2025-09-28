package BinarySearch.Answers;

public class PaintersPartition {
    public static void main(String[] args) {
        int []arr = {10,20,30,40};
        System.out.println("The answer is: " + findLargestMinDistance(arr,2));
    }

    static int countPainters(int []boards,int time){
        int painters = 1;
        int boardsPainter = 0;
        for (int i = 0; i < boards.length; i++) {
            if(boardsPainter + boards[i] <= time){
                // allocate board to current painter
                boardsPainter += boards[i];
            }else {
                // allocate board to next painter
                painters++;
                boardsPainter = boards[i];
            }
        }
        return painters;
    }

    static int findLargestMinDistance(int []arr,int k){
        if(k > arr.length){
            return -1;
        }
        int low = arr[0];
        int high = 0;
        // find low and high or maximum and summation
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low,arr[i]);
            high += arr[i];
        }

        while (low <= high){
            int mid = low + (high - low) / 2;
            int painters = countPainters(arr,mid);
            if (painters <= k){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
