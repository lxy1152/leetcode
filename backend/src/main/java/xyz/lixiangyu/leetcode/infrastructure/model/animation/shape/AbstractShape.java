package xyz.lixiangyu.leetcode.infrastructure.model.animation.shape;

import lombok.Data;

/**
 * @author lixiangyu
 */
@Data
public abstract class AbstractShape {
    protected String shapeName;

    protected Integer x;

    protected Integer y;

    protected String style;
}
