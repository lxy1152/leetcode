package xyz.lixiangyu.algorithm.common.other;

import org.junit.Assert;
import xyz.lixiangyu.algorithm.AbstractTest;

/**
 * {@link SolutionQ1603}的测试类
 *
 * @author lixiangyu
 */
public class SolutionQ1603Test extends AbstractTest {
    @Override
    public void beforeTestMethod() {
        super.beforeTestMethod();
        solution = new SolutionQ1603();
    }

    @Override
    public void testSolutionCaseOne() {
        ParkingSystem parkingSystem = (ParkingSystem) solution.solve(1, 1, 0);
        Assert.assertTrue(parkingSystem.addCar(1));
        Assert.assertTrue(parkingSystem.addCar(2));
        Assert.assertFalse(parkingSystem.addCar(3));
        Assert.assertFalse(parkingSystem.addCar(1));
    }
}
