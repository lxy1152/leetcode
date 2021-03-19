package xyz.lixiangyu.algorithm.common.other;

import xyz.lixiangyu.AbstractSolution;

/**
 * <a href="https://leetcode-cn.com/problems/design-parking-system/">1603. 设计停车系统</a>
 *
 * <p>
 * 描述:<br>
 * 请你给一个停车场设计一个停车系统, 停车场总共有"大中小"三种不同大小的车位, 每种尺寸分别有固定数目的车位<br>
 * 请你实现{@link ParkingSystem}类:<br>
 * 1. {@link ParkingSystem#ParkingSystem(int, int, int)}初始化{@link ParkingSystem}类, 三个参数分别对应每种停车位的数目<br>
 * 2. {@link ParkingSystem#addCar(int)}检查是否有{@code carType}对应的停车位, {@code carType}也分为"大中小"三种类型,
 * 分别用数字{@code 1, 2, 3}表示. 一辆车只能停在{@code carType}对应尺寸的停车位中, 如果没有空车位, 请返回{@code false},
 * 否则将该车停入车位并返回{@code true}
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入: <br>
 * {@code ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]}<br>
 * {@code [[1, 1, 0], [1], [2], [3], [1]]}<br>
 * 输出: {@code [null, true, true, false, false]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>0 <= big, medium, small <= 1000 </b></li>
 *     <li><b>carType 取值为 1, 2, 3 </b></li>
 *     <li><b>最多会调用 addCar 函数 1000 次</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1603 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param objects 每种类型的停车位的数量
     * @return 一个停车场
     */
    @Override
    public Object solve(Object... objects) {
        if (objects[0] instanceof Integer && objects[1] instanceof Integer && objects[2] instanceof Integer) {
            return new ParkingSystem((int) objects[0], (int) objects[1], (int) objects[2]);
        }
        return null;
    }
}

/**
 * 本题使用的数据结构
 */
class ParkingSystem {
    /**
     * 保存每种类型的停车位的数量
     */
    private int[] sizes;

    /**
     * 默认构造器, 初始化一个新的停车场
     *
     * @param big    大停车位的数量
     * @param medium 中停车位的数量
     * @param small  小停车位的数量
     */
    public ParkingSystem(int big, int medium, int small) {
        this.sizes = new int[3];
        sizes[0] = big;
        sizes[1] = medium;
        sizes[2] = small;
    }

    /**
     * 在停车场中停入一辆车, 如果可以停返回{@code true}, 否则返回{@code false}
     *
     * @param carType 车辆的类型
     * @return 能否停入停车场
     */
    public boolean addCar(int carType) {
        if (sizes[carType - 1] > 0) {
            sizes[carType - 1]--;
            return true;
        }
        return false;
    }
}
