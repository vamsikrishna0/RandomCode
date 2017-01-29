package leetcode;

public class PalindromeNumber {

    //See if the number is a palindrome
    //O(1) space
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        //Get the number to divide, which provides the last digit
        int mul = 1;
        while (x / mul >= 10) {
            mul *= 10;
        }

        //Checking if the last and first digits are equal repeatedly
        while (x != 0) {
            int first = x / mul;
            int last = x % 10;
            if (first != last)
                return false; //Return if they don’t match immediately

            x = (x % mul) / 10; // removes first and last digits from x. x%mul removes first digit
            mul /= 100;
        }

        return true;
    }
}
