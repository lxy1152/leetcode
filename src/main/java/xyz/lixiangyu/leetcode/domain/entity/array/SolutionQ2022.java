package xyz.lixiangyu.leetcode.domain.entity.array;

import xyz.lixiangyu.leetcode.infrastructure.annotation.Solution;
import xyz.lixiangyu.leetcode.infrastructure.model.solution.AbstractSolution;

/**
 * @author lixiangyu
 */
public class SolutionQ2022 extends AbstractSolution {
    @Solution(name = "数学模拟")
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }
        return result;
    }
}
