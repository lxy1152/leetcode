package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ867}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ867Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ867();
    }

    @Override
    public void testSolutionCaseOne() {
        String expected = "[[1, 4, 7], [2, 5, 8], [3, 6, 9]]";
        String result =
                Arrays.deepToString((int[][]) solution.solve((Object) new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSolutionCaseTwo() {
        String expected = "[[1, 4], [2, 5], [3, 6]]";
        String result =
                Arrays.deepToString((int[][]) solution.solve((Object) new int[][]{{1, 2, 3}, {4, 5, 6}}));
        Assert.assertEquals(expected, result);
    }
}
