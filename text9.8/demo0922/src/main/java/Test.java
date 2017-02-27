import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 王金飞 on 2016/9/23.
 */
 public class Test {


public static Iterator reverse(List list) {
        Collections.reverse(list);
       return list.iterator();
       }
 public static void main(String[] args) {
     List list = new ArrayList();
      list.add("1"); list.add("2"); list.add("3");
       /* for (Object obj: reverse(list)) {
            System.out.print(obj + ",");
        }*/


       }

}
