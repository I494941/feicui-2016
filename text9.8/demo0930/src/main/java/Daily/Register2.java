package Daily;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/30.
 */
public class Register2 {

   /* public static void register(){

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String inputName = sc.next();

        boolean bln ;
        int inputSex;
        do {
            bln = false;
            System.out.println("请输入性别：");
            System.out.println("0：女");
            System.out.println("1：男");
            inputSex = sc.nextInt();
            if(!(inputSex == 0||inputSex == 1)){
                System.out.println("性别输入错误，请重新输入！");
                bln = true;
            }
        }while(bln);


        System.out.println("请输入出生年月日：");
        System.out.println("例如:2000-01-01");

        String inputBirthday = sc.next();

        String inputPassword;
        bln = true;
        do {
            System.out.print("请输入注册密码：");
            inputPassword = sc.next();
            System.out.print("请再次输入密码：");
            String inputPassword1 = sc.next();
            if ( inputPassword.length() < 6) {

                System.out.println("密码长度不小于6");
            }
            else if(!(inputPassword.equals(inputPassword1))){
                System.out.println("两次输入的密码不同,请重新输入");
            }
            else{
                bln = false;
            }

        }while(bln);




        boolean bln1 = false;
        StringBuffer sb = new StringBuffer();

        sb.append( " select * from user_ where name = \"");
        sb.append( inputName + "\"" );


        List<Map<String,Object>> list = Test.DBUtils.queryUserResult(sb.toString());

        if( list.isEmpty()){
            bln1 = true;
        }



        if(bln1){

        StringBuffer sb1 = new StringBuffer();

        sb1 = new StringBuffer();
        sb1.append(" insert into  user_		");
        sb1.append("	(name,birthday,sex,password)  ");
        sb1.append(" values ( \"");
        sb1.append(inputName +"\","+ inputBirthday + "," + inputSex +"," + inputPassword +")");

       DBUtils.modifyUser(sb1.toString());

            System.out.println("注册成功，请登录！");


        }
        else{
            System.out.println("用户名已存在，请直接登录！");
        }

    }*/
}
