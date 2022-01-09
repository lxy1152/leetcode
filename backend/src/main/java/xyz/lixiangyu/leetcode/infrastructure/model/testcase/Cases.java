package xyz.lixiangyu.leetcode.infrastructure.model.testcase;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 多用例信息，一次测试包含一个或多个用例
 *
 * @author lixiangyu
 */
@Data
public class Cases {
    /**
     * 保存本次测试的所有用例信息
     */
    private List<Case> cases = new ArrayList<>();

    /**
     * 为本次测试添加用例
     *
     * @param expectedResult 期望的结果
     * @param parameters     参数列表
     */
    public void addCase(Object expectedResult, Object... parameters) {
        cases.add(new Case(expectedResult, parameters));
    }
}

