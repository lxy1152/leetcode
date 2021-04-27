package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1011}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1011Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1011();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(15, solution.solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(6, solution.solve(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }
}
