package xyz.lixiangyu.leetcode.domain.entity.array;

import xyz.lixiangyu.leetcode.infrastructure.annotation.Solution;
import xyz.lixiangyu.leetcode.infrastructure.model.solution.AbstractSolution;

import java.util.HashMap;

/**
 * @author lixiangyu
 */
public class SolutionQ1 extends AbstractSolution {
    @Solution(name = "哈希表解法")
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
