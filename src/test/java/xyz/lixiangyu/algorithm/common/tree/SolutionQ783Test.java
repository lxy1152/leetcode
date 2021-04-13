package xyz.lixiangyu.algorithm.common.tree;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * {@link SolutionQ783}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ783Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ783();
    }

    @Override
    public void testSolutionCaseOne() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        Assert.assertEquals(1, solution.solve(root));
    }

    @Test
    public void testSolutionCaseTwo() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(48);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        Assert.assertEquals(1, solution.solve(root));
    }
}
