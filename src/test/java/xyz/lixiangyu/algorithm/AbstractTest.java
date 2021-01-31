package xyz.lixiangyu.algorithm;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xyz.lixiangyu.Solution;

/**
 * 抽象测试类, 每个测试类需要继承本类, 并重写需要的方法
 *
 * @author lixiangyu
 */
public abstract class AbstractTest {
    /**
     * 计时器
     */
    protected TimeInterval timeInterval;

    /**
     * 题解
     */
    protected Solution solution;

    /**
     * 执行测试用例前执行, 开启计时器, 实例化{@link #solution}
     */
    @Before
    public void beforeTestMethod() {
        timeInterval = DateUtil.timer();
    }

    /**
     * 执行测试用例后执行, 输出执行所用时间
     */
    @After
    public void afterTestMethod() {
        Console.log("测试结束, 用时: " + timeInterval.interval() + "ms");
    }

    /**
     * 提供默认的测试用例
     */
    @Test
    public void testSolutionCaseOne() {

    }
}
