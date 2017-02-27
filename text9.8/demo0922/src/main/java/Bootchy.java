/**
 * Created by 王金飞 on 2016/9/23.
 */
public class Bootchy {

        int bootch;
        String snootch;

        public Bootchy() {

            this("snootchy");
            System.out.print("first ");
         }



         public Bootchy(String snootch) {

            this(420, "snootchy");
             System.out.print("second ");
         }

        public Bootchy(int bootch, String snootch) {

            this.bootch = bootch;

            this.snootch = snootch;

         System.out.print("third ");


        }



   public static void main(String[] args) {

 Bootchy b = new Bootchy();

 System.out.print(b.snootch +"  " + b.bootch);



 }



}
