package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;
import top.cadecode.learn.leetcode.answer.P17LetterCombinationsSolution;

import java.util.List;

public class P17LetterCombinationsSolutionTest extends AppTest {
    @Test
    public void test() {
        List<String> list = new P17LetterCombinationsSolution().letterCombinations("234");
        log.info("list: {}", list);
    }
}
