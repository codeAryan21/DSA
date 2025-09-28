package Array.Medium;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=problem-list-v2&envId=array
public class StocksBuySell {
    public static void main(String[] args) {
        int []arr = {4,6,3,9,1,2,5,6};
        System.out.println("The maximum profit is : " + maxProfit(arr));
    }

    static int maxProfit(int []arr){
        int maxprofit = 0; // initially the profit is set to 0
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice,arr[i]); // the minPrice is the minimum of the current element where i is and the minPrice
            int profit = arr[i] - minPrice; // the profit is difference between sell price and the minPrice when it was bought
            maxprofit = Math.max(maxprofit,profit); // the profit is the maximum of profit and maxprofit
        }
        return maxprofit;
    }
}
