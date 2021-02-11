package xyz.lixiangyu.template.structure;

/**
 * 链表代码模板
 *
 * @author lixiangyu
 */
public class ListNode {
    /**
     * 当前节点保存的数据
     */
    public int val;

    /**
     * 指向下一个节点
     */
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 重写toString, 用于junit测试时比较数据是否相同
     *
     * @return string
     */
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
