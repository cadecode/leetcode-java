package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;

public class P2SolutionTest extends AppTest {

    @Test
    public void test() {
        String s = "abcabcbb";
        int i = new P2Solution().lengthOfLongestSubstring(s);
        log.info("i: {}", i);
    }
}
