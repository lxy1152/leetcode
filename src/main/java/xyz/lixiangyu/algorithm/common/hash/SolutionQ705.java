package xyz.lixiangyu.algorithm.common.hash;

import xyz.lixiangyu.AbstractSolution;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/design-hashset/">705. 设计哈希集合</a>
 *
 * <p>
 * 描述:<br>
 * 不使用任何内建的哈希表库设计一个哈希集合({@code HashSet})<br>
 * 实现{@link MyHashSet}类:<br>
 * 1. {@link MyHashSet#add(int)}向哈希集合中插入值{@code key}<br>
 * 2. {@link MyHashSet#contains(int)}返回哈希集合中是否存在这个值{@code key}<br>
 * 3. {@link MyHashSet#remove(int)}将给定值{@code key}从哈希集合中删除, 如果哈希集合中没有这个值则什么也不做
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: <br>
 * {@code ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]}<br>
 * {@code [[], [1], [2], [1], [3], [2], [2], [2], [2]]}<br>
 * 输出: {@code [null, null, null, true, false, null, true, null, false]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= key <= 10^6</b></li>
 *     <li><b>最多调用 10^4 次{@code add, remove, contains}方法</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ705 extends AbstractSolution {
    @Override
    public Object solve() {
        return new MyHashSet();
    }
}

class MyHashSet {
    private int[] data;
    private static final int SIZE = 13_333;
    private static final int NULL = -1;
    private static final int DELETED = -2;

    public MyHashSet() {
        data = new int[SIZE];
        Arrays.fill(data, NULL);
    }

    public void add(int key) {
        data[hash(key)] = key;
    }

    public void remove(int key) {
        data[hash(key)] = DELETED;
    }

    public boolean contains(int key) {
        return data[hash(key)] != NULL;
    }

    private int hash(int key) {
        int i = key % SIZE;
        while (data[i] != key && data[i] != NULL) {
            i = (i + 1) % SIZE;
        }
        return i;
    }
}
