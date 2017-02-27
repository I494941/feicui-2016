import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/13.
 */
public class Draw {
    public void drawStar(int p_num,String p_$){
        for(int i = 0 ;i <= p_num ;i++){
            for(int j = 0; j < i;j++){
                System.out.print(p_$+" ");
            }
            System.out.println("   ");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入: ");
        int num = input.nextInt();
        System.out.print("请输入符号: ");
        String $ = input.next();
        Draw draw = new Draw();
        draw.drawStar(num,$);
    }
}
