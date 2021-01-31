package xyz.lixiangyu.algorithm;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 第{@linkplain SolutionQ839 839题}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ839Test {
    private SolutionQ839 solutionQ839;
    private TimeInterval timeInterval;

    @Before
    public void beforeTestMethod() {
        solutionQ839 = new SolutionQ839();
        timeInterval = DateUtil.timer();
    }

    @After
    public void afterTestMethod() {
        Console.log("测试结束, 用时: " + timeInterval.interval() + "ms");
    }

    @Test
    public void testSolutionCaseOne() {
        assertEquals(2, solutionQ839.numSimilarGroups(new String[]{"tars","rats","arts","star"}));
    }

    @Test
    public void testSolutionCaseTwo() {
        assertEquals(1, solutionQ839.numSimilarGroups(new String[]{"omv","ovm"}));
    }
}
