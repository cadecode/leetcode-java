package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;

public class P12SolutionTest extends AppTest {

    @Test
    public void test() {
        String s = new P12Solution().intToRoman(1101);
        log.info("s: {}", s);
    }
}
