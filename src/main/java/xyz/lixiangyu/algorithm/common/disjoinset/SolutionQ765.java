package xyz.lixiangyu.algorithm.common.disjoinset;

import xyz.lixiangyu.AbstractSolution;
import xyz.lixiangyu.template.structure.DisjointSet;

/**
 * <a href="https://leetcode-cn.com/problems/couples-holding-hands/">765. 情侣牵手</a>
 *
 * <p>
 * 描述:<br>
 * {@code N}对情侣坐在连续排列的{@code 2N}个座位上, 想要牵到对方的手. 计算最少交换座位的次数, 以便每对情侣可以并肩坐在一起<br>
 * 一次交换可选择任意两人, 让他们站起来交换座位<br>
 * 人和座位用{@code 0}到{@code 2N-1}的整数表示, 情侣们按顺序编号, 第一对是{@code (0, 1)},
 * 第二对是{@code (2, 3)}, 以此类推, 最后一对是{@code (2N-2, 2N-1)}<br>
 * 这些情侣的初始座位{@code row[i]}是由最初始坐在第{@code i}个座位上的人决定的
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code row = [0, 2, 1, 3]}<br>
 * 输出: {@code 1}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入: {@code row = [3, 2, 0, 1]}<br>
 * 输出: {@code 0}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>len(row)是偶数且数值在[4, 60]范围内</b></li>
 *     <li><b>可以保证row是序列0...len(row)-1的一个全排列</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ765 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj 一个数组
     * @return 最少交换次数
     */
    @Override
    public Object solve(Object obj) {
        if (obj instanceof int[]) {
            return minSwapsCouples((int[]) obj);
        }
        return null;
    }

    /**
     * 计算最少交换次数, 使所有情侣都能牵手成功
     *
     * <p>
     * 思路:<br>
     * 通过并查集合并做错位置的情侣<br>
     * 对于并查集中的每一个集合:<br>
     * 由于对于{@code n}对情侣的最少交换次数总是为{@code n - 1}次(因为如果前面交换好了, 那么最后一对是不需要交换的)<br>
     * 所以总的最少交换次数为: {@code (n1 - 1) + (n2 - 1) + ... + (ni - 1)}, 其中{@code ni}代表每一个集合中的情侣对数<br>
     * 又因为: {@code n1 + n2 + ... ni = }情侣总数, {@code 1 + 1 + ... + 1(i)}个1交加代表并查集的集合数量<br>
     * 所以最少交换次数 = 情侣对数 - 并查集的大小
     * </p>
     *
     * @param row 一个数组
     * @return 最少交换次数
     */
    public int minSwapsCouples(int[] row) {
        // 数组长度
        int len = row.length;
        // 情侣对数
        int pairs = len / 2;
        // 新建一个并查集, 初始大小是情侣对数
        DisjointSet disjointSet = new DisjointSet(pairs);
        // 遍历数组, 每次的步长增加2, 因为两个人是一对
        for (int i = 0; i < len; i += 2) {
            // 对于一对情侣, 比如[0, 1], 除2后的结果是相同的, 意味着不需要合并
            // 即不需要交换
            disjointSet.union(row[i] / 2, row[i + 1] / 2);
        }
        return pairs - disjointSet.getSize();
    }
}
