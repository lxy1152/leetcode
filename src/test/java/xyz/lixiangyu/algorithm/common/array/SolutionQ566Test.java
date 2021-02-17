package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ566}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ566Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ566();
    }

    @Override
    public void testSolutionCaseOne() {
        int[][] expected = new int[][]{{1, 2, 3, 4}};
        int[][] result = (int[][]) solution.solve(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        Assert.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

    @Test
    public void testSolutionCaseTwo() {
        int[][] expected = new int[][]{{1, 2}, {3, 4}};
        int[][] result = (int[][]) solution.solve(new int[][]{{1, 2}, {3, 4}}, 2, 4);
        Assert.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }
}
