package xyz.lixiangyu.leetcode.infrastructure.model.testcase;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import xyz.lixiangyu.leetcode.infrastructure.model.solution.SolveResult;

import java.util.List;

/**
 * 用例
 *
 * @author lixiangyu
 */
@Data
@Slf4j
public class Case {
    /**
     * 希望的执行结果
     */
    private Object expectedResult;

    /**
     * 调用时的参数
     */
    private Object[] parameters;

    /**
     * 执行结果
     */
    private List<SolveResult> solveResult;

    public Case(Object expectedResult, Object... parameters) {
        this.expectedResult = expectedResult;
        this.parameters = parameters;
    }
}
