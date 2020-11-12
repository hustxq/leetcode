package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qxiong on 2018/8/15 0015.
 */
public class MatchTest {
    public static void main(String[] args) {
        String s = "123A876";

        String p =
//        ^开始，$结束 获取最后的数字
                "(\\d)([^\\d]*)$";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            int count = matcher.groupCount();
            System.out.println(count);
//            group 0 是整个匹配； 1 是第一组匹配
            for (int i = 0; i <= count; i++) {
                System.out.println(matcher.group(i));
            }
            System.out.println(matcher.group(1));
        }
    }
}
