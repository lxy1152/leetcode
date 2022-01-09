package xyz.lixiangyu.leetcode.infrastructure.model.animation.shape;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixiangyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Rect extends AbstractShape {
    private String shapeName = Shape.RECT.getName();

    private Integer width;

    private Integer height;
}
