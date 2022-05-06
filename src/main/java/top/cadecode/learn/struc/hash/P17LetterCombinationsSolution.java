package top.cadecode.learn.struc.hash;

import java.util.*;

public class P17LetterCombinationsSolution {
    private final Map<Character, List<String>> btnMap = new HashMap<>();

    {
        btnMap.put('2', Arrays.asList("a", "b", "c"));
        btnMap.put('3', Arrays.asList("d", "e", "f"));
        btnMap.put('4', Arrays.asList("g", "h", "i"));
        btnMap.put('5', Arrays.asList("j", "k", "l"));
        btnMap.put('6', Arrays.asList("m", "n", "o"));
        btnMap.put('7', Arrays.asList("p", "q", "r", "s"));
        btnMap.put('8', Arrays.asList("t", "u", "v"));
        btnMap.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            List<String> list = btnMap.get(digits.charAt(i));
            if (i == 0) {
                res = list;
                continue;
            }

            res = combine(res, list);
        }

        return res;
    }

    private List<String> combine(List<String> l1, List<String> l2) {
        List<String> res = new ArrayList<>();
        for (String s1 : l1) {
            for (String s2 : l2) {
                res.add(s1 + s2);
            }
        }
        return res;
    }
}
