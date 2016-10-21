package hr.Strings;

import java.util.Scanner;

public class SimilarStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String s = in.next();
        while (n > 0) {
            int li = in.nextInt();
            int ri = in.nextInt();
            int lenSub = ri - li + 1;
            int lastSub = n - lenSub;


            n--;
        }
    }
}
