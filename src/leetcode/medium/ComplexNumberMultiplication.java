package leetcode.medium;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        String[] aSub = a.split("\\+");
        String[] bSub = b.split("\\+");
        int aReal = Integer.parseInt(aSub[0]);
        int bReal = Integer.parseInt(bSub[0]);
        int aImg = Integer.parseInt(aSub[1].substring(0, aSub[1].length() -1));
        int bImg = Integer.parseInt(bSub[1].substring(0, bSub[1].length() -1));
        StringBuilder ansReal = new StringBuilder();
        ansReal.append(aReal * bReal - (aImg * bImg))
                .append("+")
                .append(aReal * bImg + (aImg * bReal))
                .append("i");
        return ansReal.toString();
    }
}
