package xyz.lixiangyu.leetcode.infrastructure.model.animation;

import lombok.Data;
import xyz.lixiangyu.leetcode.infrastructure.model.animation.frame.Frame;
import xyz.lixiangyu.leetcode.infrastructure.model.animation.shape.AbstractShape;

import java.util.List;

/**
 * @author lixiangyu
 */
@Data
public class Animation {
    AbstractShape shape;

    List<Frame> frames;
}
