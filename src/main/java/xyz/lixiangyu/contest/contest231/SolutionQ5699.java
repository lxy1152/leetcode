package xyz.lixiangyu.contest.contest231;

import xyz.lixiangyu.AbstractSolution;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-restricted-paths-from-first-to-last-node/">
 * 5699. 从第一个节点出发到最后一个节点的受限路径数
 * </a>
 *
 * <p>
 * 描述:<br>
 * 现有一个加权无向连通图, 给你一个正整数{@code n}, 表示图中有{@code n}个节点, 并按从{@code 1}到{@code n}给节点编号,
 * 另给你一个数组{@code edges}, 其中每个{@code edges[i] = [ui, vi, weighti]}表示存在一条位于节点{@code ui}和
 * {@code vi}之间的边, 这条边的权重为{@code weighti}.<br>
 *
 * 从节点{@code start}出发到节点{@code end}的路径是一个形如{@code [z0, z1, z2, ..., zk]}的节点序列,
 * 满足{@code z0 = start, zk = end}, 且在所有符合{@code 0 <= i <= k-1}的节点{@code zi}和{@code z(i+1)}之间存在一条边.<br>
 *
 * 路径的距离定义为这条路径上所有边的权重总和, 用{@code distanceToLastNode(x)}表示节点{@code n}和{@code x}之间路径的最短距离.<br>
 *
 * 受限路径为满足{@code distanceToLastNode(zi) > distanceToLastNode(zi+1)}的一条路径, 其中{@code 0 <= i <= k-1}.<br>
 *
 * 返回从节点{@code 1}出发到节点{@code n}的受限路径数, 由于数字可能很大, 请返回对{@code 10^9 + 7}取余的结果
 * </p>
 *
 * <p>
 * <p>
 * 示例输出1:<br>
 * 输入: {@code n = 5, edges = [[1, 2, 3], [1, 3, 3], [2, 3, 1], [1, 4, 2], [5, 2, 2], [3, 5, 1], [5, 4, 10]]}<br>
 * 输出: {@code 3}
 * </p>
 *
 * <p>
 * 示例输出2:<br>
 * 输入:
 * {@code n = 7, edges = [[1, 3, 1], [4, 1, 2], [7, 3, 4], [2, 5, 3], [5, 6, 1], [6, 7, 2], [7, 5, 3], [2, 6, 4]]}<br>
 * 输出: {@code 1}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= n <= 2 * 10^4</b></li>
 *     <li><b>n - 1 <= edges.length <= 4 * 10^4</b></li>
 *     <li><b>edges[i].length == 3</b></li>
 *     <li><b>1 <= ui, vi <= n</b></li>
 *     <li><b>ui != vi</b></li>
 *     <li><b>1 <= weighti <= 10^5</b></li>
 *     <li><b>任意两个节点之间至多存在一条边</b></li>
 *     <li><b>任意两个节点之间至少存在一条路径</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ5699 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  图的节点数量
     * @param obj1 边之间的关系
     * @return 受限路径数量
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof Integer && obj1 instanceof int[][]) {
            return countRestrictedPaths((int) obj, (int[][]) obj1);
        }
        return null;
    }

    /**
     * 计算受限路径数量
     *
     * <p>
     * 思路:<br>
     * 首先翻译一下什么是受限路径:<br>
     * 对于图中的某节点{@code n}, 它与其他节点的所有最短路径中, 如果存在某节点{@code i},
     * {@code i}的最短路径大于{@code i + 1}节点的最短路径, 则称{@code i}节点所对应的路径为受限路径<br>
     * 难点有两处:<br>
     * 1. 如果计算最短路径?  通过迪杰斯特拉算法计算最短路径<br>
     * 2. 如何计算受限路径?  计算相邻节点({@code i + 1}节点)的受限路径并相加, 需要递归计算<br>
     *
     * <br>注意:<br>
     * 1. 使用迪杰斯特拉算法的时候需要堆优化<br>
     * 2. 递归需要使用记忆化搜索<br>
     * 3. 无穷大可以使用{@code 0x3f3f3f3f}<br>
     * 否则可能会超时
     * </p>
     *
     * @param n     图的节点数量
     * @param edges 边之间的关系
     * @return 受限路径数量
     */
    public int countRestrictedPaths(int n, int[][] edges) {
        // 创建邻接表
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        // 计算受限路径数量并返回
        return (int) doCountRestrictedPaths(map, 1, n, findShortPathsFromKNode(map, n, n), new Long[n + 1]);
    }

    /**
     * 计算图中某节点{@code k}到另外所有节点的最短距离
     *
     * <b>注意无穷大和{@code visited}数组的使用</b>
     *
     * @param map 邻接表
     * @param n   图的节点总数
     * @param k   要计算的节点的下标
     * @return 所有最短距离
     */
    public int[] findShortPathsFromKNode(Map<Integer, List<int[]>> map, int n, int k) {
        // 图中的节点是从1开始的, 所以数组长度是n + 1
        int[] distances = new int[n + 1];
        // Integer.MAX_VALUE不太行, 在时间上慢了30ms
        // 0x3f3f3f3f是10^9量级的, 可以视为无穷大
        Arrays.fill(distances, 0x3f3f3f3f);

        // 下标0并没有使用, 赋不赋值无所谓
        // 但下标k必须给0, 因为自己到自己的距离肯定是0
        distances[0] = 0;
        distances[k] = 0;

        // 使用堆对算法进行优化
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> distances[o]));
        heap.offer(k);

        // 表示是否当前节点是否计算过最短距离
        boolean[] visited = new boolean[n + 1];

        // 注意一点: !visited[node] 的判断必须要做, 否则超时
        while (!heap.isEmpty()) {
            Integer node = heap.poll();
            if (!visited[node]) {
                visited[node] = true;
                List<int[]> list = map.getOrDefault(node, Collections.emptyList());
                for (int[] arr : list) {
                    if (!visited[arr[0]]) {
                        distances[arr[0]] = Math.min(distances[arr[0]], distances[node] + arr[1]);
                        heap.offer(arr[0]);
                    }
                }
            }
        }

        return distances;
    }

    /**
     * 计算受限路径数量, 使用记忆化搜索做递归查询
     *
     * @param map       邻接表
     * @param i         节点{@code i}
     * @param n         图的节点总数
     * @param distances 最短路径
     * @param count     某节点的受限路径数量
     * @return 受限路径数量
     */
    public long doCountRestrictedPaths(Map<Integer, List<int[]>> map, int i, int n, int[] distances, Long[] count) {
        // 如果这个节点的受限路径已经计算过了, 那么直接返回结果
        if (count[i] != null) {
            return count[i];
        }

        // 如果路径已经到最后一个节点了, 返回1
        if (i == n) {
            return 1;
        }

        long result = 0;
        List<int[]> list = map.getOrDefault(i, Collections.emptyList());

        // 遍历邻接表, 如果最短路径比下一个节点的最短路径大, 需要计算下一个节点的受限路径数量
        for (int[] arr : list) {
            if (distances[i] > distances[arr[0]]) {
                result += doCountRestrictedPaths(map, arr[0], n, distances, count);
                result %= 1000000007;
            }
        }

        // 保存本节点的受限路径数量
        count[i] = result;
        return result;
    }
}
