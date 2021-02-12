package xyz.lixiangyu.algorithm.common.other;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.algorithm.constants.Constants;

/**
 * {@link SolutionQ119}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ119Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ119();
        solutionType = Constants.COMMON_SOLUTION;
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("[1, 3, 3, 1]", solution.solve(3, solutionType).toString());
    }
}
