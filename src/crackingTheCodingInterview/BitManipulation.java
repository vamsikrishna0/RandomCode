package crackingTheCodingInterview;

/**
 * Created by Vamsi on 1/12/2017.
 */
public class BitManipulation {

    public static void main(String[] args) {
        BitManipulation x = new BitManipulation();
        System.out.println(x.bitDifference(15, 16));
    }
    //5.1: Insert m into n.
    public int insert(int n, int m, int i, int j){
        int k = j-i+1;
        int mask = ~(((1 << (k+1))- 1) << i);
        return (mask & n) | (m << i);
    }

    //5.3: print next smallest and largest num with same 1's
    public void sameOnes(int n){
        int temp = n;
        if(n == Integer.MAX_VALUE)
            System.out.println(n);
        else{
            int x = 0, i=0;
            while(x==0){
                x = (temp & (1 << i));
                i++;
            }
            int j = i-1;
            while(x != 0){
                x = (temp & (1 << i));
                i++;
            }
            i -= 2;

        }
    }

    //5.5: Number of bits required to convert a to b
    int bitDifference(int a, int b){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = (1 << i);
            if(((mask & a)==0) != ((mask & b)==0)){
                res++;
            }
        }
        return res;
    }
}
