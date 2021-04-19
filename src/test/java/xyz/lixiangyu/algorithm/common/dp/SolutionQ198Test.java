package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ198}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ198Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ198();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(4, solution.solve(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(12, solution.solve(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(4173, solution.solve(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240}));
    }
}
