package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ54}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ54Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ54();
    }

    @Override
    public void testSolutionCaseOne() {
        String expected = "[1, 2, 3, 6, 9, 8, 7, 4, 5]";
        String result = solution.solve((Object) new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toString();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSolutionCaseTwo() {
        String expected = "[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]";
        String result = solution.solve((Object) new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).toString();
        Assert.assertEquals(expected, result);
    }
}
