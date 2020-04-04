package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * 3. 无重复字符的最长子串
 * 5. 最长回文子串
 * 6. Z 字形变换
 * 10. 正则表达式匹配
 * 14. 最长公共前缀
 * @author Lynn-zd
 * @date Created on 2020/3/16 12:33
 */
class StringRelatedQuestions {
    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return result;
    }




    /**
     * 5. 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 解法一：暴力法,列举所有的子串，判断是否为回文串，保存最长的回文串。
     * @param s
     * @return
     */
    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }
    /**
     * 方法2 中心扩展算法
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }




    /**
     * 6. Z 字形变换
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     *
     * 思路
     * 按照与逐行读取 Z 字形图案相同的顺序访问字符串。
     * 算法
     * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                builder.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    builder.append(s.charAt(j + cycleLen - i));
            }
        }
        return builder.toString();
    }


    /**
     * 10. 正则表达式匹配
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * 说明:
     *
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 示例 1:
     *
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3:
     *
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4:
     *
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     *
     * 解法一：回溯法
     * 如果模式串中有星号，它会出现在第二个位置，即 pattern[1] 。这种情况下，我们可以直接忽略模式串中这一部分
     * 或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即pattern[0]。
     * 如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    /**
     * 解法二：
     * 想法
     *
     * 因为题目拥有 最优子结构 ，一个自然的想法是将中间结果保存起来。我们通过用
     * dp(i,j)
     * dp(i,j) 表示
     * text[i:]
     * text[i:] 和
     * pattern[j:]
     * pattern[j:] 是否能匹配。我们可以用更短的字符串匹配问题来表示原本的问题。
     *
     * 算法
     *
     * 我们用 [方法 1] 中同样的回溯方法，除此之外，因为函数 match(text[i:], pattern[j:]) 只会被调用一次，我们用
     * dp(i, j)
     * dp(i, j) 来应对剩余相同参数的函数调用，这帮助我们节省了字符串建立操作所需要的时间，也让我们可以将中间结果进行保存。
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch2(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }


    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     * 解法一：
     * 当字符串数组长度为 0 时则公共前缀为空，直接返回
     * 令最长公共前缀 ans 的值为第一个字符串，进行初始化
     * 遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
     * 如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
    /**
     * 解法二：多种情况考虑
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String min = strs[0] ;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].isEmpty()) {
                return "";
            }
            if (strs[0].charAt(0) != strs[i].charAt(0)) {
                return "";
            }
            if (strs[i].length() <= min.length()) {
                min = strs[i];
            }
        }
        for (int i = 0; i < strs.length; i++) {
            if (min.equals(strs[i])) {
                continue;
            }
            for (int j = min.length()-1; j > 0 ; j--) {
                if (min.charAt(j) != strs[i].charAt(j)) {
                    min = min.substring(0, j);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}