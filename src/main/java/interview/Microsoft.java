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
     *
     */
    /**
     * 判断是否为ipv4地址
     *
     */
    private static boolean isIPAddress(String ipv4Addr) {
        String lower = "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])"; // 0-255的数字
        String regex = lower + "(\\." + lower + "){3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipv4Addr);
        return matcher.matches();
    }

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
     * 扩展题：
     * 将10进制int数字转换成ipv4地址
     *
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

    public static void main(String[] args) {
        String ip = "202.117.54.110";
        String ip1 = "0.7.54.110";
        String ip2 = "256.117.54.110";
        System.out.println(ipToInteger(ip));
        System.out.println(ipToInteger(ip1));
        System.out.println(ipToInteger(ip2));
    }
}
