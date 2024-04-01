package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.AppTest;
import org.junit.Test;

import java.util.Arrays;

public class P1SolutionTest extends AppTest {

    @Test
    public void twoSum() {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] ints = new P1Solution().twoSum(arr, 9);
        log.info("Arrays.asList(ints): {}", Arrays.toString(ints));;
    }
}
