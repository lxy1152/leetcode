package xyz.lixiangyu.algorithm.common.backtrack;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ90}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ90Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ90();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(
                "[[1, 2, 2], [1, 2], [1], [2, 2], [2], []]",
                solution.solve(new int[]{1, 2, 2}).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("[[0], []]", solution.solve(new int[]{0}).toString());
    }
}
