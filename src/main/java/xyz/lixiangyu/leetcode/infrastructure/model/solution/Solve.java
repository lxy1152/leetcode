package xyz.lixiangyu.leetcode.infrastructure.model.solution;

import xyz.lixiangyu.leetcode.infrastructure.model.testcase.Case;

import java.util.List;

/**
 * 实现该接口表示该类可以作为题解
 *
 * @author lixiangyu
 */
public interface Solve {
    /**
     * 根据用例解决问题
     *
     * @param testCase 用例
     * @return 处理结果
     */
    List<SolveResult> solve(Case testCase);
}
