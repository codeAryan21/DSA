package Math.Advance;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 30;
        System.out.println("The total prime number between 2 to " + n + " is: " + countPrimes(n));
    }

    static int countPrimes(int n){
        if(n <= 2) return 0;
        int []prime = new int[n+1];
        for (int i = 2; i <= n; i++) {
            prime[i] = 1;
        }

        for (int i = 2; i*i <= n; i++) {
            if(prime[i] == 1){
                for (int j = i*i; j <= n; j=j+i) {
                    prime[j] = 0;
                }
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(prime[i] == 1){
                count++;
            }
        }
        return count;
    }
}
