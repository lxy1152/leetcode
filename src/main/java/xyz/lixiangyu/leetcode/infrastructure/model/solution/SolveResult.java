package xyz.lixiangyu.leetcode.infrastructure.model.solution;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 题解执行结果
 *
 * @author lixiangyu
 */
@Data
@AllArgsConstructor
public class SolveResult {
    /**
     * 解决方案名称
     */
    private String solutionName;

    /**
     * 执行结果
     */
    private Object solveResult;

    /**
     * 执行耗时
     */
    private long time;
}
