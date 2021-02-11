package xyz.lixiangyu.algorithm.common.heap;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ480}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ480Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ480();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(
                Arrays.toString(new double[]{1, -1, -1, 3, 5, 6}),
                Arrays.toString((double[]) solution.solve(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(
                Arrays.toString(new double[]{2147483647.0}),
                Arrays.toString((double[]) solution.solve(new int[]{2147483647, 2147483647}, 2)));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(
                Arrays.toString(new double[]{1.0, -1.0, -1.0, 3.0, 5.0, 6.0}),
                Arrays.toString((double[]) solution.solve(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
