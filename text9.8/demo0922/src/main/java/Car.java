/**
 * Created by 王金飞 on 2016/9/23.
 */
public class Car {

    private int wheelCount;
    private String vin;

    public Car(String vin) {
        this.vin = vin;
        this.wheelCount = 4;

    }
     public String drive() {
         return "zoom-zoom";
        }
 public String getInfo() {
         return "VIN: "+ vin + "wheels: "+ wheelCount;
       }

}
