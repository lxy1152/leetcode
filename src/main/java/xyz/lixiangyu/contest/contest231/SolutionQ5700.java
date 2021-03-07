package xyz.lixiangyu.contest.contest231;

import xyz.lixiangyu.AbstractSolution;

import java.util.*;

/**
 * @author lixiangyu
 */
public class SolutionQ5700 extends AbstractSolution {
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return minChanges((int[]) obj, (int) obj1);
        }
        return null;
    }

    public int minChanges(int[] nums, int k) {
        return 0;
    }
}
