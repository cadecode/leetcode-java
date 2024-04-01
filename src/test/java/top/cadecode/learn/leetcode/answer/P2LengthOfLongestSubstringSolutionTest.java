package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;
import top.cadecode.learn.leetcode.answer.P2LengthOfLongestSubstringSolution;

public class P2LengthOfLongestSubstringSolutionTest extends AppTest {

    @Test
    public void test() {
        String s = "abcabcbb";
        int i = new P2LengthOfLongestSubstringSolution().lengthOfLongestSubstring(s);
        log.info("i: {}", i);
    }
}
