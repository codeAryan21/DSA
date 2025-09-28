package BitManipulation.LearnBit;

public class IthBitIsSetOrNot {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        System.out.println("By left shift: " + isBitSet1(n,i));
        System.out.println("By right shift: " + isBitSet2(n,i));
    }

    // left shift
    static boolean isBitSet1(int n,int i){
        if((n & (1 << i)) != 0){
            return true;
        }
        return false;
    }

    // right shift
    static boolean isBitSet2(int n,int i){
        if(((n >> i) & 1) == 1){
            return true;
        }
        return false;
    }
}
