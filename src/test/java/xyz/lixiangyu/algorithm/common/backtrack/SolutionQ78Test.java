package xyz.lixiangyu.algorithm.common.backtrack;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ78}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ78Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ78();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(
                "[[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]",
                solution.solve(new int[]{1, 2, 3}).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("[[0], []]", solution.solve(new int[]{0}).toString());
    }

    @Test
    public void testSolutionCaseThree() {
        System.out.println(solution.solve(new int[]{1, 2, 2}));
    }
}
