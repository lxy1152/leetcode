package xyz.lixiangyu.leetcode.infrastructure.model.solution;

import lombok.Builder;
import lombok.Data;

/**
 * 题解执行结果
 *
 * @author lixiangyu
 */
@Data
@Builder
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

    /**
     * 错误信息
     */
    private String errorMessage;
}
