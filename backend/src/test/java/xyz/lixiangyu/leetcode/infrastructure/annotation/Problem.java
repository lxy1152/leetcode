package xyz.lixiangyu.leetcode.infrastructure.annotation;

import xyz.lixiangyu.leetcode.infrastructure.model.solution.Solve;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指定要测试的题解
 *
 * @author lixiangyu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Problem {
    /**
     * 要测试的目标
     *
     * @return 要测试的目标
     */
    Class<? extends Solve> target();
}
