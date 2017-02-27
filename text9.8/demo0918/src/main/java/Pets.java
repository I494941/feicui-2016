import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/18.
 */
public class Pets {

    public static void main(String[] args) {

        System.out.println("欢迎您来到宠物之家！");
        System.out.print("请输入您要领养的宠物的名字：");

        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.next();

        System.out.print("请选择您要领养的宠物的类型：（1.狗狗    2.企鹅）");
        int inputType = scanner.nextInt();

        if (inputType == 1) {
            Dog dog = new Dog();
            dog.name = inputName;
            System.out.print("请选择您要领养的狗狗的品种：（1.聪明的拉布拉多犬     2.酷酷的雪纳瑞）");
            int inputStrain = scanner.nextInt();
            if (inputStrain == 1) {
                dog.strain = "聪明的拉布拉多犬";
            } else {
                dog.strain = "酷酷的雪纳瑞";
            }
            System.out.print("请输入狗狗的健康值（1到100之间）");
            int inputHealth = scanner.nextInt();
            if ((inputHealth > 0)&&(inputHealth < 100)){
                dog.health = inputHealth;
            }
            else{
                System.out.println("健康值应该在0和100之间，默认值为60。");
                dog.health = 60;
            }

            dog.print();
        }
        else {
            Penguin penguin = new Penguin();
            penguin.name = inputName;
            System.out.print("请选择您要领养的企鹅的性别：（1.Q仔     2.Q妹）");
            int inputSex = scanner.nextInt();
            if (inputSex == 1) {
                penguin.sex = "Q仔";
            } else {
                penguin.sex = "Q妹";
            }
            System.out.print("请输入企鹅的健康值（1到100之间）");
            int inputHealth = scanner.nextInt();
            if ((inputHealth > 0)&&(inputHealth < 100)){
                penguin.health = inputHealth;
            }
            else{
                System.out.println("健康值应该在0和100之间，默认值为60。");
                penguin.health = 60;
            }
            penguin.print();
        }
    }
}
