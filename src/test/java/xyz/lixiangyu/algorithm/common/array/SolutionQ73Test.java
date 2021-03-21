package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ73}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ73Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ73();
    }

    @Override
    public void testSolutionCaseOne() {
        String expected = "[[1, 0, 1], [0, 0, 0], [1, 0, 1]]";
        String result = Arrays.deepToString((int[][]) solution.solve((Object) new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSolutionCaseTwo() {
        String expected = "[[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]";
        String result = Arrays.deepToString((int[][]) solution.solve((Object) new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}));
        Assert.assertEquals(expected, result);
    }
}
