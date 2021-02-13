package xyz.lixiangyu.algorithm.common.tree;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * {@link SolutionQ100}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ100Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ100();
    }

    @Override
    public void testSolutionCaseOne() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertEquals(true, solution.solve(p, q));
    }

    @Test
    public void testSolutionCaseTwo() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        Assert.assertEquals(false, solution.solve(p, q));
    }

    @Test
    public void testSolutionCaseThree() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        Assert.assertEquals(false, solution.solve(p, q));
    }
}
