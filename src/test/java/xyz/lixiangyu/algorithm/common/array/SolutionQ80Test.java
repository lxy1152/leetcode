package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ80}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ80Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ80();
    }

    @Override
    public void testSolutionCaseOne() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int result = (int) solution.solve(nums);
        for (int i = 0; i < result; i++) {
            System.out.println("nums_" + i + ": " + nums[i]);
        }
        Assert.assertEquals(5, result);
    }

    @Test
    public void testSolutionCaseTwo() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = (int) solution.solve(nums);
        for (int i = 0; i < result; i++) {
            System.out.println("nums_" + i + ": " + nums[i]);
        }
        Assert.assertEquals(7, result);
    }
}
