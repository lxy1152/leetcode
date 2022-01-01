package xyz.lixiangyu.leetcode.infrastructure.model.solution;

import lombok.Getter;

/**
 * @author lixiangyu
 */
@Getter
public enum Tag {
    NO_TAG("没有标签", "没有设置标签"),
    ARRAY("数组", "数组类型的题目"),
    ARRAY_SORT("数组排序", "数组排序类题目"),
    HASHMAP("哈希表", "需要用到哈希表的题目");

    String name;

    String description;

    Tag(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
