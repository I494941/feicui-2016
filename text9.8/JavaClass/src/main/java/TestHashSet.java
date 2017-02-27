import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by 王金飞 on 2016/9/28.
 */
public class TestHashSet {


    public static void main(String[] args) {

        // 创建
        HashSet<String> list = new HashSet<String>();

        // 添加
        list.add("毛泽东");

        list.add("周恩来");

        list.add("刘少奇");

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

