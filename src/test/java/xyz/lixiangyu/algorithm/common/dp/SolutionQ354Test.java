package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ354}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ354Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ354();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve((Object) new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(1, solution.solve((Object) new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    }
}
