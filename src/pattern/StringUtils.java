package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qxiong on 2018/8/15 0015.
 */
public class StringUtils {
//    ip: (2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)
    public static void main(String[] args) {
//        System.out.println(getNonBlankStr("       a \t b \r\n"));
        String regEx = "[`!@#$%^&*()+=|{}':;',//[//].<>/?！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        String s = "123456@qq.com";
        Matcher matcher = Pattern.compile(regEx).matcher(s);
        if (matcher.find()) {
            System.out.println(s+"输入有非法字符:" + matcher.group());
        }
        System.out.println();
        String ipEx = "(2([0-4]\\d|5[0-5])|[01]?\\d\\d?\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";

        Matcher matcher1 = Pattern.compile(ipEx).matcher("257.0.0.1");
        int i = 0;
        System.out.println(matcher1.find());
        while (matcher1.find()){
            System.out.println(matcher1.group(i++));
            if (i>matcher1.groupCount()) break;
        }
    }

    /**
     * 去除所有空格，制表，回车换行符
     *
     * @param str
     * @return
     */
    public static String getNonBlankStr(String str) {
        if (null == str || str.length() == 0)
            return str;
        Pattern pattern = Pattern.compile("\\s+|\t|\r|\n");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }
}
