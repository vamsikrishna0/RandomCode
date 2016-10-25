package hr.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vamsi on 10/23/2016.
 */
public class BearAndSteadyGene {
    static int n;
    static HashMap<Character, Integer> frequencies;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String gene = sc.next();
        frequencies = new HashMap<>();
        frequencies.put('A', 0);
        frequencies.put('G', 0);
        frequencies.put('C', 0);
        frequencies.put('T', 0);
        int maxIndex = 0, minLength;

        for (int i = n - 1; i >= 0; i--) {
            char temp = gene.charAt(i);
            frequencies.put(temp, frequencies.get(temp) + 1);
            if (!isValid()) {
                maxIndex = i + 1;
                frequencies.put(temp, frequencies.get(temp) - 1);
                break;
            }
        }

        minLength = maxIndex;
        for (int minIndex = -1; minIndex < n - 1 && minIndex < maxIndex && minIndex < n; minIndex++) {

            while(!isValid() && maxIndex < n){
                frequencies.put(gene.charAt(maxIndex), frequencies.get(gene.charAt(maxIndex)) - 1);
                maxIndex++;
            }
            if(maxIndex > n || !isValid()){
                break;
            }
            int substringLength = Math.max(0, maxIndex - minIndex - 1);
            if(substringLength < minLength){
                minLength = substringLength;
            }
            char temp = gene.charAt(minIndex+1);
            frequencies.put(temp, frequencies.get(temp) + 1);
        }
        System.out.println(minLength);
    }

    private static boolean isValid() {
        return (frequencies.get('A') <= n / 4 && frequencies.get('C') <= n / 4
                && frequencies.get('G') <= n / 4 && frequencies.get('T') <= n / 4);
    }
}

