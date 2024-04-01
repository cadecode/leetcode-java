package top.cadecode.learn.leetcode.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P49Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 字符排序，作为 map key，分组
        Map<String, List<String>> charGroupMap = Arrays.stream(strs).parallel()
                .collect(Collectors.groupingBy(o -> {
                    char[] chars = o.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }, Collectors.toList()));
        return new ArrayList<>(charGroupMap.values());
    }
}
