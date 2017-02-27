import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 王金飞 on 2016/9/28.
 */
public class TestZZBDS1 {

    public static void main(String[] args) {
        // 定义一个正则表达式字符串
        String expression = "-?\\d{3}";

        // 定义一个需要验证的字符串
        String str = "-a222222";

        // 套路用法
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(str);

        // 请问 str符合 expression的规则吗？

        // 表示str中的字符串必须完全匹配expression
        boolean bln1 = m.matches();

        // 表示str中从开始位置字符到找到能匹配expression的字符串或者子字符串就可以了
        boolean bln2 =  m.lookingAt();

        // 表示匹配expression成功一次后，是否还有下一个组字符串与expression匹配
        boolean bln3 =  m.find();

        // matches()方法返回true的话，那么就表示str负责expression的规则
        // 反之则不符合
        System.out.println("bln1="+bln1);
        System.out.println("bln2="+bln2);
        System.out.println("bln3="+bln3);
    }
}
