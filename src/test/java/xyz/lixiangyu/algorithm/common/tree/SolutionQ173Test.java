package xyz.lixiangyu.algorithm.common.tree;

import xyz.lixiangyu.algorithm.AbstractTest;
import xyz.lixiangyu.template.structure.TreeNode;

/**
 * {@link SolutionQ173}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ173Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ173();
    }

    @Override
    public void testSolutionCaseOne() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bstIterator = (BSTIterator) solution.solve(root);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}
