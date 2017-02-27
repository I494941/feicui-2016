/**
 * Created by 王金飞 on 2016/9/23.
 */
public class B  extends A {

     public void start() { System.out.println("TestB"); }
     public static void main(String[] args) {
          ((A)new B()).start();
      }


}
