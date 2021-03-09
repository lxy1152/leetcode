package xyz.lixiangyu.algorithm.common.stack;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1047}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1047Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1047();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("ca", solution.solve("abbaca"));
    }
}
