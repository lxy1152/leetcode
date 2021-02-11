package xyz.lixiangyu.algorithm.common.twopointer;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ567}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ567Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ567();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(true, solution.solve("ab", "eidbaooo"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(false, solution.solve("ab", "eidboaoo"));
    }
}
