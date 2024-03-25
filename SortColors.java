public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            int l = 0; // left pointer
            int r = nums.length - 1; // right pointer
            int i = 0; // iterating pointer

            while (i <= r) {
                if (nums[i] == 0) {
                    swap(nums, i, l);
                    i++;
                    l++;
                } else if (nums[i] == 1) {
                    i++;
                } else if (nums[i] == 2) {
                    swap(nums, i, r);
                    r--;
                } else {
                    System.out.println("Error");
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public static void main(String[] args) {

    }
}
