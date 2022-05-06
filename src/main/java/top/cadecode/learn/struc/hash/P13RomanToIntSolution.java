package top.cadecode.learn.struc.hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class P13RomanToIntSolution {

    // 存入罗马数字对应关系
    Map<String, Integer> rmMap = new LinkedHashMap<>();

    {
        rmMap.put("M", 1000);
        rmMap.put("CM", 900);
        rmMap.put("D", 500);
        rmMap.put("CD", 400);
        rmMap.put("C", 100);
        rmMap.put("XC", 90);
        rmMap.put("L", 50);
        rmMap.put("XL", 40);
        rmMap.put("X", 10);
        rmMap.put("IX", 9);
        rmMap.put("V", 5);
        rmMap.put("IV", 4);
        rmMap.put("I", 1);
    }

    public int romanToInt(String s) {
        // 判断是否匹配 map
        if (s.length() <= 2 && rmMap.get(s) != null) {
            return rmMap.get(s);
        }
        // 不匹配 map，且为两位，则两位分开
        if (s.length() == 2) {
            return rmMap.get(s.charAt(0) + "") + rmMap.get(s.charAt(1) + "");
        }
        int ans = 0;
        // 遍历进行匹配
        for (int i = 0; i < s.length() - 1; i++) {
            String rm = s.charAt(i) + "" + s.charAt(i + 1);
            if (rmMap.get(rm) != null) {
                ans += rmMap.get(rm);
                // 边界处理，当遍历到倒数第三位，且与倒数第二位一体
                if (i == s.length() - 3) {
                    ans += rmMap.get(s.charAt(i + 2) + "");
                    break;
                } else {
                    i++;
                }
                continue;
            }
            ans += rmMap.get(s.charAt(i) + "");
            // 边界处理，当遍历到倒数第二位
            if (i == s.length() - 2) {
                ans += rmMap.get(s.charAt(i + 1) + "");
            }
        }
        return ans;
    }
}
