package xyz.lixiangyu.algorithm.interview.dp;

import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1721}
 *
 * @author lixiangyu
 */
public class SolutionQ1721Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1721();
    }

    @Override
    public void testSolutionCaseOne() {
        System.out.println(solution.solve(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
