package xyz.lixiangyu.leetcode.infrastructure.model.solution;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import xyz.lixiangyu.leetcode.infrastructure.annotation.Solution;
import xyz.lixiangyu.leetcode.infrastructure.model.testcase.Case;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 抽象题解
 *
 * @author lixiangyu
 */
@Slf4j
public abstract class AbstractSolution implements Solve {
    /**
     * 秒表，用于计时
     */
    private final StopWatch STOP_WATCH = StopWatch.create();

    /**
     * 查找带有{@link Solution}注解的方法并执行
     *
     * @param testCase 用例
     * @return 执行结果
     */
    @Override
    public List<SolveResult> solve(Case testCase) {
        Class<?> clazz = this.getClass();
        List<SolveResult> solveResults = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            // 只获取带有Solution注解的方法
            Solution solution = method.getAnnotation(Solution.class);
            if (Objects.isNull(solution) || solution.ignored()) {
                continue;
            }

            // 执行方法的名称，可在注解上自定义
            String methodName = method.getName();
            if (StringUtils.isNotBlank(solution.name())) {
                methodName = solution.name();
            }

            // 获取方法的参数
            Parameter[] methodParameters = method.getParameters();
            // 参数个数不匹配，跳过不执行
            if (testCase.getParameters().length != methodParameters.length) {
                continue;
            }

            try {
                // 执行具体的解法
                STOP_WATCH.start();
                Object invokeResult = method.invoke(this, testCase.getParameters());
                // 保存执行信息
                solveResults.add(new SolveResult(methodName, invokeResult, STOP_WATCH.getNanoTime(), null));
            } catch (Exception e) {
                log.error("执行[{}]出错", methodName, e);

                SolveResult solveResult = SolveResult.builder().solutionName(methodName).solveResult(null)
                                                     .time(STOP_WATCH.getNanoTime()).errorMessage(e.toString()).build();
                if (e instanceof InvocationTargetException) {
                    Throwable throwable = e.getCause();
                    solveResult.setErrorMessage(throwable.toString());
                }
                solveResults.add(solveResult);
            } finally {
                STOP_WATCH.reset();
            }
        }
        return solveResults;
    }
}
