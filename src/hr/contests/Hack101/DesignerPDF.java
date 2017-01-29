package hr.contests.Hack101;

import java.util.HashMap;
import java.util.Scanner;

public class DesignerPDF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h[] = new int[26];
        int maxheight = -1;
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        
        String word = in.next();
        char[] letters = word.toCharArray();
        HashMap<Character, Integer> letterIndices = new HashMap<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int i=0; i<alphabet.length; i++){
        	letterIndices.put(alphabet[i], i);
        }
        for(char x: letters){
        	int index = letterIndices.get(x);
        	if(h[index] > maxheight)
        		maxheight = h[index];
        }
        int width = letters.length;
        System.out.println(width * maxheight);
        
    }
}
