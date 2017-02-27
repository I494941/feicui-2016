import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/18.
 */
public class Student {

    String stuNo;
    String name;
    int age;

    Student(){
        stuNo = "0000";
        System.out.println(stuNo);
        System.out.println("执行构造方法");
    }

    public static void main(String[] args) {

        Student stu = new Student();
        System.out.println("输入学号：");
        Scanner scanner = new Scanner(System.in);
        String inputNo = scanner.next();
        stu.stuNo = inputNo;
        System.out.println(stu.stuNo);
    }
}
