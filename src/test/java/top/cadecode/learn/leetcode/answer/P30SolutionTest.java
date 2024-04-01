package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;

import java.util.List;

public class P30SolutionTest extends AppTest {

    @Test
    public void test() {
        String[] words = {"bar", "foo", "the"};
        String s = "barfoofoobarthefoobarman";
        List<Integer> substring = new P30Solution().findSubstring(s, words);
        log.info("substring: {}", substring);
    }
}
