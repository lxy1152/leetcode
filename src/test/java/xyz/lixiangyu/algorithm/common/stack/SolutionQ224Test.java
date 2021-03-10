package xyz.lixiangyu.algorithm.common.stack;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ224}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ224Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ224();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve("1 + 1"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(3, solution.solve(" 2-1 + 2 "));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(23, solution.solve("(1+(4+5+2)-3)+(6+8)"));
    }
}
