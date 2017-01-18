package interview.google;

import java.util.Stack;

/**
 * Created by Vamsi on 12/27/2016.
 */
public class LargestAbsoluteDirectoryPath {
    public static void main(String[] args) {
        LargestAbsoluteDirectoryPath x = new LargestAbsoluteDirectoryPath();
        String str = "dir1\n blah.txt\n blah2.png\n dir\n  dir4\n   fuck.jpeg\n blah.png\n dir2\n  b.txt\ndir3";
        System.out.println(x.lengthLongestPath(str));
//        String blah = "  bhjds";
//        System.out.println(blah.trim());
//        System.out.println(blah.charAt(0) == ' ');
        /*
        The input in display format
dir1
 blah.txt
 blah2.png
 dir
  dir4
   fuck.jpeg
 blah.png
 dir2
  b.txt
dir3
*/
    }

    public int lengthLongestPath(String S) {
        // write your code in Java SE 8
        String[] files = S.split("\n");
        int len = files.length;
        int i = 0, numberOfSpaces = 0;
        int lengthOfLargestPath = 0, lengthOfCurrentPath = 0;
        Stack<String> stackOfDirs = new Stack<>();

        while (i < len) {
            String fileName = files[i];
//            System.out.println(fileName);
            String name = fileName.trim();
            int currentIndentation = countLeadingSpaces(fileName);

            if (currentIndentation < numberOfSpaces) {
                int diff = numberOfSpaces - currentIndentation;
                for (int j = 0; j < diff; j++) {
                    String lastDir = stackOfDirs.pop();
                    lengthOfCurrentPath -= lastDir.length() - 1;
                }
                numberOfSpaces = currentIndentation;
            } else if (currentIndentation > numberOfSpaces) {
                numberOfSpaces = currentIndentation;
            }

            if (isDirectory(fileName)) {
                stackOfDirs.push(name);
                lengthOfCurrentPath += name.length() + 1;
            } else {
                if (isImageFile(name)) {
                    if (lengthOfCurrentPath > lengthOfLargestPath) {
                        lengthOfLargestPath = lengthOfCurrentPath;
                    }
                }
            }
            i++;
        }

        return lengthOfLargestPath;
    }

    boolean isDirectory(String filename) {
        return (!filename.contains("."));
    }

    boolean isImageFile(String filename) {
        if (filename.substring(filename.length() - 5).equals(".jpeg") || filename.substring(filename.length() - 4).equals(".png") ||
                filename.substring(filename.length() - 4).equals(".gif"))
            return true;
        else
            return false;
    }

    //Given a file name with leading spaces, return the count of them
    int countLeadingSpaces(String file) {
        int j = 0;
        for (int i = 0; i < file.length(); i++) {
            if (file.charAt(i) == ' ')
                j++;
            else
                return j;
        }
        return j;
    }

}
