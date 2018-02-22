package interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Vamsi on 12/20/2016.
 */
public class Pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> freq = new HashMap<>();
        char[] chars = str.toLowerCase().toCharArray();
        for (char x : chars) {
            if (x >= 97 && x <= 122)
                freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        if(freq.keySet().size() == 26){
            int num = freq.get('a');
            boolean x = true;
            for(int p : freq.values()){
                if(p != num){
                    x = false;
                    break;
                }
            }
            if(x)
                System.out.println("multiple pangram "+num);
            else
                System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
    }
}
