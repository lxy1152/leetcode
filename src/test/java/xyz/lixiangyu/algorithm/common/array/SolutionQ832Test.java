package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ832}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ832Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ832();
    }

    @Override
    public void testSolutionCaseOne() {
        String expected = "[[1, 0, 0], [0, 1, 0], [1, 1, 1]]";
        String result =
                Arrays.deepToString((int[][]) solution.solve((Object) new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSolutionCaseTwo() {
        String expected = "[[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]";
        String result =
                Arrays.deepToString(
                        (int[][]) solution.solve((Object) new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}));
        Assert.assertEquals(expected, result);
    }
}
