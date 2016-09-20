package hr.Strings;

import java.util.Scanner;

public class SuperReducedString {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String p = sc.nextLine();
    	
    	StringBuilder string = new StringBuilder(p);
    	
    	int i=0;
    	while(i< string.length()-1){
    		if(string.charAt(i) == string.charAt(i+1)){
    			string.delete(i, i+2);
    			i=0;
    			continue;
    		}
    		i++;
    	}
    	
    	if(string.length() == 0)
    		System.out.println("Empty String");
    	else
    		System.out.println(string);
    	sc.close();
        
    }

}
