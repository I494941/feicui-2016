import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 王金飞 on 2016/9/28.
 */
public class TestArrayList {


    public static void main(String[] args) {

        // 创建
        List<String> list = new ArrayList<String>();

        // 添加
        list.add("毛泽东");

        list.add("周恩来");

        list.add("刘少奇");

        list.add(2, "朱德");

        // list.add("林彪");

        //  修改
        // list.set(0,"林彪");


        // 删除
        // list.remove(0);
        list.remove("毛泽东");

        // 查询遍历
        for (int index = 0; index < list.size(); index++) {
            String name = list.get(index);
            System.out.println(name);
        }

        System.out.println("*******************************");
        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("*******************************");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);
        }

    }
}


