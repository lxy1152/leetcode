package xyz.lixiangyu.leetcode.infrastructure.model.animation.frame;

import lombok.Data;

import java.util.List;

/**
 * @author lixiangyu
 */
@Data
public class Frame {
    private String animationType;

    private List<String> vars;

    /**
     * 要执行的时间
     */
    private Integer time;
}
