package crackingTheCodingInterview;

/**
 * Created by Vamsi on 1/8/2017.
 */
public class StringWithUniqueChars {

    //Using a boolean array for the set of possible chars. Constant space proportional to length of charset
    boolean isUnique(String str){
        int len = str.length();
        if(len > 256)
            return false;

        boolean[] chars = new boolean[256];

        for(int i=0; i< len; i++){
            int val = str.charAt(i);
            if(chars[val])
                return false;
            chars[val] = true;
        }
        return true;
    }

    //Using a int as bit array. Little typical coz its language dependent
    //Java ints are 32 bit variables and using one int as an array of bits makes this method possible
    //Each char is a 16bit variable and can be set to another int.
    //(1 << val), is a common expression to set a single 1 and remaining 0's, at position of val from the end
    boolean isUniqueBitSet(String str){
        int len = str.length();
        if(len > 256)
            return false;
        //bitSet is the int representation of bits representing each char. We update it accordingly
        int bitSet = 0;

        for(int i=0; i< len; i++){
            //Starting form 'a', we check each character and assign a value(val) starting from 0;
            int val = str.charAt(i) - 'a';

            //1 << val, creates a 1 after val bits. One way to represent a char as a bit
            if((bitSet & (1 << val)) > 0)
                return false;

            //If its not already present in the chars seen so far, set the bit in bitset
            bitSet |= (1 << val);
        }
        return true;
    }
}
