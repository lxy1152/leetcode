package xyz.lixiangyu.algorithm.common.array;

import org.junit.Assert;
import org.junit.Test;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ208}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ208Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ208();
    }

    @Override
    public void testSolutionCaseOne() {
        Trie trie = (Trie) solution.solve();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));
    }

    @Test
    public void testSolutionCaseTwo() {
        Trie trie = (Trie) solution.solve();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("bear");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("jan"));
        System.out.println(trie.startsWith("jan"));
    }
}
