package hr.Strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MarsExploration {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int len = S.length();
        int count = 0;
        Set<Integer> indicesWithO = new HashSet<>();
        for(int i=1; i<len; i += 3){
        	indicesWithO.add(i);
        	if(S.charAt(i) != 'O'){
        		count++;
        	}
        }
        for(int i=0; i<len; i++){
        	if(S.charAt(i) != 'S' && !indicesWithO.contains(i)){
        		count++;
        	}
        }
        System.out.println(count);
    }
}
