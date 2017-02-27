/**
 * Created by 王金飞 on 2016/9/19.
 */
public class Bus extends Car {
    int site = 5;
    Bus(){
        System.out.println ("载客量是"+site+"人");
    }
    Bus( int site){

       // System.out.println ("载客量是"+site+"人");
        //super();
        setSite(site);

    }

    public static void main(String[] args) {
       // Bus bus = new Bus(20);
        Bus bus2 = new Bus();
        //bus.print();
    }

}
