# 正则表达式
================================
*  作用：验证字符串是否与指定规则匹配
*  本质：字符串规则，规则描述
*  正则表达式规则汇总（to be continue....）

   | 规范|描述 |
   | :--------- |:-----------------|
   |\\|表示反斜线（\）字符|
   |\t|表示制表符|
   |\n|表示换行|
   
   | 符号|含义 |示例|解释|匹配输入|
   |:---|:----|:----|:----|:----|
   |[]|可接收的字符列表 |[efgh]|e、f、g、h中的任意1个字符|e、f、g、h |
*  Pattern , Matcher 类的使用
   * 套路用法
     
      import java.util.regex.Matcher;
      import java.util.regex.Pattern;

      /**
       * Created by chenyan on 2016/9/27.
       */
      public class Test5 {

          public static void main(String[] args) {
              // 定义一个正则表达式字符串
              String expression = "(abc)*";

              // 定义一个需要验证的字符串
              String str = "";

              // 套路用法
              Pattern p = Pattern.compile(expression);
              Matcher m = p.matcher(str);

              // 请问 str符合 expression的规则吗？
              boolean bln = m.matches();

              // matches()方法返回true的话，那么就表示str负责expression的规则
              // 反之则不符合
              System.out.println(bln);
          }
      }
      
* 常用正则表达式
  * 验证手机号
  * 验证邮箱
  * 验证身份证号
  * 验证银行卡号
  * 验证日期格式
  * 验证IP地址
  
 * 关于java中Pattern和Matcher类的其余用法
 
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;

  /**
   * Created by chenyan on 2016/9/27.
   */
  public class Test5 {

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
  
 * group()方法的使用
 
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;

   /**
    * Created by chenyan on 2016/9/27.
    */
   public class Test6 {

       public static void main(String[] args) {

           String expression = "A(B(C))D";
           Pattern p = Pattern.compile(expression);
           Matcher m = p.matcher("ABCD");
           System.out.println("matches:" + m.matches());
           System.out.println("groupCount:" + m.groupCount());
           System.out.println("group():" + m.group());
           System.out.println("group(1):" + m.group(1));
           System.out.println("group(2):" + m.group(2));

       }
   }

  

