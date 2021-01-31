package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ67}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ67Test extends AbstractTest {
    /**
     * {@inheritDoc}
     */
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ67();
    }

    @Test
    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("10101", solution.solve("1010", "1011"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("100", solution.solve("11", "1"));
    }
}
