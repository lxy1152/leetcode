package xyz.lixiangyu.algorithm.common.tree;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * {@link SolutionQ94}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ94Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ94();
    }

    @Override
    public void testSolutionCaseOne() {
        TreeNode root =
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        Assert.assertEquals("[1, 3, 2]", solution.solve(root).toString());
    }

    @Test
    public void testSolutionCaseTwo() {
        TreeNode root = null;
        Assert.assertEquals("[]", solution.solve(root).toString());
    }

    @Test
    public void testSolutionCaseThree() {
        TreeNode root = new TreeNode(1);
        Assert.assertEquals("[1]", solution.solve(root).toString());
    }

    @Test
    public void testSolutionCaseFour() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        Assert.assertEquals("[2, 1]", solution.solve(root).toString());
    }

    @Test
    public void testSolutionCaseFive() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        Assert.assertEquals("[1, 2]", solution.solve(root).toString());
    }
}
