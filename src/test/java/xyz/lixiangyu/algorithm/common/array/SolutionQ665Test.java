package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * @author lixiangyu
 */
public class SolutionQ665Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ665();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(true, solution.solve(new int[]{4, 2, 3}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(false, solution.solve(new int[]{4, 2, 1}));
    }
}
