package interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/8 16:32
 */
public class Microsoft {
    /**
     * 微软一面：
     * 写一个将IPv4地址转换为int类型数字的程序，需要考虑各种溢出情况
     */
    public static int ipToInteger(String ipv4Addr) {
        // 判断是否是ip格式的
        if (!isIPAddress(ipv4Addr))
            throw new RuntimeException("Invalid ip address");

        // 匹配数字
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(ipv4Addr);
        int result = 0;
        int counter = 0;
        while (matcher.find()) {
            int value = Integer.parseInt(matcher.group());
            result = (value << 8 * (3 - counter++)) | result;
        }
        return result;
    }

    /**
     * 判断是否为ipv4地址
     */
    private static boolean isIPAddress(String ipv4Addr) {
        String lower = "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])"; // 0-255的数字
        String regex = lower + "(\\." + lower + "){3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipv4Addr);
        return matcher.matches();

    }

    /**
     * 将10进制int数字转换成ipv4地址
     */
    public static String integerToIp(int ip) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        boolean needPoint = false; // 是否需要加入'.'
        for (int i = 0; i < 4; i++) {
            if (needPoint) {
                sb.append('.');
            }
            needPoint = true;
            int offset = 8 * (3 - i);
            num = (ip >> offset) & 0xff;
            sb.append(num);
        }
        return sb.toString();
    }


    /**
     * ip地址转成long型数字
     * 如果默认格式合法，不需要做格式验证，可用如下转换方法：
     * 将IP地址转化成整数的方法如下：
     * 1、通过String的split方法按.分隔得到4个长度的数组
     * 2、通过左移位操作（<<）给每一段的数字加权，第一段的权为2的24次方，第二段的权为2的16次方，第三段的权为2的8次方，最后一段的权为1
     *
     * @param strIp
     * @return
     */
    public static long ipToLong(String strIp) {
        String[] ip = strIp.split("\\.");
        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]);
    }

    /**
     * 将十进制整数形式转换成127.0.0.1形式的ip地址
     * 将整数形式的IP地址转化成字符串的方法如下：
     * 1、将整数值进行右移位操作（>>>），右移24位，右移时高位补0，得到的数字即为第一段IP。
     * 2、通过与操作符（&）将整数值的高8位设为0，再右移16位，得到的数字即为第二段IP。
     * 3、通过与操作符吧整数值的高16位设为0，再右移8位，得到的数字即为第三段IP。
     * 4、通过与操作符吧整数值的高24位设为0，得到的数字即为第四段IP。
     *
     * @param longIp
     * @return
     */
    public static String longToIP(long longIp) {
        StringBuffer sb = new StringBuffer("");
        // 直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        // 将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        // 将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        // 将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }


    /**
     * 实现一个parseInt方法
     * @param num
     * @return
     * @throws Exception
     */
    public static int parseInt(String num) {
        int index = 0;
        int result = 0;
        if (num.startsWith("-")) {
            index++;
        }
        while (index <= num.length() - 1) {
            int n = num.charAt(index);
            if (n <= 57 && n >= 48) {
                result *= 10;
                result += n - 48;
            } else {
                System.err.println("not a integer");
            }
            index++;
        }
        if (num.startsWith("-")) {
            result = -result;
        }
        return result;
    }

    /**
     * 解法二：带上异常处理
     * @param s
     * @return
     * @throws Exception
     */
    public static int parseIntWithException(String s) throws Exception{
        if(s==null) throw new NumberFormatException("null");

        int result = 0;
        int index = 0;

        if (s.startsWith("-")) {
            index++;
        }
        while (index <= s.length() - 1) {
            int n = s.charAt(index);
            if (n <= 57 && n >= 48) {
                result *= 10;
                result += n - 48;
            } else {
                throw new NumberFormatException("not int error");
            }
            index++;
        }
        if (s.startsWith("-")) {
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        // String ip = "202.117.54.110";
        // String ip1 = "0.7.54.110";
        // String ip2 = "256.117.54.110";
        // System.out.println(ipToInteger(ip));
        // System.out.println(ipToInteger(ip1));
        // System.out.println(ipToInteger(ip2));

        String s = "-23456";
        System.out.println(parseInt(s));
        try {
            System.out.println(parseIntWithException(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
