package xyz.lixiangyu.algorithm.common.other;

import xyz.lixiangyu.AbstractSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/">1178. 猜字谜</a>
 *
 * <p>
 * 描述:<br>
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏,请你来猜猜看吧<br>
 * 字谜的迷面{@code puzzle}按字符串形式给出, 如果一个单词{@code word}符合下面两个条件, 那么它就可以算作谜底:
 * <ol>
 *     <li>单词{@code word}中包含谜面{@code puzzle}的第一个字母</li>
 *     <li>单词{@code word}中的每一个字母都可以在谜面{@code puzzle}中找到</li>
 * </ol>
 * 例如, 如果字谜的谜面是{@code "abcdefg"}, 那么可以作为谜底的单词有{@code "faced", "cabbage", "baggage"},
 * 而{@code "beefed"}(不含字母{@code "a"})以及{@code "based"}({@code "s"}没有出现在谜面中)都不能作为谜底<br>
 *
 * 返回一个答案数组{@code answer}, 数组中的每个元素{@code answer[i]}是在给出的单词列表{@code words}中可以作为
 * 字谜迷面{@code puzzles[i]}所对应的谜底的单词数目。
 * </p>
 *
 * <p>
 * <p>
 * 示例输出:<br>
 * 输入:<br>
 * {@code words = ["aaaa", "asas", "able", "ability", "actt", "actor", "access"]}<br>
 * {@code puzzles = ["aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"]}<br>
 * 输出: {@code [1, 1, 3, 2, 4, 0]}
 * </p>
 * </p>
 *
 * <p>
 * <b>注意:</b>
 * <ul>
 *     <li><b>1 <= words.length <= 10^5</b></li>
 *     <li><b>4 <= words[i].length <= 50</b></li>
 *     <li><b>1 <= puzzles.length <= 10^4</b></li>
 *     <li><b>puzzles[i].length == 7</b></li>
 *     <li><b>words[i][j], puzzles[i][j]都是小写英文字母</b></li>
 *     <li><b>每个puzzles[i]所包含的字符都不重复</b></li>
 * </ul>
 * </p>
 *
 * @author lixiangyu
 * @see xyz.lixiangyu.Solution
 * @see AbstractSolution
 */
public class SolutionQ1178 extends AbstractSolution {
    /**
     * {@inheritDoc}
     *
     * @param obj  谜底
     * @param obj1 谜面
     * @return 每个谜面对应的谜底数量
     */
    @Override
    public Object solve(Object obj, Object obj1) {
        if (obj instanceof String[] && obj1 instanceof String[]) {
            return findNumOfValidWords((String[]) obj, (String[]) obj1);
        }
        return null;
    }

    /**
     * 计算每个谜面对应的谜底数量
     *
     * <p>
     * 思路:<br>
     * 1. 本题不需要关注谜底中每个字符出现的次数, 因此将谜底进行状态压缩处理, 保存为二进制数
     * 2. 对谜面及谜面的子集查找谜底的数量并汇总
     * </p>
     *
     * @param words   谜底
     * @param puzzles 谜面
     * @return 每个谜面对应的谜底数量
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // 本题不需要关注谜底中每个字母的出现次数, 只需要统计哪个字母出现过
        // 首先将谜底中的字符串做状态压缩, 用一个二进制数来表示谜底
        // 这样不同的谜底可以用同一个数来表示, 比如: aab和ab的二进制数都是11
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            char[] wordArray = word.toCharArray();
            /*
             * 注意: << 的优先级低于 -
             *
             * 1. ch - 'a': 得到某字符相对于字符a的偏移
             * 2. 1 << ch - 'a':
             *    将数字1左移ch - 'a'位, 这里求的是某个字符对应的二进制数的位置
             *    比如字母d, 是从a开始的第四个字符, 二进制表示是1000, 即十进制的8
             * 3. mask |= 1 << ch - 'a': 将二进制数mask的某位置为1, 表示某个字母出现过
             */
            for (char ch : wordArray) {
                mask |= 1 << ch - 'a';
            }
            // 因为谜面最长只有7位, 并且各个字符都不相同
            // 所以二进制中1的个数多于7个的数一定不是谜底
            if (Integer.bitCount(mask) <= 7) {
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        // 计算谜面对应的谜底个数
        for (String puzzle : puzzles) {
            // 本谜面对应的谜底个数
            int total = 0;

            // 计算谜面进行状态压缩后的二进制数字
            int mask = 0;
            char[] puzzleArray = puzzle.toCharArray();
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzleArray[i] - 'a'));
            }

            // 枚举二进制子集
            int subset = mask;
            do {
                // 子集需要包含谜面的首个字符
                int s = subset | (1 << (puzzleArray[0] - 'a'));
                // 如果存在谜底, 则加上谜底的个数
                if (map.containsKey(s)) {
                    total += map.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            // 枚举二进制子集通用模板
            // int subset = mask;
            // while (subset != 0) {
            //     subset = (subset - 1) & mask;
            //     // do something
            // }

            // 但是这道题不能直接使用这个模板, 因为字符需要加上谜面中的第一个字符, 即subset = 0同样是符合题意的条件
            // 而(0 - 1) & mask = mask > 0, 会造成死循环
            // 上面的do-while循环可以修改为这样:
            //
            // while (true) {
            //     // 子集需要包含谜面的首个字符
            //     int s = subset | (1 << (puzzleArray[0] - 'a'));
            //     // 如果存在谜底, 则加上谜底的个数
            //     if (map.containsKey(s)) {
            //         total += map.get(s);
            //     }
            //     if (subset - 1 < 0) {
            //         break;
            //     }
            //     subset = (subset - 1) & mask;
            // }

            result.add(total);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(5));
    }
}
