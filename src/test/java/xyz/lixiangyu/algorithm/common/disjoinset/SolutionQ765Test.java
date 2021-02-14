package xyz.lixiangyu.algorithm.common.disjoinset;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ765}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ765Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ765();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(1, solution.solve(new int[]{0, 2, 1, 3}));
    }

    @Test
    public void testSolutionCaseTwo() {
        // Assert.assertEquals(0, solution.solve(new int[]{3, 2, 0, 1}));
        System.out.println(solution.solve(new int[]{11, 5, 10, 13, 4, 1, 3, 7, 8, 6, 12, 9, 0, 2}));
    }
}
