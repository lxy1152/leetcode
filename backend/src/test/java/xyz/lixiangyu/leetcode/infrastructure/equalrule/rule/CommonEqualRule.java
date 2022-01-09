package xyz.lixiangyu.leetcode.infrastructure.equalrule.rule;

/**
 * 通用比较方法
 *
 * @author lixiangyu
 */
public class CommonEqualRule extends AbstractEqualRule {
    @Override
    protected boolean doEquals(Object obj1, Object obj2) {
        return obj1.equals(obj2);
    }

    @Override
    public int order() {
        return Integer.MAX_VALUE;
    }
}
