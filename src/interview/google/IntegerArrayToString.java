package interview.google;

/**
 * Created by Vamsi on 1/20/2017.
 */
public class IntegerArrayToString {
    public static void main(String[] args) {
        IntegerArrayToString x = new IntegerArrayToString();
        int[] p = {1,2,4,5,6,7,9};
        int[] z = {};
        System.out.println(x.intToString(z));
    }
    String intToString(int[] arr){
        StringBuilder res = new StringBuilder();
        if(arr == null || arr.length ==0)
            return res.toString();
        int len = arr.length;
        res.append(arr[0]);
        boolean cont = false;
        for (int i = 1; i < len; i++) {
            if(!(arr[i] == arr[i-1] + 1)){
                if(cont)
                    res.append("-").append(arr[i - 1]);
                res.append(",").append(arr[i]);
                cont = false;
            }else
                cont = true;
        }
        if(cont)
            res.append("-").append(arr[len - 1]);
        return res.toString();
    }
}
