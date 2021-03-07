package xyz.lixiangyu.contest.contest231;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ5697}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ5697Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ5697();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(false, solution.solve("1001"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(true, solution.solve("110"));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(true, solution.solve("1"));
    }
}
