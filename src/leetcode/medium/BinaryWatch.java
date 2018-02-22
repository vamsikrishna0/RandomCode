package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vamsi on 1/24/2017.
 */
public class BinaryWatch {
    public static void main(String[] args) {
        BinaryWatch x = new BinaryWatch();
        for (String s : x.readBinaryWatch(2)) {
            System.out.println(s);
        }
        HashMap<Integer, Integer> ww = new HashMap<>();
    }

    /*
    * This solution uses bitCount from the Integer class.
    * */
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num > 8 || num < 0)
            return res;
        if (num == 0) {
            res.add("0:00");
            return res;
        }
        int hours = 0;
        while (hours <= 3) {
            int mins = num - hours;
            if (mins >= 0) {
                List<String> hourStrings = getNumWithBits(hours, true);
                List<String> minStrings = getNumWithBits(mins, false);
                for (String hour : hourStrings) {
                    for (String min : minStrings) {
                        res.add(hour + ":" + min);
                    }
                }
            }
            hours++;
        }
        return res;
    }

    //hours maxValue = 11, mins maxValue = 59
    //This method gets the list of possible strings with numOfBitsSet number of bits set. There is also a switch for either mins or hours
    List<String> getNumWithBits(int numOfBitsSet, boolean isHours) {
        List<String> res = new ArrayList<>();
        if (numOfBitsSet < 0)
            return res;
        int n;

        if (isHours) {
            n = 11;
            while (n >= 0) {
                int p = Integer.bitCount(n);
                if (p == numOfBitsSet) {
                    res.add("" + n);
                }
                n--;
            }
        }else{
            n = 59;
            while (n >= 0) {
                int p = Integer.bitCount(n);
                if (p == numOfBitsSet) {
                    if (n < 10) res.add("0" + n);
                    else res.add("" + n);
                }
                n--;
            }
        }
        return res;
    }
    /*
    //The solution using backtracking.

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for (int num1 : list1) {
                if (num1 >= 12) continue;
                for (int num2 : list2) {
                    if (num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    //This is the function that does the backtracking(recursion).
    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }
    */
}
