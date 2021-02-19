package xyz.lixiangyu.template.algorithm;

/**
 * 滑动窗口题目代码模板
 *
 * @author lixiangyu
 */
public class SlidingWindow {
    /**
     * 滑动窗口题目代码模板
     *
     * @param nums 一个数组
     * @param k    一个可能存在的条件限制
     * @return 题目需要的答案
     */
    public int defaultSolveStep(int[] nums, int k) {
        // 数组长度
        int n = nums.length;
        // 左右指针
        int left = 0;
        int right = 0;
        // 用于本题目的一个变量
        // 比如在这个例子中就是保存数字1出现的次数
        int temp = 0;
        // 保存最后的结果
        int result = 0;
        // 右指针右移
        while (right < n) {
            // 对当前窗口中的特殊值的操作
            // 比如统计数字1的个数
            if (nums[right] == 1) {
                temp++;
            }
            // 如果某个条件不符合题意了, 需要一直移动左指针
            while (temp > k) {
                if (nums[left++] == 1) {
                    temp--;
                }
            }
            // 右指针右移
            right++;
            // 保存最大窗口长度
            result = Math.max(result, right - left);
        }
        return result;
    }
}
