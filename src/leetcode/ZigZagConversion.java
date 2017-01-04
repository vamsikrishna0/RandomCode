package leetcode;

/**
 * Created by Vamsi on 12/29/2016.
 */
public class ZigZagConversion {
    //Convert a string to a zig-zag pattern and return that string row wise
    public static void main(String[] args) {
        ZigZagConversion x = new ZigZagConversion();
        System.out.println(x.convert("ABCDEF", 3));
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        int n = 2 * (numRows - 1);
        int p;
        int offset1, offset2;
        StringBuilder builder = new StringBuilder();
        if(numRows == 1)
            return s;

        for (int i = 0; i < numRows; i++) {
            p = i;
            offset1 = 2 * (numRows - 1 - i);
            offset2 = 2 * (i);

            System.out.println(offset1 +""+ offset2);
            if (i == 0 || i == numRows - 1) {
                while (p < len) {
                    builder.append(s.charAt(p));
                    p += n;
                }
            } else {
                while (p < len) {
                    builder.append(s.charAt(p));
                    p += offset1;
                    if (p < len)
                        builder.append(s.charAt(p));
                    p += offset2;
                }
            }
        }

        return builder.toString();
    }
}
