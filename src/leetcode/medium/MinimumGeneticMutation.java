package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Vamsi on 1/19/2017.
 */
public class MinimumGeneticMutation {
    public static void main(String[] args) {
        MinimumGeneticMutation x = new MinimumGeneticMutation();
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"};
//        System.out.println(x.minMutation(start, end, bank));
        int p = 4;
//        System.out.println(Integer.toBinaryString(p).length());
        System.out.println(x.findComplement(5));
    }

    static char[] genes = {'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, HashSet<String> bank, HashSet<String> visited) {
        visited.add(start);
        if(start.equals(end)){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int temp;
        String partial = "";

        /*
        * 1) Basic algo is to go through all the possible strings(replacing one of the char with any of the ACGT chars)
        *   with just one mutation from the given string.
        * 2) Check if each such partial string is already visited and also part of bank of legal strings.
        * 3) Only then recurse on that partial string.
        * 4) Recurse through all of them and find the min number of mutations and return min+1
        * 5) Base case is when both start and end are equal, return 0.
         */
        for(int i=0; i<8; i++){
            char[] str = start.toCharArray();
            for (char c: genes) {
                str[i] = c;
                partial = new String(str);
                if(bank.contains(partial) && !visited.contains(partial)){ // Important to check if we have not visited this partial string before
                    temp = minMutation(partial, end, bank, visited);
                    if(temp != -1 && temp < min)
                        min = temp;
                }
            }
        }
        if(min == Integer.MAX_VALUE)
            return -1;
        return min + 1;
    }

    public int minMutation(String start, String end, String[] bank){
        HashSet<String> bankSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        bankSet.addAll(Arrays.asList(bank));
        return minMutation(start, end, bankSet, visited);
    }
    public int hammingDistance(int x, int y) {
        int z = (x ^ y);
        int i = 0;
        int mask = (1 << i);
        int hd = 0;
        while(i < 32){
            if((z & mask) != 0){
                hd++;
            }
            i++;
            mask = (1 << i);
        }
        return hd;
    }
    public int findComplement(int num) {
        /*
        int i = Integer.toBinaryString(num).length();
        System.out.println(i);
        int mask = ~((1<<(i)) -1);
        System.out.println(Integer.toBinaryString(mask));
        num = (num | mask);
        System.out.println(Integer.toBinaryString(num));
        return ~num;
        */

        return ~(num | ~((1<<(Integer.toBinaryString(num).length())) -1));

    }
}
