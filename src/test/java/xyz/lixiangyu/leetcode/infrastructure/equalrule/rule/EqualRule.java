package xyz.lixiangyu.leetcode.infrastructure.equalrule.rule;

/**
 * 对象相等校验规则需要实现该接口
 *
 * @author lixiangyu
 */
public interface EqualRule {
    boolean equals(Object obj1, Object obj2);
}
