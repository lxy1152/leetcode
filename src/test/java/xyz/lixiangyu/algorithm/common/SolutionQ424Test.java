package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ424}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ424Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ424();
    }

    @Test
    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(4, solution.solve("ABAB", 2));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(4, solution.solve("AABABBA", 1));
    }
}
