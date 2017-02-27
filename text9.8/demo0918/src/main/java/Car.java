/**
 * Created by 王金飞 on 2016/9/19.
 */
public class Car {

    private int site= 4 ;  //座位数
    public Car(){

        System.out.println ("载客量是"+site+"人");
    }
    public void setSite(int site){
        this.site = site;
    }
    void print(){
        System.out.print("载客量是"+site+"人");
    }

    public static void main(String[] args) {
        System.out.print("dddd");
    }

}




