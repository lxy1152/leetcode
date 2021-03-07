package xyz.lixiangyu.contest.contest231;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * @author lixiangyu
 */
public class SolutionQ5699Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ5699();
    }

    @Override
    public void testSolutionCaseOne() {
        Assert.assertEquals(
                3,
                solution.solve(5, new int[][]{{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}}));
    }

    @Test
    public void testSolutionCaseTwo() {
        Assert.assertEquals(
                1,
                solution.solve(7, new int[][]{{1, 3, 1}, {4, 1, 2}, {7, 3, 4}, {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}}));
    }
}
