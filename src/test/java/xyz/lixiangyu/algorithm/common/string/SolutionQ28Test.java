package xyz.lixiangyu.algorithm.common.string;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ28}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ28Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ28();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve("hello", "ll"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(-1, solution.solve("aaaaa", "bba"));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(0, solution.solve("", ""));
    }
}
