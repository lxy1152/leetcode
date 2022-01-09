package xyz.lixiangyu.leetcode.infrastructure.equalrule.rule;

import java.util.Objects;

/**
 * @author lixiangyu
 */
public abstract class AbstractEqualRule implements EqualRule, Order, Comparable<Object> {
    @Override
    public boolean equals(Object obj1, Object obj2) {
        if (Objects.isNull(obj1) && Objects.isNull(obj2)) {
            return true;
        }
        if (Objects.isNull(obj1) || Objects.isNull(obj2)) {
            return false;
        }

        if (preHandle(obj1, obj2)) {
            return true;
        }
        if (doEquals(obj1, obj2)) {
            return true;
        }
        return postHandle(obj1, obj2);
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

    protected boolean preHandle(Object obj1, Object obj2) {
        return false;
    }

    protected boolean doEquals(Object obj1, Object obj2) {
        return false;
    }

    protected boolean postHandle(Object obj1, Object obj2) {
        return false;
    }
}
