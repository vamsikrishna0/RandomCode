package leetcode;

public class MedianOfTwoSortedArrays {
    //Given two sorted arrays, find the median of elements in both arrays
    public static void main(String[] args) {
//        System.out.println(4/2+1);
        MedianOfTwoSortedArrays x = new MedianOfTwoSortedArrays();
        int[] a = {1,2};
        int[] b = {1,1};
        System.out.println(x.findMedianSortedArrays(a, b));


    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //Combining them to find the median
        /*int sum = sumOfLen;
        while(sumOfLen > 0){
            if(i < len1 && j < len2){
                if (nums1[i] < nums2[j]) {
                    combinedArray[sum-sumOfLen] = nums1[i];
                    i++;
                }else{
                    combinedArray[sum-sumOfLen] = nums2[j];
                    j++;
                }
            }else if (i >= len1){
                combinedArray[sum-sumOfLen] = nums2[j];
                j++;
            }else if (j >= len2){
                combinedArray[sum-sumOfLen] = nums1[i];
                i++;
            }

            sumOfLen--;
        }

        if (sum % 2 == 0) {
            return (combinedArray[sum/2] + combinedArray[sum/2 -1]) / 2.0;
        }else{
            return combinedArray[sum/2];
        }*/

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] combinedArray = new int[len1+len2];

        int i = 0, j=0;

        int sumOfLen = len1 + len2;
        int mid = 0;

        if (sumOfLen % 2 == 0) {
            mid = (sumOfLen / 2) - 1;
        } else {
            mid = sumOfLen / 2;
        }

        for (;mid > 0; mid--) {
            if(i < len1 && j < len2){
                if (nums1[i] < nums2[j]) {
                    i++;
                }else{
                    j++;
                }

                if(mid == 0){
                    if (sumOfLen % 2 == 0) {
                        return (nums2[j + 1] + nums2[j]) / 2.0;
                    }else {
                        return Math.min(nums2[j], nums1[i]);
                    }
                }
            }else if (i >= len1){
                j++;
                if(mid == 0){
                    if (sumOfLen % 2 == 0) {
                        return (nums2[j + 1] + nums2[j]) / 2.0;
                    }else return (nums2[j]);
                }
            }else if (j >= len2){
                i++;
                if(mid == 0){
                    if (sumOfLen % 2 == 0) {
                        return (nums1[i + 1] + nums1[i]) / 2.0;
                    }else return (nums1[i]);
                }
            }
        }


        if (sumOfLen % 2 == 0) {
            if (i >= len1){

                return (nums2[j + 1] + nums2[j]) / 2.0;
            }

            else if (j >= len2){

                return (nums1[i + 1] + nums1[i]) / 2.0;
            }

            else{
                return (nums1[i] + nums2[j]) / 2.0;
            }

        } else {
            if (i >= len1)
                return (nums2[j]);
            else if (j >= len2)
                return (nums1[i]);
            else
                return Math.min(nums1[i], nums2[j]);
        }
    }
}
