package codejam2017;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Vamsi on 4/8/2017.
 */
public class BathroomStalls {
    public static void main(String[] args) {
        BathroomStalls x = new BathroomStalls();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            long[] res = x.maxmin(sc.nextLong(), sc.nextLong());
            System.out.println("Case #"+i+": "+res[0]+" "+res[1]);
        }
    }
    long[] maxmin(long n,long k){
        Division res = maxBath(n,k);
        long[] result = new long[2];
        long min = (res.i + res.j)/2;
        if(min-res.i > res.j- min){
            result[1] = res.j- min;
            result[0] = min-res.i;
        }else{
            result[0] = res.j- min;
            result[1] = min-res.i;
        }
        return result;
    }
    Division maxBath(long n, long k){
        DivisionComparator comparator = new DivisionComparator();
        PriorityQueue<Division> divisionsHeap = new PriorityQueue<>(5, comparator);
        Division initial = new Division(0, n-1);

        divisionsHeap.add(initial);

        while(k > 1){
            Division div = divisionsHeap.poll();

            long mid = (div.i + div.j)/2;
            //Create left div
            if(div.i <= mid-1) {
                Division left = new Division(div.i, mid-1);
                divisionsHeap.add(left);
            }

            if(mid+1 <= div.j){
                Division right = new Division(mid+1, div.j);
                divisionsHeap.add(right);
            }
            k--;
        }
        return divisionsHeap.peek();

    }
    private class DivisionComparator implements Comparator<Division>{

        @Override
        public int compare(Division p, Division q) {
            long diffp = p.j - p.i;
            long diffq = q.j - q.i;
            if(diffp < diffq)
                return 1;
            else if (diffp > diffq)
                return -1;
            else{
                if(p.i > q.i)
                    return 1;
                else
                    return -1;
            }
        }
    }
    private class Division{
        long i;
        long j;
        public Division(long i, long j) {
            this.i = i;
            this.j = j;
        }
    }
}
