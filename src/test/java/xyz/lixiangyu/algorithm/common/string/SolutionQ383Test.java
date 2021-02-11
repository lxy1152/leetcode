package xyz.lixiangyu.algorithm.common.string;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.algorithm.constants.Constants;

/**
 * {@link SolutionQ383}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ383Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ383();
        solutionType = Constants.FAST_SOLUTION;
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(true, solution.solve("aa", "aab", solutionType));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(false, solution.solve("a", "b", solutionType));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(false, solution.solve("aa", "ab", solutionType));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals(true, solution.solve("", "", solutionType));
    }
}
