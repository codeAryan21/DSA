package BitManipulation.LearnBit;

public class SetAndClearIthBit {
    public static void main(String[] args) {
        int n = 13;
        int i = 3;
        System.out.println("After setting the " + i + "th Bit " + n + " is: " + setIthBit(n,i));
        System.out.println("After clearing the " + i + "th Bit " + n + " is: " + clearIthBit(n,i));
        System.out.println("Toggling the " + i + "th Bit: " + toggleBit(n,i));

        if(checkOdd(n)){
            System.out.println(n + " is odd.");
        }else {
            System.out.println(n + " is even.");
        }
    }

    static int setIthBit(int n,int i){
        int ans = n | (1 << i);
        return ans;
    }

    static int clearIthBit(int n,int i){
        int ans = n & ~(1 << i);
        return ans;
    }

    static int toggleBit(int n,int i){
        int ans = n ^ (1 << i);
        return ans;
    }

    static boolean checkOdd(int n){
        if((n & 1) == 1){
            return true;
        }
        return false;
    }
}