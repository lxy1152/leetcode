package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ74}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ74Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ74();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(
                true,
                solution.solve(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(
                false,
                solution.solve(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}
