package top.cadecode.learn.leetcode.struc.hash;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;

import java.util.List;

public class P17LetterCombinationsSolutionTest extends AppTest {
    @Test
    public void test() {
        List<String> list = new P17LetterCombinationsSolution().letterCombinations("234");
        log.info("list: {}", list);
    }
}
