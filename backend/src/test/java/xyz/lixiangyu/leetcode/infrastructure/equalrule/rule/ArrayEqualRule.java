package xyz.lixiangyu.leetcode.infrastructure.equalrule.rule;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组对象比较
 *
 * @author lixiangyu
 */
public class ArrayEqualRule extends AbstractEqualRule {
    @Override
    protected boolean doEquals(Object obj1, Object obj2) {
        if (obj1.getClass().isArray() && obj2.getClass().isArray()) {
            // 包含基本类型数组和包装类数组，如果直接强转为Object[]对基本类型数组
            // 会报错，所以此处判断它们转字符串后的结果是否相同
            return ArrayUtils.toString(obj1).equals(ArrayUtils.toString(obj2));
        }
        return false;
    }

    @Override
    public int order() {
        return 0;
    }
}
