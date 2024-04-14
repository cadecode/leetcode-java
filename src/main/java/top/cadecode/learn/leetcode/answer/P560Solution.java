package top.cadecode.learn.leetcode.answer;

public class P560Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArr[i] = nums[i - 1] + nums[i];
        }

        for (int i = 0; i < sumArr.length; i++) {

        }
        return 0;

    }
}
