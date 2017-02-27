/**
 * Created by Administrator on 2016/9/12.
 */
public class t2 {
    public static void main(String[] args){
        int[] intArray = {1,5,8,4,6,2};
        for(int i = 0;i < intArray.length-1;i++){
            for(int j = 0;j < intArray.length-1;j++){
                if (intArray[j]  > intArray[j+1]){
                    int a = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = a;
                }
                for(int a = 0;a < intArray.length;a++){
                    System.out.print(intArray[a]);

                }
                System.out.println(" ");
            }
        }
        for(int i = 0;i < intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
}
