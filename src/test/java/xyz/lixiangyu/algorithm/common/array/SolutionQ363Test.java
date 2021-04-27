package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ363}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ363Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ363();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(3, solution.solve(new int[][]{{2, 2, -1}}, 3));
    }
}
