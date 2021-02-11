package xyz.lixiangyu.algorithm.common.twopointer;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * @author lixiangyu
 */
public class SolutionQ978Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ978();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(5, solution.solve(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(2, solution.solve(new int[]{4, 8, 12, 16}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(1, solution.solve(new int[]{100}));
    }
}
