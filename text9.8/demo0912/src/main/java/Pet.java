import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/18.
 */
public class Pet {
    public void dog(String p_name,int p_type1){
        String name = p_name;
        int type1 = p_type1;
        String type2 ;
        if (type1 ==1){
            type2 = "聪明的拉布拉多犬";
        }
        else{
            type2 = "酷酷的雪纳瑞";
        }
        System.out.println("宠物的自白：");
        System.out.println("我的名字叫"+name+"，我的健康值是100，我和主人的亲密度是0，我的类型是"+type2+"。");
    }
    public void penguin(String p_name,int p_type1){
        String name = p_name;
        int type1 = p_type1;
        String type2 ;
        if (type1 == 1){
            type2 = "Q仔";
        }
        else{
            type2 = "Q妹";
        }
        System.out.println("宠物的自白：");
        System.out.println("我的名字叫"+name+"，我的健康值是100，我和主人的亲密度是0，我的性别是"+type2+"。");
    }
    public static void main(String[] args) {
        String name;
        int type;
        int type1;
        System.out.println("欢迎您来到宠物之家！");
        System.out.print("请输入您要领养的宠物的名字：");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        System.out.print("请选择您要领养的宠物的类型：（1.狗狗    2.企鹅）");
        type = scanner.nextInt();
        Pet pet = new Pet();
        if (type == 1){
            System.out.print("请选择您要领养的狗狗的品种：（1.聪明的拉布拉多犬     2.酷酷的雪纳瑞）");
            type1 = scanner.nextInt();
            pet.dog(name,type1);
        }
        else{
            System.out.print("请选择您要领养的企鹅的品种：（1.Q仔     2.Q妹）");
            type1 = scanner.nextInt();
            pet.penguin(name,type1);
        }
    }
}