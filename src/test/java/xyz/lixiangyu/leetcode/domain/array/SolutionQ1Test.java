package xyz.lixiangyu.leetcode.domain.array;

import org.junit.Before;
import xyz.lixiangyu.leetcode.domain.AbstractTest;
import xyz.lixiangyu.leetcode.infrastructure.annotation.Problem;
import xyz.lixiangyu.leetcode.domain.entity.array.SolutionQ1;

/**
 * @author lixiangyu
 */
@Problem(target = SolutionQ1.class)
public class SolutionQ1Test extends AbstractTest {
    @Before
    public void addCase() {
        cases.addCase(new Integer[]{0, 1}, new int[]{1, 2, 3}, 3);
        cases.addCase(new Integer[]{1, 2}, new int[]{3, 2, 4}, 6);
    }
}
