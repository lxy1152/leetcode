package xyz.lixiangyu.algorithm.common.other;

import xyz.lixiangyu.AbstractSolution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/employee-importance/">690. 员工的重要性</a>
 *
 * <p>
 * 描述:<br>
 * 给定一个保存员工信息的数据结构, 它包含了员工唯一的{@code id}, 重要度和直系下属的{@code id}<br>
 *
 * 比如, 员工{@code 1}是员工{@code 2}的领导, 员工{@code 2}是员工{@code 3}的领导, 他们相应的重要度为{@code 15}, {@code 10},
 * {@code 5}, 那么员工{@code 1}的数据结构是{@code [1, 15, [2]]}, 员工{@code 2}的数据结构是{@code [2, 10, [3]]},
 * 员工{@code 3}的数据结构是{@code [3, 5, []]}<br>
 *
 * 注意虽然员工{@code 3}也是员工{@code 1}的一个下属, 但是由于他并不是直系下属, 因此没有体现在员工{@code 1}的数据结构中<br>
 *
 * 现在输入一个公司的所有员工信息, 以及单个员工{@code id}, 返回这个员工和他所有下属的重要度之和
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: {@code [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1}<br>
 * 输出: {@code 11}
 * </p>
 * </p>
 *
 * <p>
 * <b>一个员工最多有一个直系领导, 但是可以有多个直系下属</b>
 * <b>员工数量不超过2000</b>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ690 extends AbstractSolution {
    /**
     * 保存员工id和员工的映射关系
     */
    Map<Integer, Employee> map = new HashMap<>();

    /**
     * {@inheritDoc}
     *
     * @param obj  员工列表
     * @param obj1 某个员工的id
     * @return 员工的重要度
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof List && obj1 instanceof Integer) {
            return getImportance((List<Employee>) obj, (int) obj1);
        }
        return null;
    }

    /**
     * 获取指定员工的重要度
     *
     * @param employees 员工列表
     * @param id        员工id
     * @return 员工的重要度
     */
    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id);
    }

    /**
     * dfs搜索某个员工的重要度是多少
     *
     * @param id 员工id
     * @return 这个员工的重要度
     */
    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        // 取下属列表, 递归计算下属的重要度
        for (int subordinate : employee.subordinates) {
            total += dfs(subordinate);
        }
        return total;
    }
}

/**
 * 本题所使用的的数据结构
 *
 * @author lixiangyu
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
