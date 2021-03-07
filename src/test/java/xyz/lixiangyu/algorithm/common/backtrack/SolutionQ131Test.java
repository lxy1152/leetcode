package xyz.lixiangyu.algorithm.common.backtrack;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * @author lixiangyu
 */
public class SolutionQ131Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ131();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals("[[a, a, b], [aa, b]]", solution.solve("aab").toString());
    }
}
