package xyz.lixiangyu.algorithm.common.twopointer;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ395}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ395Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ395();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve("aaabb", 3));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(5, solution.solve("ababbc", 2));
    }
}
