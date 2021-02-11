package xyz.lixiangyu.algorithm.common.queue;

import xyz.lixiangyu.AbstractSolution;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/">703. 数据流中的第K大元素</a>
 *
 * <p>
 * 描述:<br>
 * 设计一个找到数据流中第{@code k}大元素的类, 注意是排序后的第{@code k}大元素, 不是第{@code k}个不同的元素<br>
 * 请实现{@link KthLargest}类:<br>
 * <ul>
 *     <li>{@link KthLargest#KthLargest(int, int[])}}使用整数{@code k}和整数流{@code nums}初始化对象</li>
 *     <li>
 *         {@link KthLargest#add(int)}将{@code val}插入数据流{@code nums}后, 返回当前数据流中第{@code k}大的元素
 *     </li>
 * </ul>
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入:<br>
 * {@code ["KthLargest", "add", "add", "add", "add", "add"]}<br>
 * {@code [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]}<br>
 * 输出: {@code [null, 4, 5, 5, 8, 8]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= k <= 10^4</b></li>
 *     <li><b>0 <= nums.length <= 10^4</b></li>
 *     <li><b>-10^4 <= nums[i] <= 10^4</b></li>
 *     <li><b>-10^4 <= val <= 10^4</b></li>
 *     <li><b>最多调用{@linkplain KthLargest#add add}方法10^4次</b></li>
 *     <li><b>题目数据保证, 在查找第{@code k}大元素时, 数组中至少有{@code k}个元素</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ703 extends AbstractSolution {
    /**
     * 本题不通过{@linkplain AbstractSolution#solve solve}方法来测试<br>
     * 直接实例化{@link KthLargest}类
     *
     * @return null
     */
    @Override
    public Object solve() {
        return super.solve();
    }
}

/**
 * 存储第{@code k}大元素的类
 */
class KthLargest {
    /**
     * 一个保存所有小于第{@code k}大元素的队列
     */
    private final Queue<Integer> queue;

    /**
     * 队列中限制的个数
     */
    private final int k;

    /**
     * 构造函数, 使用整数{@code k}和整数流{@code nums}初始化对象
     *
     * @param k    一个整数
     * @param nums 数据流
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    /**
     * 将数据流中的元素保存到队列中, 并返回第{@code k}大的元素<br>
     * 优先队列的默认实现是小顶堆(即前{@code k}大的元素), 队首元素是队列中的第
     * {@code k}小元素, 也就是数据流中的第{@code k}大元素
     *
     * @param val 某个数据
     * @return 第k大的元素
     */
    public int add(int val) {
        this.queue.offer(val);
        if (this.queue.size() > this.k) {
            queue.poll();
        }
        return queue.peek();
    }
}
