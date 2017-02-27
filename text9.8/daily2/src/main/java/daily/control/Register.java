package daily.control;

import daily.pojo.User;
import daily.util.DBUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/10/11.
 */
public class Register {

    //注册
    public void register() {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String inputName = sc.next();

        //验证姓名是否存在，不存在继续注册，存在就不用继续

        StringBuffer sb = new StringBuffer();

        sb.append(" select * from user_ where name = \"");
        sb.append(inputName + "\"");

        List<Map<String, Object>> list = DBUtils.queryTable(sb.toString());

        if (!list.isEmpty()) {

            //用户名已存在，不用再注册，
            System.out.println("用户名已存在，请直接登录！");
        } else {

            //用户名不存在，继续注册，
            boolean bln;
            int inputSex;
            do {
                bln = false;
                System.out.println("请输入性别：（0：女  1：男）");
                inputSex = sc.nextInt();
                if (!(inputSex == 0 || inputSex == 1)) {
                    System.out.println("性别输入错误，请重新输入！");
                    bln = true;
                }
            } while (bln);

            System.out.println("请输入出入年月日(yyyy-MM-dd)");
            String inputBirthday = sc.next();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = null;
            try {
                birthday = sdf.parse(inputBirthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String inputPassword;
            String confirmPasswrod;
            bln = true;
            do {
                System.out.print("请输入注册密码：");
                inputPassword = sc.next();
                System.out.print("请再次输入密码：");
                confirmPasswrod = sc.next();
                if (inputPassword.length() < 6) {

                    System.out.println("密码长度不小于6");
                } else if (!(inputPassword.equals(confirmPasswrod))) {
                    System.out.println("两次输入的密码不同,请重新输入");
                } else {
                    bln = false;
                }
            } while (bln);


            int id = new ShowId().showId("user_") + 1;

            System.out.println("请输入描述:");
            String inputDescription = sc.next();


            User user = new User(inputName, inputSex, birthday, inputPassword, id);

            String date = sdf.format(user.getBirthday());
            String strSql = "insert into user_ (id,name,sex,birthday,password,description)\n" +
                    "values (" + user.getId() + ",'" + user.getName() + "','" +
                    user.getSex() + "','" + date + "','" + user.getPasswd() + "','" + inputDescription + "')";

            DBUtils.modifyTable(strSql);

            System.out.println("注册成功，请登录！");

        }

    }
}
