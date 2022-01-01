package xyz.lixiangyu.leetcode.application.command;

import lombok.extern.slf4j.Slf4j;
import xyz.lixiangyu.leetcode.infrastructure.model.testcase.Case;
import xyz.lixiangyu.leetcode.infrastructure.model.testcase.Cases;
import xyz.lixiangyu.leetcode.infrastructure.model.solution.Solve;

/**
 * 根据指定的题目编号、用例解决问题
 *
 * @author lixiangyu
 */
@Slf4j
public class SolveQuestion {
    public static void solve(Class<? extends Solve> solution, Cases cases) {
        try {
            Solve solve = solution.newInstance();
            for (Case testCase : cases.getCases()) {
                // 执行题解，并保存执行结果
                testCase.setSolveResult(solve.solve(testCase));
            }
        } catch (Exception e) {
            log.error("执行方法失败", e);
            throw new RuntimeException("执行方法失败", e);
        }
    }
}
