package leetcode.HashTable;

/**
 * Created by Vamsi on 6/3/2017.
 */
public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes x = new CountPrimes();
        System.out.println(x.countPrimes(10));
    }
    public int countPrimes(int n) {
        if(n > 2){
        boolean[] isNotPrime = new boolean[n];
        isNotPrime[1] = isNotPrime[0]= true;
        int z = (int)Math.ceil(Math.sqrt(n)) + 1;
        for (int i = 2; i <= z; i++) {
            if(i < n && !isNotPrime[i]){
                int mul = 2;
                int p = i* 2;
                while(p < n){
                    isNotPrime[p] = true;
                    p = i * ++mul;
                }
            }
        }
        int res = 0;
        for (boolean b: isNotPrime) {
            if(!b)
                res++;
        }
        return res;
        }else
            return 0;
    }

    //Succinct with running time
    public int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
