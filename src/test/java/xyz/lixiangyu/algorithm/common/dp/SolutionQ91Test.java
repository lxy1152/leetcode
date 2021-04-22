package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ91}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ91Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ91();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(2, solution.solve("12"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(3, solution.solve("226"));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(0, solution.solve("0"));
    }


    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals(0, solution.solve("06"));
    }
}
