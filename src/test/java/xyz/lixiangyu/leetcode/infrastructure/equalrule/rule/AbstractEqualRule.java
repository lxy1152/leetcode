package xyz.lixiangyu.leetcode.infrastructure.equalrule.rule;

/**
 * @author lixiangyu
 */
public abstract class AbstractEqualRule implements EqualRule, Order, Comparable<Object> {
    @Override
    public boolean equals(Object obj1, Object obj2) {
        return false;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Order) {
            return Integer.compare(this.order(), ((Order) o).order());
        }
        return 1;
    }
}
