/**
 * Created by 王金飞 on 2016/9/19.
 */
public class Penguin {

    String name;
    int health;
    int intimacy;
    String sex;

    public void Penguin() {
        health=10;
         sex="雄";
        System.out.println("执行构造方法");
    }
    public void print() {
        System.out.println("企鹅的名字是" + name
                + ",健康值是" + health
                + ",性别是" + sex);
    }
    public static void main(String[] args) {
        Penguin pgn3 = new Penguin();
        pgn3.print();

    }


    }
