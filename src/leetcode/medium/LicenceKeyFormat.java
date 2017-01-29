package leetcode.medium;

/**
 * Created by Vamsi on 1/19/2017.
 */
public class LicenceKeyFormat {
    public static void main(String[] args) {
        char c = Character.toUpperCase('0');
        System.out.println("2-4A0r7-4k".toUpperCase());
        StringBuffer x = new StringBuffer();

    }

    public String licenseKeyFormatting(String S, int K) {
        int len = S.length();
        if (len < K){
            S = S.replaceAll("-", "");
            char[] c = {'a', 'b'};
            String b = new String(c);
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (count % K == 0 && count != 0) {
                    sb.append('-');
                }
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }
        return sb.reverse().toString();
    }
}
