package xyz.lixiangyu.contest.contest231;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ5698}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ5698Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ5698();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve(new int[]{1, -1, 1}, 3, -4));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(1, solution.solve(new int[]{1, -10, 9, 1}, 100, 0));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(1, solution.solve(new int[]{1, 1, 1}, 3, 6));
    }
}
