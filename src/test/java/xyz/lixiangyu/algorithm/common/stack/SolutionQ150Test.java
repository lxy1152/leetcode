package xyz.lixiangyu.algorithm.common.stack;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ150}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ150Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ150();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(9, solution.solve((Object) new String[]{"2", "1", "+", "3", "*"}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(6, solution.solve((Object) new String[]{"4", "13", "5", "/", "+"}));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(22, solution.solve((Object) new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
