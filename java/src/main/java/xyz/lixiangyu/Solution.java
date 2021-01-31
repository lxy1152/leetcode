package xyz.lixiangyu;

/**
 * 为了方便测试提供统一接口, 每个题解都需要实现这个接口
 *
 * @author lixiangyu
 */
public interface Solution {
    /**
     * 如果不需要传参, 可以使用这个方法
     *
     * @return 答案
     */
    Object solve();

    /**
     * 如果参数只有一个, 可以使用这个方法
     *
     * @param obj 传入的参数
     * @return 答案
     */
    Object solve(Object obj);

    /**
     * 如果参数有两个, 可以使用这个方法
     *
     * @param obj  传入的参数
     * @param obj1 传入的第二个参数
     * @return 答案
     */
    Object solve(Object obj, Object obj1);

    /**
     * 如果需要传入多个参数, 可以使用这个方法
     *
     * @param objects 要传入的参数
     * @return 答案
     */
    Object solve(Object... objects);
}
