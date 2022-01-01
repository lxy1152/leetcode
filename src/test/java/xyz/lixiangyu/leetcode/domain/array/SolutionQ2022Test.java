package xyz.lixiangyu.leetcode.domain.array;

import xyz.lixiangyu.leetcode.domain.AbstractTest;
import xyz.lixiangyu.leetcode.domain.entity.array.SolutionQ2022;
import xyz.lixiangyu.leetcode.infrastructure.annotation.Problem;

/**
 * @author lixiangyu
 */
@Problem(target = SolutionQ2022.class)
public class SolutionQ2022Test extends AbstractTest {
    @Override
    public void addCase() {
        cases.addCase(new int[][]{{1, 2}, {3, 4}}, new int[]{1, 2, 3, 4}, 2, 2);
        cases.addCase(new int[][]{{1, 2, 3}}, new int[]{1, 2, 3}, 1, 3);
        cases.addCase(new int[][]{}, new int[]{1, 2}, 1, 1);
        cases.addCase(new int[][]{}, new int[]{3}, 1, 2);
    }
}
