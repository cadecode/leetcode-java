package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;

public class P13SolutionTest extends AppTest {

    @Test
    public void romanToInt() {
        int i = new P13Solution().romanToInt("MDCXCV");
        log.info("i: {}", i);
    }
}
