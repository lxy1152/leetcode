package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.algorithm.constants.Constants;

import java.util.Arrays;

/**
 * {@link SolutionQ888}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ888Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ888();
        solutionType = Constants.FAST_SOLUTION;
    }

    @Override
    public void testSolutionCaseOne() {
        String expected = Arrays.toString(new int[]{1, 2});
        String result = Arrays.toString((int[]) solution.solve(new int[]{1, 1}, new int[]{2, 2}, solutionType));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSolutionCaseTwo() {
        String expected = Arrays.toString(new int[]{1, 2});
        String result = Arrays.toString((int[]) solution.solve(new int[]{1, 2}, new int[]{2, 3}, solutionType));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSolutionCaseThree() {
        String expected = Arrays.toString(new int[]{2, 3});
        String result = Arrays.toString((int[]) solution.solve(new int[]{2}, new int[]{1, 3}, solutionType));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSolutionCaseFour() {
        String expected = Arrays.toString(new int[]{5, 4});
        String result = Arrays.toString((int[]) solution.solve(new int[]{1, 2, 5}, new int[]{2, 4}, solutionType));
        Assert.assertEquals(expected, result);
    }
}
