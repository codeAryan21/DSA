package Array.Hard;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int []arr = {3, 1, 2, 5, 4, 6, 7, 5};
        int []ans = findMissingAndRepeating(arr);
        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
    }

    static int[] findMissingAndRepeating(int []arr){
        long n = arr.length;
        // find sum and squareSum
        long sum = (n*(n+1))/2;
        long squareSum = (n*(n+1)*(2*n+1))/6;

        // Calculate S and S2
        long S = 0, S2 = 0;
        for (int i = 0; i < arr.length; i++) {
            S += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }
        // S-sum = X-Y
        long val1 = S - sum; // --> X-Y = val1
        // S2-squareSum = X^2-Y^2
        long val2 = S2 - squareSum; // --> X+Y = val2

        // Find X+Y = (X^2-Y^2)/(X-Y)
        val2 = val2 / val1;

        // Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val2 + val1) / 2;
        long y = x - val1;

        int []ans = {(int)x, (int)y};
        return ans;
    }
}

/*
X --> repeating number , Y --> missing number
1- we find the sum of n numbers by --> (n*(n+1))/2;
2- we find the sum of whole array by --> sum += arr[i];
3 - If we subtract (2 - 1) we get a equation (X - Y)
(x-y) = val1;

4- we find the sum of squares of n numbers by --> (n*(n+1)*(2*n+1))/6;
5- we find the sum of square of whole array by --> squareSum += arr[i] * arr[i];
6 - If we subtract (2 - 1) we get a equation (X + Y)
(x^2 - y^2) = val2;
(x-y)*(x+y) = val2;
(x+y) = val2 / (x-y); OR val2 / val1;

7- we solve both the equations 3 & 6 we get out final answer.
x - y = val1
x + y = val2
x = (val1 + val2) / 2;
after getting the value of x we find the value of y
y = x - val1
 */
