//
//    URL: https://leetcode.com/problems/sort-an-array
//    Given an array of integers nums, sort the array in ascending order and return it.
//    You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
//    Example 1:
//    Input: nums = [5,2,3,1]
//    Output: [1,2,3,5]
//    Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
//    Example 2:
//    Input: nums = [5,1,1,2,0,0]
//    Output: [0,0,1,1,2,5]
//    Explanation: Note that the values of nums are not necessairly unique.

public class SortArray {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        mergeSort(nums, 0, n - 1, temp);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    public void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
    }
}
