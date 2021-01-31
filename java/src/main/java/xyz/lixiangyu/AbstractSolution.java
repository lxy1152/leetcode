package xyz.lixiangyu;

/**
 * 抽象题解类, 每个题解都需要继承该抽象类并重写需要的{@code solve}方法
 *
 * @author lixiangyu
 */
public abstract class AbstractSolution implements Solution {
    /**
     * 解决方案
     *
     * @return 答案
     */
    @Override
    public Object solve() {
        return null;
    }

    /**
     * 解决方案
     *
     * <p>需要先判断类型再进行使用</p>
     *
     * @return 答案
     */
    @Override
    public Object solve(Object obj) {
        return null;
    }

    /**
     * 解决方案
     *
     * <p>需要先判断类型再进行使用</p>
     *
     * @return 答案
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        return null;
    }

    /**
     * 解决方案
     *
     * <p>需要先判断类型再进行使用</p>
     *
     * @return 答案
     */
    @Override
    public Object solve(Object... objects) {
        return null;
    }
}
