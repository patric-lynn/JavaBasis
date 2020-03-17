package jianzhioffer;

public class StringRelatedQuestions {

    //字符串相等测试
    public static void stringTest1() {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
    }

    //字符串连接与更改测试
    public static void stringTest2() {
        String s = "Hello ";
        String s1 = "Hello World";

        //string的连接运算，不算重载，就是直接的字符串相加。
        int n = 5;
        for (int i = 0; i < n; i++) {
            s += "baby ";
            System.out.println(i + "个字符串已生成" + s);
        }

        // 字符串连接 concatenate以及indexof方法
        s1 += "!";
        System.out.println(s1);
        // 2. find
        System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
        System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
        // 3. get substring
        System.out.println(s1.substring(6, 11));

        //测试string的第一种更改方式
        char[] c = s.toCharArray();
        System.out.println(c);
        c[5] = ',';
        System.out.println(c + "不改变原S字符串的值");

        //测试string第二种更改方式 借助stringbuffer或者stringbuilder
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.append("happygirl");
        s = stringBuffer.toString();
        System.out.println(s);
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    //字符串替换测试
    public static String replace() {
        StringBuffer stringBuffer = new StringBuffer("wo men shi zhong guo ren");
        StringBuffer str1 = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i++) {
            char c = stringBuffer.charAt(i);
            if (c == ' ') {
                str1.append("%20");
            } else { //注意此处必须是二选一的形式!!!!!!!!!!!!!!!!!!!!!!!如果没有else子句，则空格也会被加上!!!!!!!!!!!
                str1.append(c);
            }
        }
        return str1.toString();
//        return str.toString().replace(" ", "%20");
    }

}
