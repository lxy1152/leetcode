package xyz.lixiangyu.leetcode.infrastructure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 解决方案，使用这个注解标注的方法会被认为是题解
 *
 * @author lixiangyu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Solution {
    /**
     * 该解决方案的名称
     *
     * @return 解决方案名称
     */
    String name() default "";

    /**
     * 是否忽略该解决方案，被忽略的解决方案将不会执行
     *
     * @return 是否忽略该解决方案
     */
    boolean ignored() default false;
}
