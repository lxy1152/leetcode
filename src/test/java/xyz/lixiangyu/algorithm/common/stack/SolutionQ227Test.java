package xyz.lixiangyu.algorithm.common.stack;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ227}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ227Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ227();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(7, solution.solve("3+2*2"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(1, solution.solve(" 3/2 "));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(5, solution.solve(" 3+5 / 2 "));
    }
}
