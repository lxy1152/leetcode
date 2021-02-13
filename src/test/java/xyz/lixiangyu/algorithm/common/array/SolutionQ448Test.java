package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ448}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ448Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ448();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("[3]", solution.solve(new int[]{4, 5, 2, 1, 2}).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals("[5, 6]", solution.solve(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).toString());
    }
}
