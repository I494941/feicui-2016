package daily.control;

import daily.Welcome;
import daily.pojo.User;
import daily.util.DBUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/10/12.
 */
public class WriteDaily {

    //写日报
    public void writeDaily(User user) {

        Scanner sc = new Scanner(System.in);

        //写日报
        System.out.println("请输入：");
        System.out.println("should_finished_work:");
        String inputSFW = sc.next();
        System.out.println("have_finished_work:");
        String inputHFW = sc.next();
        System.out.println("unfinished_work_reason:");
        String inputReason = sc.next();
        System.out.println("question_and_answer:");
        String inputQAA = sc.next();
        System.out.println("next_day_plain:");
        String inputNDP = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());

        //获取id
        int inputId = new ShowId().showId("daily_") + 1;

        //获取姓名

        String name = user.getName();
        //获取日期
        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
        String dateD = sdfD.format(new Date());

        //获取create_id

        int inputCID = user.getId();

        StringBuffer sb = new StringBuffer();
        sb.append(" insert into daily_ values ( \"");
        sb.append(inputId + " \",\" ");
        sb.append(name + "-" + dateD + "  日报\",\" ");
        sb.append(date + " \",\" ");
        sb.append(inputCID + " \",\" ");
        sb.append(inputSFW + " \",\" ");
        sb.append(inputHFW + " \",\" ");
        sb.append(inputReason + " \",\" ");
        sb.append(inputQAA + " \",\" ");
        sb.append(inputNDP + "\" ) ");

        //写日报
        DBUtils.modifyTable(sb.toString());

        System.out.println("日报成功存入数据库");
        System.out.println("选择继续或退出 : ( 1 : 继续  2 : 切换用户  其他 : 退出 )");

        int input = sc.nextInt();

        if (input == 1) {

            //继续
            //new Confirmed().confirmed();

        } else if (input == 2) {

            //登录界面
            new Welcome().show();
        } else {
            //退出
            System.exit(-1);
        }
    }

}
