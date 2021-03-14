package xyz.lixiangyu.algorithm.common.hash;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ705}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ705Test extends AbstractTest {
    private MyHashSet myHashSet;

    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ705();
        myHashSet = (MyHashSet) solution.solve();
    }

    @Override
    public void testSolutionCaseOne() {
        myHashSet.add(1);
        myHashSet.add(2);
        Assert.assertTrue(myHashSet.contains(1));
        Assert.assertFalse(myHashSet.contains(3));
        myHashSet.add(2);
        Assert.assertTrue(myHashSet.contains(2));
        myHashSet.remove(2);
        Assert.assertFalse(myHashSet.contains(2));
    }
}
