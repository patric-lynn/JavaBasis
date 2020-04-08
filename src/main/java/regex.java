import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/8 23:58
 */
public class regex {
    public static void patternTest(){
        // 使用Pattern.compile方法编译一个正则表达式，创建一个匹配模式
        Pattern pattern = Pattern.compile("\\?|\\*");


        // pattern()函数返回正则表达式的字符串形式返回\?\*
        String patternStr = pattern.pattern();
        System.out.println(patternStr);
        // flags()返回当前Pattern的匹配flag参数，这里并没有定义
        int flag = pattern.flags();
        System.out.println(flag);


        // split方法对字符串进行分割
        // 123 123 456 456
        String[]splitStrs = pattern.split("123?123*456*456");
        for (int i = 0; i < splitStrs.length; i++) {
            System.out.print(splitStrs[i] + "  ");
        }
        System.out.println();

        // 123 123*456*456
        String[]splitStrs2 = pattern.split("123?123*456*456",2);
        for (int i = 0; i < splitStrs2.length; i++) {
            System.out.print(splitStrs2[i] + "  ");
        }
        System.out.println();

        Pattern p = Pattern.compile("\\d+");
        String[]str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        for (int i = 0; i < str.length; i++) {
            System.out.printf("str[%d] = %s\n",i, str[i]);
        }
        System.out.println();


        // Pattern.matches用给定的模式对字符串进行一次匹配，（需要全匹配时才返回true）
        System.out.println("Pattern.matches(\"\\\\d+\",\"2223\") is " + Pattern.matches("\\d+", "2223"));
        // 返回false，需要匹配到所有字符串才能返回true，这里aa不能匹配到
        System.out.println("Pattern.matches(\"\\\\d+\", \"2223aa\")is " + Pattern.matches("\\d+", "2223aa"));
        // 返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
        System.out.println("Pattern.matches(\"\\\\d+\",\"22bb23\") is " + Pattern.matches("\\d+", "22bb23"));
    }

    public static void matcherTest(){
        Pattern p = Pattern.compile("\\d+");

        // matches()对整个字符串进行匹配
        // 返回false，因为bb不能被\d+匹配，导致整个字符串匹配未成功。
        Matcher m = p.matcher("22bb23");
        System.out.println(m.matches());
        m = p.matcher("2223");
        // 返回true，因为\d+匹配到了整个字符串
        System.out.println(m.matches());

        // lookingAt()对字符串前缀进行匹配
        m = p.matcher("22bb23");
        // 返回true,因为\d+匹配到了前面的22
        System.out.println(m.lookingAt());
        m = p.matcher("aa2223");
        // 返回false,因为\d+不能匹配前面的aa
        System.out.println(m.lookingAt());

        // find()对字符串进行匹配,匹配到的字符串可以在任何位置。
        m = p.matcher("22bb23");
        System.out.println(m.find()); // true
        m = p.matcher("aa2223");
        System.out.println(m.find()); // true
        m = p.matcher("aabb");
        System.out.println(m.find()); // false
        // 当匹配器匹配失败时，使用返回匹配器状态的方法将出错，例如：m.start();

        m = p.matcher("aa2223bb");
        System.out.println(m.find()); // true

        System.out.println(m.start()); // 2
        System.out.println(m.end()); // 6
        System.out.println(m.group()); // 2223

        p = Pattern.compile("([a-z]+)(\\d+)");
        m = p.matcher("aaa2223bb");
        // 匹配aaa2223
        m.find();
        // 返回2,因为有2组
        System.out.println(m.groupCount());
        // 返回0, 返回第一组匹配到的子字符串在字符串中的索引号
        System.out.println(m.start(1));
        // 返回3
        System.out.println(m.start(2));
        // 返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
        System.out.println(m.end(1));
        // 返回2223,返回第二组匹配到的子字符串
        System.out.println(m.group(2));
    }
    public static void main(String[] args) {

    }
}
