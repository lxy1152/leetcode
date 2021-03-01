package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ304}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ304Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        solution = new SolutionQ304(matrix);
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(8, solution.solve(2, 1, 4, 3));
        Assert.assertEquals(11, solution.solve(1, 1, 2, 2));
        Assert.assertEquals(12, solution.solve(1, 2, 2, 4));
    }
}
