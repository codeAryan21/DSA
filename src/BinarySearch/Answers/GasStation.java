package BinarySearch.Answers;

public class GasStation {
    public static void main(String[] args) {
        int []arr = {1,13,17,23};
        System.out.println("The answer is: " + minimiseMaxDistance(arr,5));
    }

    static int numberOfGasStationsRequired(int []arr,double distance){
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / distance);
            if ((arr[i] - arr[i - 1]) == (distance * numberInBetween)) {
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }

    static double minimiseMaxDistance(int []arr,int k){
        double low = 0;
        double high = 0;
        //Find the maximum distance:
        for (int i = 0; i < arr.length-1; i++) {
            high = Math.max(high, (double) (arr[i+1] - arr[i]));
        }

        double diff = 1e-6 ;
        while((high-low) > diff){
            double mid = low + (high - low) / 2;
            int count = numberOfGasStationsRequired(arr,mid);
            if (count > k){
                low = mid;
            }else {
                high = mid;
            }
        }
        return high;
    }
}
