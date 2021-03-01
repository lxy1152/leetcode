package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ338}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ338Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ338();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("[0, 1, 1]", Arrays.toString((int[]) solution.solve(2)));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("[0, 1, 1, 2, 1, 2]", Arrays.toString((int[]) solution.solve(5)));
    }
}
