package top.cadecode.learn.leetcode.answer;

import java.util.HashMap;
import java.util.Map;

public class P560Solution {
    /*
    前缀和 preSum[i] i 前面的数相加
    [i, ..., j] 的和 = preSum[j] - preSum[i-1]
    存在 preSum[i - 1] 为 preSum[j] - k，则次数加一
     */
    public int subarraySum(int[] nums, int k) {
        int resCount = 0;
        int sum = 0;
        // 前缀和和前缀和出现的次数
        Map<Integer, Integer> preSumCountMap = new HashMap<>();

        // 临界条件，0 位置的前缀和为 0
        preSumCountMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 判断是否命中
            int targetSum = sum - k;
            if (preSumCountMap.containsKey(targetSum)) {
                resCount += preSumCountMap.get(targetSum);
            }
            // 记录前缀和
            if (preSumCountMap.containsKey(sum)) {
                preSumCountMap.put(sum, preSumCountMap.get(sum) + 1);
            } else {
                preSumCountMap.put(sum, 1);
            }
        }


        return resCount;

    }
}
