package xyz.lixiangyu.algorithm.common.other;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link SolutionQ690}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ690Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ690();
    }

    @Override
    public void testSolutionCaseOne() {
        List<Employee> list = new ArrayList<>();

        List<Integer> subordinatesOne = new ArrayList<>();
        subordinatesOne.add(2);
        subordinatesOne.add(3);
        list.add(new Employee(1, 5, subordinatesOne));

        list.add(new Employee(2, 3, new ArrayList<>()));

        list.add(new Employee(3, 3, new ArrayList<>()));

        Assert.assertEquals(11, solution.solve(list, 1));
    }
}
