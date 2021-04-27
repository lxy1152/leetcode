package xyz.lixiangyu.algorithm.common.tree;

import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * {@link SolutionQ897}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ897Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ897();
    }

    @Override
    public void testSolutionCaseOne() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        System.out.println(solution.solve(root));
    }
}
