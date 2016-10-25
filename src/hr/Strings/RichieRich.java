package hr.Strings;

import java.util.Scanner;

/**
 * Created by Vamsi on 10/23/2016.
 */
public class RichieRich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String number = sc.next();

        //Convert to charArray as a lot of string manipulation is required with individual chars
        char[] chars = number.toCharArray();

        //Find number of differences from the being a palindrome.
        int numOfDiffs = 0;
        for (int i = 0; i <= (n-1) / 2; i++) {
            if (chars[i] != chars[n - i - 1]) {
                numOfDiffs++;
            }
        }

        if (numOfDiffs > k)
            System.out.println(-1);
        else {
            //Convert to palindrome
            for (int i = 0; i <= (n-1) / 2; i++) {
                if (chars[i] < chars[n - i - 1]) {
                    chars[i] = chars[n - i - 1];
                } else if (chars[i] > chars[n - i - 1]) {
                    chars[n - i - 1] = chars[i];
                }
            }

            int toNines = k - numOfDiffs;
//            System.out.println(toNines + " toNines");
            int j = 0;
            //Get the max palindrome by switching to 9s as much as possible.
            while (toNines > 0 && j <= (n-1) / 2) {
                if (number.charAt(j) != '9' && number.charAt(n - j - 1) != '9') {
//                    System.out.println("not 9s");
                    if (number.charAt(j) != number.charAt(n - j - 1)) {
//                        System.out.println("both eqaual and not 9s");
                        chars[j] = chars[n - j - 1] = '9';
                        toNines--;
                    } else {
//                        System.out.println("came in");
                        if (toNines > 1) {
                            chars[j] = chars[n - j - 1] = '9';
                            toNines -= 2;
                        }
                        if (n % 2 != 0 && j == (n-1)/2){
                            chars[j] = chars[n - j - 1] = '9';
                            toNines--;
                        }
                    }
                }
                j++;
            }
            System.out.println(new String(chars));
        }
    }
}
