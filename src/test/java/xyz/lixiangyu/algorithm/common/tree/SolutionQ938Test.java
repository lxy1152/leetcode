package xyz.lixiangyu.algorithm.common.tree;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * {@link SolutionQ938}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ938Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ938();
    }

    @Override
    public void testSolutionCaseOne() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        Assert.assertEquals(32, solution.solve(root, 7, 15));
    }
}
