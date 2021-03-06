package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ503}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ503Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ503();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("[2, -1, 2]", Arrays.toString((int[]) solution.solve(new int[]{1, 2, 1})));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("[-1, 5, 5, 5, 5]", Arrays.toString((int[]) solution.solve(new int[]{5, 4, 3, 2, 1})));
    }
}
