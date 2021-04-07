package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ81}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ81Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ81();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(true, solution.solve(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(false, solution.solve(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}
