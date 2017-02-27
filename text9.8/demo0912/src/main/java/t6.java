/**
 * Created by Administrator on 2016/9/13.
 */
public class t6 {
    byte byte_var;
    short short_var;
    int int_var;
    long long_var;
    float float_var;
    double double_var;
    char char_var;
    boolean boolean_var;
    String string_var;
    class class_{
    }

    public static void main(String[] args){
        t6 a = new t6() ;
        //class_ b = new t6.class_();
        System.out.println(a.byte_var);
        System.out.println(a.short_var);
        System.out.println(a.int_var);
        System.out.println(a.float_var);
        System.out.println(a.double_var);
        System.out.println(a.char_var);
        System.out.println(a.boolean_var);
        System.out.println(a.string_var);
        //System.out.println(a.class_);



    }

}
