package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ27}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ27Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ27();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve(new int[]{3, 2, 2, 3}, 3));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(5, solution.solve(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
