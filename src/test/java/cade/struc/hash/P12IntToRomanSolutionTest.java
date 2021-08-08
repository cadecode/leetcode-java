package cade.struc.hash;

import cade.AppTest;
import org.junit.Test;

public class P12IntToRomanSolutionTest extends AppTest {

    @Test
    public void test() {
        String s = new P12IntToRomanSolution().intToRoman(1101);
        log.info("s: {}", s);
    }
}
