package xyz.lixiangyu.template.structure;

/**
 * 并查集代码模板
 *
 * <p>
 * 并查集主要用于解决元素分组的问题, 管理一系列不相交的集合<br>
 * 主要涉及两种操作: <br>
 * <ul>
 *     <li><b>合并(union)</b>: 把两个不相交的集合合并成一个集合</li>
 *     <li><b>查询(find)</b>: 查询两个元素是否在同一个集合中</li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 */
public class DisjointSet {
    /**
     * 存储每个节点, 存储的值应该指向代表元素
     */
    private int[] nodes;

    /**
     * 总的集合数量, 随着节点的合并,这个值会逐渐减小
     */
    private int size;

    /**
     * 各个集合中的节点个数
     */
    private int[] countsOfCollection;

    /**
     * 构造方法
     *
     * <p>需要给定一个初始集合数量</p>
     *
     * @param size 集合数量
     */
    public DisjointSet(int size) {
        // 集合数量
        this.size = size;
        // 初始化数组
        // 因为这个时候还没有将节点合并, 所以数量就等于默认的集合数量
        this.nodes = new int[size];
        this.countsOfCollection = new int[size];
        // 对数组赋值, 初始的代表元素就应该是自身, 在合并后代表元素可能不会是自身
        // 初始的节点个数都是1
        for (int i = 0; i < size; i++) {
            nodes[i] = i;
            countsOfCollection[i] = 1;
        }
    }

    /**
     * 获取总的集合数量
     *
     * @return 集合数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断{@code node1}所在的集合与{@code node2}所在的集合是不是相互关联的
     *
     * @param node1 集合一中的某个节点
     * @param node2 集合二中的某个节点
     * @return 是否相互关联
     */
    public boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    /**
     * 找到{@code node}节点所在集合中的代表元素
     *
     * @param node 某一节点
     * @return 所在集合的代表元素
     */
    public int find(int node) {
        // 递归查找集合中的代表元素
        if (node != nodes[node]) {
            nodes[node] = find(nodes[node]);
        }
        // 递归结束条件: 代表元素就是自身
        return nodes[node];
    }

    /**
     * 将{@code node1}所在的集合与{@code node2}所在的集合合并起来
     *
     * @param node1 节点一
     * @param node2 节点二
     */
    public void union(int node1, int node2) {
        // 找到两个节点所在集合的代表元素
        int root1 = find(node1);
        int root2 = find(node2);

        // 如果代表元素相同,即两节点在一个集合内
        // 那么就不需要合并了,直接返回即可
        if (root1 == root2) {
            return;
        }

        /*
         * 如果集合一的节点数量少于集合二的节点数量
         * 那么将节点二作为代表元素, 同时集合一的节点依附到集合二中
         * 反之亦然
         */
        if (countsOfCollection[root1] < countsOfCollection[root2]) {
            nodes[root1] = root2;
            countsOfCollection[root2] += countsOfCollection[root1];
        } else {
            nodes[root2] = root1;
            countsOfCollection[root1] += countsOfCollection[root2];
        }

        // 因为合并了，所以集合数量减少1
        size--;
    }
}
