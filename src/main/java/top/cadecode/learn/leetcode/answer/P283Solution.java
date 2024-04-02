package top.cadecode.learn.leetcode.answer;

public class P283Solution {

    /**
     * 冒泡排序
     */
    public void moveZeroesByBubble(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0 && nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public void moveZeroesByInsert(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j - 1] == 0 && nums[j] != 0) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 双指针，都从 0 开始
     * left 维护 0 区域的位置
     * right 负责遍历
     * left 开始时可能与 right 相等，遇到 0 后，和 right 之间相差着 0 区域
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                if (nums[left] == 0) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
            }
            right++;
        }
    }
}
