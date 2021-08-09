package cade.struc.hash;

import cade.AppTest;
import org.junit.Test;

public class P13RomanToIntSolutionTest extends AppTest {

    @Test
    public void romanToInt() {
        int i = new P13RomanToIntSolution().romanToInt("MDCXCV");
        log.info("i: {}", i);
    }
}
