package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ88}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ88Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ88();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(
                "[1, 2, 2, 3, 5, 6]",
                Arrays.toString((int[]) solution.solve(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("[1]", Arrays.toString((int[]) solution.solve(new int[]{1}, 1, new int[]{}, 0)));
    }
}
