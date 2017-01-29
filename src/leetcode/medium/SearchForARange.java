package leetcode.medium;

/**
 * Created by Vamsi on 1/28/2017.
 */
public class SearchForARange {
    //34. Search for a range
    public static void main(String[] args) {
        SearchForARange x = new SearchForARange();
        int[] nums = {5, 7, 7, 8, 8, 8,8,8,8,8,8,8,8,8,8,8,8,8, 10};
        int[] c = x.searchRange(nums, 8);
        System.out.println(c[0] +" "+c[1]);
    }

    // 2 binary searches, one for leftmost and one for rightmost
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0)
            return res;
        int i = 0, j = nums.length - 1, mid;
        //Find left most
        while(i <= j){
            mid = (i + j)/2;
            if(nums[mid] == target){
                if(mid - 1 >=0 && nums[mid - 1] == target)
                    j = mid -1;
                else{
                    res[0] = mid;
                    break;
                }
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }

        //Right most
        i = 0;
        j = nums.length - 1;
        while(i <= j){
            mid = (i + j)/2;
            if(nums[mid] == target){
                if(mid + 1 <= nums.length - 1 && nums[mid + 1] == target)
                    i = mid + 1;
                else{
                    res[1] = mid;
                    break;
                }
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return res;
    }


}
