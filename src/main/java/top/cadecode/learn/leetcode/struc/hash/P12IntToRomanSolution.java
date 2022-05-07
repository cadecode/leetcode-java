package top.cadecode.learn.leetcode.struc.hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class P12IntToRomanSolution {

    // 存入罗马数字对应关系
    Map<Integer, String> rmMap = new LinkedHashMap<>();

    {
        rmMap.put(1000, "M");
        rmMap.put(900, "CM");
        rmMap.put(500, "D");
        rmMap.put(400, "CD");
        rmMap.put(100, "C");
        rmMap.put(90, "XC");
        rmMap.put(50, "L");
        rmMap.put(40, "XL");
        rmMap.put(10, "X");
        rmMap.put(9, "IX");
        rmMap.put(5, "V");
        rmMap.put(4, "IV");
        rmMap.put(1, "I");
    }

    public String intToRoman(int num) {

        String rm = "";
        // 遍历 LinkedHashMap，数字有大到小
        for (Map.Entry<Integer, String> entry : rmMap.entrySet()) {
            Integer k = entry.getKey();
            String v = entry.getValue();
            // 添加一个符号，就减去对应的数值
            while (num >= k) {
                rm += v;
                num -= k;
            }
        }
        return rm;
    }
}
