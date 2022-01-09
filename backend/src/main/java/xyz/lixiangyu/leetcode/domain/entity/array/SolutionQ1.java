package xyz.lixiangyu.leetcode.domain.entity.array;

import xyz.lixiangyu.leetcode.infrastructure.annotation.ProblemTag;
import xyz.lixiangyu.leetcode.infrastructure.annotation.Solution;
import xyz.lixiangyu.leetcode.infrastructure.model.solution.AbstractSolution;
import xyz.lixiangyu.leetcode.infrastructure.model.solution.Tag;

import java.util.HashMap;

/**
 * @author lixiangyu
 */
@ProblemTag(tags = {Tag.ARRAY, Tag.HASHMAP})
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
