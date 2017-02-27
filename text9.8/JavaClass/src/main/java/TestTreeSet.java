import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by 王金飞 on 2016/9/28.
 */
public class TestTreeSet {


    public static void main(String[] args) {

        // 创建
        TreeSet<String> list = new TreeSet<String>();

        // 添加
        list.add("b毛泽东");

        list.add("a周恩来");

        list.add("c刘少奇");

        list.add("1");

        list.add("2");

        // list.add("林彪");

        //  修改
        // list.set(0,"林彪");

        // 删除
        // list.remove(0);
        // list.remove("毛泽东");


        // 查询遍历

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

