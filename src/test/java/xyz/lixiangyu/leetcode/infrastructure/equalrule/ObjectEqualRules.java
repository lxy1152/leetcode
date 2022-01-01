package xyz.lixiangyu.leetcode.infrastructure.equalrule;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.reflections.Reflections;
import xyz.lixiangyu.leetcode.infrastructure.equalrule.rule.EqualRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 对象相等匹配规则，为了通用传参用的都是Object类，需要
 * 根据不同类型定制它们的相等规则
 *
 * @author lixiangyu
 */
@Slf4j
public class ObjectEqualRules {
    /**
     * 校验规则
     */
    private static List<EqualRule> rules = new ArrayList<>();

    static {
        // 获取所有EqualRule接口的实现类，将它们注册进来
        Set<Class<? extends EqualRule>> implClass = new Reflections().getSubTypesOf(EqualRule.class);
        if (CollectionUtils.isEmpty(implClass)) {
            log.error("没有设置对象相等校验规则");
            throw new IllegalArgumentException("没有设置对象相等校验规则，请检查代码配置");
        }

        Class<?>[] classes = implClass.toArray(new Class[0]);
        for (Class<?> impl : classes) {
            try {
                register((EqualRule) Class.forName(impl.getName()).newInstance());
            } catch (Exception e) {
                log.error("加载对象相等校验规则失败", e);
            }
        }

        if (CollectionUtils.isEmpty(rules)) {
            log.error("没有设置对象相等校验规则");
            throw new IllegalArgumentException("没有设置对象相等校验规则，请检查代码配置");
        }
    }

    /**
     * 注册校验规则
     *
     * @param equalRule 校验规则
     */
    private static void register(EqualRule equalRule) {
        rules.add(equalRule);
    }

    /**
     * 判断已注册的所有校验规则中是否有满足条件的
     *
     * @param obj1 要比较的第一个对象
     * @param obj2 要比较的第二个对象
     * @return 两个对象是否相等
     */
    public static boolean isObjectEqualsByEqualRules(Object obj1, Object obj2) {
        return rules.stream().anyMatch(rule -> rule.equals(obj1, obj2));
    }
}
