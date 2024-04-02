package top.cadecode.learn.leetcode.answer;

import java.util.*;

public class P15Solution {

    /**
     * 暴力
     * 可能超时
     */
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, HashSet<Integer>> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(nums[i])) {
                numIndexMap.get(nums[i]).add(i);
            } else {
                HashSet<Integer> indexSet = new HashSet<>();
                indexSet.add(i);
                numIndexMap.put(nums[i], indexSet);
            }
        }
        HashSet<String> cache = new HashSet<>();
        ArrayList<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = -nums[i] - nums[j];
                if (!numIndexMap.containsKey(target)) {
                    continue;
                }
                if (target == nums[i] || target == nums[j]) {
                    HashSet<Integer> indexSet = numIndexMap.get(target);
                    if ((indexSet.contains(i) && indexSet.contains(j) && indexSet.size() == 2)
                            || (indexSet.contains(i) && !indexSet.contains(j) && indexSet.size() == 1)
                            || (!indexSet.contains(i) && indexSet.contains(j) && indexSet.size() == 1)
                    ) {
                        continue;
                    }
                }
                List<Integer> list = Arrays.asList(nums[i], nums[j], target);
                Collections.sort(list);
                String key = list.toString();
                if (cache.contains(key)) {
                    continue;
                }
                resList.add(list);
                cache.add(key);
            }
        }

        return resList;
    }

    /**
     * 双指针
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                if (left > 0 && nums[left] == nums[left - 1]) {
                    continue;
                }
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    continue;
                }
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    continue;
                }
                resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
            }
        }
        return resList;

    }
}
