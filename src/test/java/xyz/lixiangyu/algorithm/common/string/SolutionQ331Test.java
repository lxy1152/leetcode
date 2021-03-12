package xyz.lixiangyu.algorithm.common.string;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ331}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ331Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ331();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(true, solution.solve("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(false, solution.solve("1,#"));
    }

    @Test
    public void testSolutionCaseThree() {
        Assert.assertEquals(false, solution.solve("9,#,#,1"));
    }

    @Test
    public void testSolutionCaseFour() {
        Assert.assertEquals(true, solution.solve("9,#,92,#,#"));
    }

    @Test
    public void testSolutionCaseFive() {
        Assert.assertEquals(false, solution.solve("#,#,3,5,#"));
    }

    @Test
    public void testSolutionCaseSix() {
        Assert.assertEquals(true, solution.solve("#"));
    }

    @Test
    public void testSolutionCaseSeven() {
        Assert.assertEquals(false, solution.solve("7,2,#,2,#,#,#,6,#"));
    }
}
