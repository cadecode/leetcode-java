package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;
import top.cadecode.learn.leetcode.answer.P12IntToRomanSolution;

public class P12IntToRomanSolutionTest extends AppTest {

    @Test
    public void test() {
        String s = new P12IntToRomanSolution().intToRoman(1101);
        log.info("s: {}", s);
    }
}
