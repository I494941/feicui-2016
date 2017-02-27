/**
 * Created by 王金飞 on 2016/9/18.
 */
public class Dog {

    String name;
    int health;
    int intimacy;
    String strain;
    public void print(){
        System.out.println("宠物的自白：");
        System.out.println("我的名字叫"+name+"，我的健康值是"+health+
                    "，我和主人的亲密程度是"+intimacy+"，我的类型是"+strain+"。");
    }
}
