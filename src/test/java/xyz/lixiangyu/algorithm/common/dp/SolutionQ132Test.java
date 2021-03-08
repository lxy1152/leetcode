package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ132}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ132Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ132();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(1, solution.solve("aab"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(0, solution.solve("aa"));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(1, solution.solve("ab"));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals(2, solution.solve("leet"));
    }
}
