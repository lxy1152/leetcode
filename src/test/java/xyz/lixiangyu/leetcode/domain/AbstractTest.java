package xyz.lixiangyu.leetcode.domain;

import com.sun.xml.internal.txw2.IllegalAnnotationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import xyz.lixiangyu.leetcode.infrastructure.annotation.Problem;
import xyz.lixiangyu.leetcode.application.command.SolveQuestion;
import xyz.lixiangyu.leetcode.infrastructure.equalrule.ObjectEqualRules;
import xyz.lixiangyu.leetcode.infrastructure.model.testcase.Case;
import xyz.lixiangyu.leetcode.infrastructure.model.testcase.Cases;
import xyz.lixiangyu.leetcode.infrastructure.model.solution.SolveResult;

import java.util.*;

/**
 * 抽象测试类
 *
 * @author lixiangyu
 */
@Slf4j
public abstract class AbstractTest {
    /**
     * 本测试包含的所有用例
     */
    protected Cases cases = new Cases();

    /**
     * 执行测试
     */
    @Test
    public void test() {
        Class<?> clazz = this.getClass();

        // 测试类需要使用Problem注解标明需要测试的类
        Problem problem = clazz.getAnnotation(Problem.class);
        if (Objects.isNull(problem)) {
            log.error("请检查代码，未配置Problem注解");
            throw new IllegalAnnotationException("未配置Problem注解");
        }

        // 执行题解
        SolveQuestion.solve(problem.target(), cases);
        // 根据解决方案进行分类
        Map<String, List<Case>> solutionNameToResult = new HashMap<>();
        for (Case testCase : cases.getCases()) {
            for (SolveResult solveResult : testCase.getSolveResult()) {
                List<Case> result = solutionNameToResult.getOrDefault(solveResult.getSolutionName(), new ArrayList<>());
                result.add(testCase);
                solutionNameToResult.put(solveResult.getSolutionName(), result);
            }
        }

        // 输出执行结果
        for (Map.Entry<String, List<Case>> entry : solutionNameToResult.entrySet()) {
            log.info("\n执行[{}]：", entry.getKey());
            int i = 1;
            for (Case testCase : entry.getValue()) {
                for (SolveResult solveResult : testCase.getSolveResult()) {
                    if (!solveResult.getSolutionName().equals(entry.getKey())) {
                        continue;
                    }

                    log.info("\t用例" + i++ + "，结果{}：\n\t\t传入参数：{}\n\t\t期望得到：{}\n\t\t运算结果：{}",
                            ObjectEqualRules.isObjectEqualsByEqualRules(solveResult.getSolveResult(),
                                    testCase.getExpectedResult()) ? "正确" : "错误", testCase.getParameters(),
                            testCase.getExpectedResult(), solveResult.getSolveResult());
                }
            }
        }
    }

    /**
     * 添加用例
     */
    @Before
    public void addCase() {

    }
}
