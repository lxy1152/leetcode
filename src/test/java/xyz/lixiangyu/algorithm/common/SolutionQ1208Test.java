package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1208}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1208Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1208();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve("abcd", "bcdf", 3));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(1, solution.solve("abcd", "cdef", 3));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(1, solution.solve("abcd", "acde", 0));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals(4, solution.solve("abcd", "abcd", 0));
    }
}
