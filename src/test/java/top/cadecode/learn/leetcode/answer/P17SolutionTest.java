package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;

import java.util.List;

public class P17SolutionTest extends AppTest {
    @Test
    public void test() {
        List<String> list = new P17Solution().letterCombinations("234");
        log.info("list: {}", list);
    }
}
