package top.cadecode.learn.leetcode.struc.hash;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;

import java.util.List;

public class P30FindSubstringSolutionTest extends AppTest {

    @Test
    public void test() {
        String[] words = {"bar", "foo", "the"};
        String s = "barfoofoobarthefoobarman";
        List<Integer> substring = new P30FindSubstringSolution().findSubstring(s, words);
        log.info("substring: {}", substring);
    }
}
