package leetCode;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/8/11 23:35
 */
public class DynamicRelatedQuestionsTest {
    /**
     * 最长回文子串测试
     *
     * @param s
     * @return
     */
    public String longestPalidrome(String s) {
        if (s.equals("")) return "";
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0, maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) {
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public static void main(String[] args) {
        DynamicRelatedQuestionsTest dynamicRelatedQuestionsTest = new DynamicRelatedQuestionsTest();
        System.out.println(dynamicRelatedQuestionsTest.longestPalidrome("abcdce"));
    }
}
