package codejam2017;

import java.util.Scanner;

/**
 * Created by Vamsi on 4/8/2017.
 */
public class TidyNumbers {
    public static void main(String[] args) {
        TidyNumbers x = new TidyNumbers();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            long p = sc.nextLong();
            System.out.println("Case #"+ (i+1)+": "+x.maxTidyNum(p));
        }

    }
    public long maxTidyNum(long n){
        for (long i = n; i > 0; i--) {
            String str = Long.toString(i);
            if(isTidy(str)){
                return i;
            }
        }
        return 0;
    }
    public boolean isTidy(String n){
        char[] nums = n.toCharArray();
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1])
                return false;
        }
        return true;
    }
}
