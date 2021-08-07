package cade.struc.hash;

import cade.AppTest;
import org.junit.Test;

public class P2LengthOfLongestSubstringSolutionTest extends AppTest {

    @Test
    public void test() {
        String s = "abcabcbb";
        int i = new P2LengthOfLongestSubstringSolution().lengthOfLongestSubstring(s);
        log.info("i: {}", i);
    }
}
