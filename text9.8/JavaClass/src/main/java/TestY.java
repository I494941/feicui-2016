import java.util.*;

/**
 * Created by 王金飞 on 2016/9/28.
 */
public class TestY {

    // 模拟 35 选7
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入号码的总个数:");
        int totalCount = scanner.nextInt();
        System.out.print("请输入号开奖号码的总个数:");
        int selectCount = scanner.nextInt();

        System.out.println("本期"+totalCount+"选"+selectCount+"开奖的结果是：");
            TestY t = new TestY();
            String str = t.genNumber(totalCount,selectCount);
        System.out.println(str);

}

    /**

     生成彩票号码
     @param totalCount 号码的总个数
     @param selectCount 开奖号码的总个数

     @return 中奖号码的明细以","隔开 */
    public String genNumber(int totalCount,int selectCount ) {

        Random random = new Random();

        Set set = new TreeSet();

        while (true) { int number = random.nextInt(totalCount);

            if (number ==0) {
                continue;
            }
            set.add(number);

            if (set.size() == selectCount) {
                break;
            }

        }

        Iterator<Integer > it = set.iterator();

        StringBuffer sb = new StringBuffer();

        while (it.hasNext()) {

            int index = it.next();

            sb.append(index+",");
        }

        //sb.deleteCharAt(sb.length()-1);
        String str = sb.substring(0,sb.length()-1);

        return str;
    }
}

