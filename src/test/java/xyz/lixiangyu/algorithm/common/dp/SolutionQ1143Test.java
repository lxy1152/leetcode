package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1143}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1143Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1143();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve("abcde", "ace"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(3, solution.solve("abc", "abc"));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(3, solution.solve("abc", "def"));
    }
}
