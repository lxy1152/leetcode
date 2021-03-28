package xyz.lixiangyu.algorithm.common.other;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ190}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ190Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ190();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(964176192, solution.solve(0b00000010100101000001111010011100));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(-1073741825, solution.solve(0b11111111111111111111111111111101));
    }
}
