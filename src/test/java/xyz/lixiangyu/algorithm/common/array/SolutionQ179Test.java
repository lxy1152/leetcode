package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ179}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ179Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ179();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("210", solution.solve(new int[]{10, 2}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("9534330", solution.solve(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals("1", solution.solve(new int[]{1}));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals("10", solution.solve(new int[]{10}));
    }
}
