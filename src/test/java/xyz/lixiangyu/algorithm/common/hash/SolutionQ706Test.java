package xyz.lixiangyu.algorithm.common.hash;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ706}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ706Test extends AbstractTest {
    private MyHashMap map;

    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ706();
        map = (MyHashMap) solution.solve();
    }

    @Override
    public void testSolutionCaseOne() {
        map.put(1, 1);
        map.put(2, 2);
        Assert.assertEquals(1, map.get(1));
        Assert.assertEquals(-1, map.get(3));
        map.put(2, 1);
        Assert.assertEquals(1, map.get(2));
        map.remove(2);
        Assert.assertEquals(-1, map.get(2));
    }
}
