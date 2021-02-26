package xyz.lixiangyu.algorithm.common.other;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.List;

/**
 * @author lixiangyu
 */
public class SolutionQ1178Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1178();
    }

    @Override
    public void testSolutionCaseOne() {
        String expected = "[1, 1, 3, 2, 4, 0]";
        String result =
                solution.solve(
                        new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                        new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}).toString();
        Assert.assertEquals(expected, result);
    }
}
