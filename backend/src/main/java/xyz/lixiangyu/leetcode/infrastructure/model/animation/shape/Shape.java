package xyz.lixiangyu.leetcode.infrastructure.model.animation.shape;

import lombok.Getter;

/**
 * @author lixiangyu
 */
@Getter
public enum Shape {
    RECT("rect", "矩形");

    String name;

    String description;

    Shape(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
