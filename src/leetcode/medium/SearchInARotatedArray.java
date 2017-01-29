package leetcode.medium;

/**
 * Created by Vamsi on 1/27/2017.
 */
public class SearchInARotatedArray {
    public static void main(String[] args) {
        SearchInARotatedArray x = new SearchInARotatedArray();
        int[] nums = {7, 8, 9, 3, 4, 5};
        System.out.println(x.search(nums, 3));
    }

    //Approach1:
    // 2 passes through the array. First finds the max element or the pivot.
    // Second pass is just bsearch.
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        //Find index of pivot
        int p = nums[0];
        int pivot = getPivot(nums);
        if (target >= p && target <= nums[pivot]) {
            return bSearch(nums, target, 0, pivot);
        } else {
            return bSearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    int getPivot(int[] nums) {
        int pivot = -1;
        int len = nums.length;
        int i = 0, j = nums.length - 1, mid;
        int p = nums[0];
        while (i <= j) {
            mid = (i + j) / 2;
            if (i == j) {
                pivot = mid;
                break;
            }
            if (mid + 1 <= len - 1 && nums[mid] > nums[mid + 1]) {
                pivot = mid;
                break;
            } else if (nums[mid] < p) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return pivot;
    }

    int bSearch(int[] nums, int target, int i, int j) {
        int res = -1, mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }

    //Approach 2:
    //Modified Bsearch. Only one pass through the array
    public int search2(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }
}
