package xyz.lixiangyu.algorithm;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionQ1Test {
    private SolutionQ1 solutionQ1;
    private TimeInterval timeInterval;

    @Before
    public void beforeTestMethod() {
        solutionQ1 = new SolutionQ1();
        timeInterval = DateUtil.timer();
    }

    @After
    public void afterTestMethod() {
        Console.log("测试结束, 用时: " + timeInterval.interval() + "ms");
    }

    @Test
    public void testSolutionCaseOne() {
        assertArrayEquals(new int[]{0, 1}, solutionQ1.twoSum(new int[]{2, 7, 11, 5}, 9));
    }

    @Test
    public void testSolutionCaseTwo() {
        assertArrayEquals(new int[]{1, 2}, solutionQ1.twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    public void testSolutionCaseThree() {
        assertArrayEquals(new int[]{0, 1}, solutionQ1.twoSum(new int[]{3, 3}, 6));
    }
}
