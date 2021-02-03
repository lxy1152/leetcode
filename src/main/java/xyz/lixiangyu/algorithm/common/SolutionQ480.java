package xyz.lixiangyu.algorithm.common;

import xyz.lixiangyu.AbstractSolution;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/sliding-window-median/">480. 滑动窗口中位数</a>
 *
 * <p>
 * 描述:<br>
 * 中位数是有序序列最中间的那个数, 如果序列的长度是偶数, 则没有最中间的数, 此时中位数是最中间的两个数的平均数<br>
 * 例如:<br>
 * [2, 3, 4], 中位数是3<br>
 * [2,3], 中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums, 有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数, 每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数, 并输出由它们组成的数组。
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: {@code nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3}<br>
 * 输出: {@code [1, -1, -1, 3, 5, 6]}<br>wan
 * <pre>
 *           窗口位置              中位数
 * ------------------------------------
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * </pre>
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li>你可以假设{@code k}始终有效，即{@code k}始终小于输入的非空数组的元素个数</li>
 *     <li>与真实值误差在10^-5以内的答案将被视作正确答案</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ480 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  一个数组
     * @param obj1 窗口长度
     * @return 窗口中的中位数
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof int[] && obj1 instanceof Integer) {
            return medianSlidingWindow((int[]) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 计算滑动窗口的中位数
     *
     * <p>
     * 思路:<br>
     * 使用优先队列做大顶堆和小顶堆, 详细的实现逻辑见下方注释<br>
     * <b>
     * 注意: 测试用例中包含{@code 2147483647}这种情况, 所以包装类不能选择{@link Integer}而应该是{@link Long},
     * 同时从数组中取值后都要做强转, 转成{@code long}型
     * </b>
     * </p>
     *
     * @param nums 一个数组
     * @param k    窗口大小
     * @return 中位数
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 大顶堆存放小于中位数的数
        // 因为默认按照小顶堆的顺序排列, 所以需要重写比较器
        // 队首元素是所有小于中位数的数的最大值
        Queue<Long> bigHeap = new PriorityQueue<>((o1, o2) -> {
            if (o2 - o1 > 0) {
                return 1;
            }
            if (o1.equals(o2)) {
                return 0;
            }
            return -1;
        });
        // 小顶堆用于存放大于中位数的数
        // 队首元素是所有大于中位数的数的最小值
        Queue<Long> smallHeap = new PriorityQueue<>();
        // 初始化两个堆
        // 先把所有的数据都放在小顶堆里面
        for (int i = 0; i < k; i++) {
            smallHeap.add((long) nums[i]);
        }
        // 将前一半的小顶堆的最小值搬到大顶堆中
        // 这样会导致小顶堆的大小和大顶堆的大小相等或者多一
        // 那么窗口大小如果是奇数, 就直接取小顶堆的堆顶就可以了
        int half = k / 2;
        while (half > 0) {
            bigHeap.add(smallHeap.poll());
            half--;
        }
        // 用于保存结果
        double[] result = new double[nums.length - k + 1];
        // 计算第一个窗口的中位数
        result[0] = getMedian(k, smallHeap, bigHeap);
        // 开始移动窗口
        // 因为第一个窗口已经计算过了, 所以i直接从k开始循环
        for (int i = k; i < nums.length; i++) {
            // 下一个窗口需要新插入的值
            int newValue = nums[i];
            // 上一个窗口需要删除的值
            int oldValue = nums[i - k];
            // 因为默认从小顶堆中取值, 所以应该优先删除大顶堆, 优先添加到小顶堆
            // 注意这里全部都要做强转, 否则结果是不对的
            if (!bigHeap.isEmpty() && oldValue <= bigHeap.peek()) {
                bigHeap.remove((long) oldValue);
            } else {
                smallHeap.remove((long) oldValue);
            }
            if (!smallHeap.isEmpty() && newValue >= smallHeap.peek()) {
                smallHeap.add((long) newValue);
            } else {
                bigHeap.add((long) newValue);
            }
            // 平衡两个堆的大小
            // 小顶堆的大小应该和大顶堆相同或者多一
            while (bigHeap.size() > smallHeap.size()) {
                smallHeap.add(bigHeap.poll());
            }
            while (smallHeap.size() > bigHeap.size() + 1) {
                bigHeap.add(smallHeap.poll());
            }
            // 获取中位数
            result[i - k + 1] = getMedian(k, smallHeap, bigHeap);
        }
        return result;
    }

    /**
     * 从大顶堆和小顶堆中计算中位数
     *
     * @param k         窗口大小
     * @param smallHeap 小顶堆
     * @param bigHeap   大顶堆
     * @return 中位数
     */
    public double getMedian(int k, Queue<Long> smallHeap, Queue<Long> bigHeap) {
        // 如果是偶数, 需要将堆顶的值相加除2, 否则直接取小顶堆的堆顶
        if (k % 2 == 0) {
            return (double) (bigHeap.peek() + smallHeap.peek()) / 2;
        } else {
            return (double) smallHeap.peek();
        }
    }
}
