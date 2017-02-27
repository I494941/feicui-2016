package daily.control;

import daily.Welcome;
import daily.pojo.User;
import daily.util.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 王金飞 on 16/10/11.
 */
public class Confirm {

    //获取输入的名字
    private String name;
    //获取user_表中该名字对应的id，即daily_表中对应的create_id
    private int id;


    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {

        return user;
    }

    //验证登录成功与否
    public void confirm() {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String inputName = sc.next();
        name = inputName;

        System.out.println("请输入密码：");
        String inputPassword = sc.next();

        User user = new User(inputName, inputPassword);

        StringBuffer sb = new StringBuffer();

        sb.append(" select * from user_ where name = \"");
        sb.append(user.getName() + "\" and password = \"" + user.getPasswd() + "\"");

        List<Map<String, Object>> list = DBUtils.queryTable(sb.toString());

        //验证成功
        if (!(list.isEmpty())) {

            //登录成功

            //获取user_表id
            Map<String, Object> loginUserMap = list.get(0);
            User loginUser = new User((String)loginUserMap.get("name"), (Integer)loginUserMap.get("id"));
            this.setUser(loginUser);

            System.out.println("登录成功，请选择！");
            new Confirmed().confirmed(loginUser);

        }
        //没有姓名与密码同时匹配的数据
        else {
            //登录失败
            StringBuffer sb1 = new StringBuffer();

            sb1.append(" select * from user_ where name = \"");
            sb1.append(user.getName() + "\"");

            List<Map<String, Object>> list1 = DBUtils.queryTable(sb1.toString());

            if (list1.isEmpty()) {
                //没有与用户名匹配的数据，
                System.out.println("用户名不存在，请先注册。");
                new Welcome().show();
            } else {

                //有与用户名匹配的数据，密码不匹配
                System.out.println("密码错误，请选择：");
                System.out.println("1：重新输入  其他：退出");
                String input = sc.next();

                if (input.equals("1")) {

                    new Confirm().confirm();
                }
            }
        }
    }

    //获取user_表中该名字对应的id，即daily_表中对应的create_id
    public void showID() {

        List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

        StringBuffer sb = new StringBuffer();

        sb.append("select id  from user_ where name = \"");
        sb.append(name + "\"");

        listResult = DBUtils.queryTable(sb.toString());


        //返回id

        for (Map<String, Object> map : listResult) {


            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                id = (int) value;
            }
        }
        user = new User(name, id);

    }
}
