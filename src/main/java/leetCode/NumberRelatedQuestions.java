package leetCode;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/24 11:58
 */
public class NumberRelatedQuestions {
    /**
     * 7. 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * <p>
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     * 思路：
     * 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            x /= 10;
            ans = ans * 10 + pop;
        }
        return ans;
    }


    /**
     * 8. 字符串转换整数 (atoi)
     * 说明：
     * <p>
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     * <p>
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     * <p>
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例 5:
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int len = str.length();

        // 去除前导空格
        int index = 0;
        while (index < len) {
            if (str.charAt(index) != ' ') {
                break;
            }
            index++;
        }

        if (index == len) {
            return 0;
        }

        // 第 1 个字符如果是符号，判断合法性，并记录正负
        int sign = 1;
        char firstChar = str.charAt(index);
        if (firstChar == '+') {
            index++;
            sign = 1;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = str.charAt(index);
            // 判断合法性
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }

        return res;
    }

    /**
     * 9. 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
    /**
     * 解法二:
     * 取出后半段数字进行翻转。
     * 这里需要注意的一个点就是由于回文数的位数可奇可偶，所以当它的长度是偶数时，它对折过来应该是相等的；当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数（除以 10 并取整）。
     * 具体做法如下：
     *
     * 每次进行取余操作 （ %10），取出最低的数字：y = x % 10
     * 将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
     * 每取一个最低位数字，x 都要自除以 10
     * 判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
     * 最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     *
     * 解法一:暴力法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    /**
     * 解法二：双指针内移法
     * 最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，我们需要考虑更长的两条线段之间的区域。
     * 如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。
     * 但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
     * 因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int maxarea = 0,l=0,r=height.length-1;
        while(l<r){
            maxarea = Math.max(maxarea,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }
    public static void main(String[] args) {
    }

}
