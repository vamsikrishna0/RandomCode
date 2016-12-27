import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution x = new Solution();
        String str = "dir1\n blah.txt\n blah2.png";
        System.out.println(x.solution(str));
    }

    public int solution(String S) {
        // write your code in Java SE 8
        int len = S.length();
        int i = 0;
        while (i < len) {
            int index = S.indexOf("\n");
            String fileName = S.substring(i, index);
        }

        return 0;
    }

    boolean checkIfImageFile(String filename) {
        if (filename.substring(filename.length() - 5).equals(".jpeg") || filename.substring(filename.length() - 4).equals(".png") ||
                filename.substring(filename.length() - 4).equals(".gif"))
            return true;
        else
            return false;
    }

    private class Directory {
        int nameLength;
        String name;
        ArrayList<String> files;

        public Directory(String name) {
            this.name = name;
            this.files = new ArrayList<>();
            this.nameLength = name.length();
        }

        void addFile(String file) {
            files.add(file);
        }
    }
}
