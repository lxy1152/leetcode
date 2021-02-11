package xyz.lixiangyu.algorithm.common.disjoinset;

import org.junit.Before;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import static org.junit.Assert.assertEquals;

/**
 * {@link SolutionQ839}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ839Test extends AbstractTest {
    /**
     * {@inheritDoc}
     */
    @Before
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ839();
    }

    @Test
    public void testSolutionCaseOne() {
        assertEquals(2, solution.solve((Object) new String[]{"tars", "rats", "arts", "star"}));
    }

    @Test
    public void testSolutionCaseTwo() {
        assertEquals(1, solution.solve((Object) new String[]{"omv", "ovm"}));
    }
}
