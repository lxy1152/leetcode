package xyz.lixiangyu.algorithm.common.hash;

import xyz.lixiangyu.AbstractSolution;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/design-hashmap/">706. 设计哈希映射</a>
 *
 * <p>
 * 描述:<br>
 * 不使用任何内建的哈希表库设计一个哈希映射({@code HashMap})<br>
 * 实现{@link MyHashMap}类:<br>
 * 1. {@link MyHashMap#MyHashMap()}用空映射初始化对象<br>
 * 2. {@link MyHashMap#put(int, int)}向{@code HashMap}插入一个键值对{@code (key, value)}, 如果{@code key}已经存在于映射中,
 * 则更新其对应的值{@code value}<br>
 * 3. {@link MyHashMap#get(int)}返回特定的{@code key}所映射的{@code value}, 如果映射中不包含{@code key}的映射, 返回{@code -1}<br>
 * 4. {@link MyHashMap#remove(int)}如果映射中存在{@code key}的映射, 则移除{@code key}和它所对应的{@code value}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: <br>
 * {@code ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]}<br>
 * {@code [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]}<br>
 * 输出: {@code [null, null, null, 1, -1, null, 1, null, -1]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= key, value <= 10^6</b></li>
 *     <li><b>最多调用 10^4 次{@code put, get, remove}方法</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ706 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @return {@link MyHashMap}
     */
    @Override
    public Object solve() {
        return new MyHashMap();
    }
}

/**
 * 本题要求实现的哈希映射结构
 */
class MyHashMap {
    private static final int BASE = 769;
    private LinkedList[] data;

    /**
     * 默认构造方法
     */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Pair>();
        }
    }

    /**
     * 向HashMap中新增一项
     */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }

    /**
     * 从HashMap中根据键获得值
     */
    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    /**
     * 从HashMap中移除一项
     */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                data[h].remove(pair);
                return;
            }
        }
    }

    /**
     * 计算某个键对应的哈希值
     *
     * @param key 键
     * @return 键所对应的哈希值
     */
    private static int hash(int key) {
        return key % BASE;
    }
}

/**
 * 键值对对应的数据结构
 */
class Pair {
    private int key;
    private int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
