package cade.struc.hash;

import cade.AppTest;
import org.junit.Test;

import java.util.Arrays;

public class P1TwoSumSolutionTest extends AppTest {

    @Test
    public void twoSum() {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] ints = new P1TwoSumSolution().twoSum(arr, 9);
        log.info("Arrays.asList(ints): {}", Arrays.toString(ints));;
    }
}
