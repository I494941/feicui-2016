/**
 * Created by Administrator on 2016/9/12.
 */
public class t5 {
    public class Students {
        String name;// 姓名
        int age;// 年龄
        String class1;// 班级
        String hobby;// 爱好

        public void show() {
            System.out.println("我叫：" + name + ",年龄：" + age + ",所在班级：" + class1
                    + ",我的爱好是：" + hobby + "。");
        }
    }

    public class teachers {
        String name;
        String majorField;
        String teaching;
        int age;

        public void show() {
            System.out.println(name + "\n" + "专业方向:" + majorField + "\n" + teaching
                    + "\n" + "教龄:" + age);
        }
    }

    public class Cell{
        String brand;
        public void charging(){
            System.out.println("使用"+brand+"为手机续电");
        }
    }

    public class Phone{
        public void music(){
            System.out.println("可以播放音乐");
        }
        public void download(){
            System.out.println("可以下载音乐");
        }
        public void charging(){
            Cell cell = new Cell();
            cell.brand = "锂电池";
            cell.charging();

        }
    }
    public class Doctor{
        String name;
        int room;
        String major;
        public void cure(){

        }
        public void retire(){

        }
    }




    public static void main(String[] args){

    }
}
