package daily.control;

import daily.pojo.User;
import daily.util.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/10/12.
 */
public class Check {

    // 查看日志
    public void check() {

        List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
        String strSql = "select id,name from daily_";

        listResult = DBUtils.queryTable(strSql);

        //遍历daily_，返回id及name
        System.out.println("日报明细：");
        System.out.println("id      name");
        for (Map<String, Object> map : listResult) {

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                System.out.print(value + "      ");
            }
            System.out.println();
        }

        System.out.println("选择下一步: (1 : 继续     其他 : 退出 )");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input == 1) {

            new Confirm().confirm();
        } else {
            System.exit(-1);
        }
    }


}

