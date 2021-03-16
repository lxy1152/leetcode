package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ59}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ59Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ59();
    }

    @Override
    public void testSolutionCaseOne() {
        String expected = "[[1, 2, 3], [8, 9, 4], [7, 6, 5]]";
        String result = Arrays.deepToString((int[][]) solution.solve(3));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSolutionCaseTwo() {
        String expected = "[[1]]";
        String result = Arrays.deepToString((int[][]) solution.solve(1));
        Assert.assertEquals(expected, result);
    }
}
