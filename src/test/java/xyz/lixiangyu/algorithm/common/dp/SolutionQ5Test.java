package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ5}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ5Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ5();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("bab", solution.solve("babad"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("bb", solution.solve("cbbd"));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals("a", solution.solve("a"));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals("a", solution.solve("ac"));
    }
}
