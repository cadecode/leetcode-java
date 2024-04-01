package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;
import top.cadecode.learn.leetcode.answer.P13RomanToIntSolution;

public class P13RomanToIntSolutionTest extends AppTest {

    @Test
    public void romanToInt() {
        int i = new P13RomanToIntSolution().romanToInt("MDCXCV");
        log.info("i: {}", i);
    }
}
