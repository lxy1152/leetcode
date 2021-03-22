package xyz.lixiangyu.algorithm.common.other;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ191}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ191Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ191();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve(0b00000000000000000000000000001011));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(1, solution.solve(0b00000000000000000000000010000000));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(31, solution.solve(0b11111111111111111111111111111101));
    }
}
