package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ766}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ766Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ766();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(
                true,
                solution.solve((Object) new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(false, solution.solve((Object) new int[][]{{1, 2}, {2, 2}}));
    }
}
