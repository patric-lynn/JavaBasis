package basic;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/8 23:58
 */
public class regex {
    public static void patternTest() {
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
        String[] splitStrs = pattern.split("123?123*456*456");
        for (int i = 0; i < splitStrs.length; i++) {
            System.out.print(splitStrs[i] + "  ");
        }
        System.out.println();

        // 123 123*456*456
        String[] splitStrs2 = pattern.split("123?123*456*456", 2);
        for (int i = 0; i < splitStrs2.length; i++) {
            System.out.print(splitStrs2[i] + "  ");
        }
        System.out.println();

        Pattern p = Pattern.compile("\\d+");
        String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        for (int i = 0; i < str.length; i++) {
            System.out.printf("str[%d] = %s\n", i, str[i]);
        }
        System.out.println();


        // Pattern.matches用给定的模式对字符串进行一次匹配，（需要全匹配时才返回true）
        System.out.println("Pattern.matches(\"\\\\d+\",\"2223\") is " + Pattern.matches("\\d+", "2223"));
        // 返回false，需要匹配到所有字符串才能返回true，这里aa不能匹配到
        System.out.println("Pattern.matches(\"\\\\d+\", \"2223aa\")is " + Pattern.matches("\\d+", "2223aa"));
        // 返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
        System.out.println("Pattern.matches(\"\\\\d+\",\"22bb23\") is " + Pattern.matches("\\d+", "22bb23"));
    }

    public static void matcherTest() {
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

    /**
     * 一个简单的邮件地址匹配程序
     *
     * @throws Exception
     */
    public static void emailValidation() throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();

            // 检测输入的EMAIL地址是否以非法符号"."或"@"作为起始字符
            Pattern p = Pattern.compile("^@");
            Matcher m = p.matcher(input);
            if (m.lookingAt()) {
                System.out.println("EMAIL地址不能以'@'作为起始字符");
            }

            // 检测是否以"www."为起始
            p = Pattern.compile("^www.");
            m = p.matcher(input);
            if (m.lookingAt()) {
                System.out.println("EMAIL地址不能以'www.'起始");
            }

            // 检测是否包含非法字符
            p = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
            m = p.matcher(input);
            StringBuffer sb = new StringBuffer();
            boolean result = m.find();
            boolean deletedIllegalChars = false;

            while (result) {
                // 如果找到了非法字符那么就设下标记
                deletedIllegalChars = true;
                // 如果里面包含非法字符如冒号双引号等，那么就把他们消去，加到SB里面
                m.appendReplacement(sb, "");
                result = m.find();
            }

            // 此方法从添加位置开始从输入序列读取字符，并将其添加到给定字符串缓冲区。
            // 可以在一次或多次调用 appendReplacement 方法后调用它来复制剩余的输入序列。
            m.appendTail(sb);
            if (deletedIllegalChars) {
                System.out.println("输入的EMAIL地址里包含有冒号、逗号等非法字符，请修改");
                System.out.println("您现在的输入为: " + input);
                System.out.println("修改后合法的地址应类似: " + sb.toString());
            }
        }
        sc.close();
    }

    /**
     * 身份证号验证程序
     */
    public static void idValidation() {
        // 测试是否为合法的身份证号码
        String[] id_cards = {"130681198712092019", "13068119871209201x", "13068119871209201", "123456789012345",
                "12345678901234x", "1234567890123"};

        // 测试是否为合法身份证的正则表达式
        Pattern pattern = Pattern.compile("(\\d{17}[0-9a-zA-Z]|\\d{14}[0-9a-zA-Z])");

        // 用于提取出生日字符串的正则表达式
        Pattern pattern1 = Pattern.compile("\\d{6}(\\d{8}).*");
        // 用于将生日字符串分解为年月日的正则表达式
        Pattern pattern2 = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");

        Matcher matcher = pattern.matcher("");
        for (int i = 0; i < id_cards.length; i++) {
            matcher.reset(id_cards[i]);
            System.out.println(id_cards[i] + " is id cards：" + matcher.matches());

            // 如果它是一个合法的身份证号，提取出出生的年月日
            if (matcher.matches()) {
                Matcher matcher1 = pattern1.matcher(id_cards[i]);
                matcher1.lookingAt();
                String birthday = matcher1.group(1);

                Matcher matcher2 = pattern2.matcher(birthday);
                if (matcher2.find()) {
                    System.out.println("它对应的出生年月日为：" + matcher2.group(1) + "年" + matcher2.group(2) + "月"
                            + matcher2.group(3) + "日");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        patternTest();
        matcherTest();
        emailValidation();
        idValidation();
    }
}
