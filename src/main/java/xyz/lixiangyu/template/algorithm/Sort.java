package xyz.lixiangyu.template.algorithm;

/**
 * 排序类算法代码模板
 *
 * @author lixiangyu
 */
public class Sort {
    /**
     * 私有化构造器
     */
    private Sort() {

    }

    /**
     * 对某一个数组通过快速排序算法进行排序, 由于没有给定初始和结束位置,
     * 默认是对整个数组做排序<br>
     * 如果希望指定开始和结束位置, 请使用{@link #doQuickSort}
     *
     * @param nums 要排序的数组
     */
    public static void quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    /**
     * 对某一个数组通过快速排序算法进行排序
     *
     * @param nums  要排序的数组
     * @param left  起始位置
     * @param right 结束位置
     */
    public static void doQuickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i, j, temp, t;
        i = left;
        j = right;
        //temp就是基准位
        temp = nums[left];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= nums[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= nums[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        nums[left] = nums[i];
        nums[i] = temp;
        //递归调用左半数组
        doQuickSort(nums, left, j - 1);
        //递归调用右半数组
        doQuickSort(nums, j + 1, right);
    }
}
