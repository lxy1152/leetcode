package xyz.lixiangyu.leetcode.infrastructure.annotation;

import xyz.lixiangyu.leetcode.infrastructure.model.solution.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lixiangyu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface ProblemTag {
    /**
     * 标签，参见：{@link Tag}
     *
     * @return 标签列表
     */
    Tag[] tags() default Tag.NO_TAG;
}
