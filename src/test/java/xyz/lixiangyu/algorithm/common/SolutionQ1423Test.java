package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1423}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1423Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1423();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(12, solution.solve(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(4, solution.solve(new int[]{2, 2, 2}, 2));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(55, solution.solve(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals(1, solution.solve(new int[]{1, 1000, 1}, 1));
    }

    @Test
    public void testSolutionCaseFive() {
        Assert.assertEquals(202, solution.solve(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }
}
