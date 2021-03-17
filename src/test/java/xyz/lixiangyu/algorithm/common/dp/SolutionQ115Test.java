package xyz.lixiangyu.algorithm.common.dp;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ115}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ115Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ115();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(3, solution.solve("rabbbit", "rabbit"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(5, solution.solve("babgbag", "bag"));
    }
}
