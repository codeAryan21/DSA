package BitManipulation.LearnBit;

public class RemoveLastSetBit {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(removeLastSetBit(n));
    }

    static int removeLastSetBit(int n){
        int ans = n & (n-1);
        return ans;
    }
}

/*
static int setRightmostUnsetBit(int n) {
    if (n == ~0) return n; // all bits are already set (special case)
    return n | (n + 1);
}
 */