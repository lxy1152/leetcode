package xyz.lixiangyu.algorithm.common;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.Arrays;

/**
 * {@link SolutionQ703}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ703Test extends AbstractTest {
    @Override
    public void testSolutionCaseOne() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        Assert.assertEquals(
                Arrays.toString(new int[]{4, 5, 5, 8, 8}),
                Arrays.toString(
                        new int[]{
                                kthLargest.add(3),
                                kthLargest.add(5),
                                kthLargest.add(10),
                                kthLargest.add(9),
                                kthLargest.add(4)
                        }
                ));
    }
}
