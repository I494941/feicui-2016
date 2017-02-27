import java.io.UnsupportedEncodingException;

/**
 * Created by 王金飞 on 2016/9/22.
 */
public class StringTestG {

    public static void main(String[] args) {

        //String()  初始化一个新创建的 String 对象，使其表示一个空字符序列。
        String s1 = new String();
        String _s1 = new String("a");
        System.out.println("s1 = "+s1);
        System.out.println("_s1 = "+_s1);

		/*
		String(byte[] bytes)
		通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
		新 String 的长度是字符集的函数，因此可能不等于 byte 数组的长度。
		*/
        byte[] bytes = new byte[] {65, 66, 67, 68};
        String s2 = new String(bytes);
        System.out.println("s2 = "+s2);

		/*
		public String(byte[] bytes,Charset charset)
		 通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
		 新 String 的长度是字符集的函数，因此可能不等于 byte 数组的长度。
		 */

        try {
            String s3 = new String(bytes,"UTF-8");
            System.out.println("s3 = "+s3);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //public String(byte[] ascii,int hibyte)   已过时

        /*
        String(byte[] bytes, int offset, int length)
        通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String。
            参数：
                bytes - 要解码为字符的 byte
                offset - 要解码的第一个 byte 的索引
                length - 要解码的 byte 数
        */

        String s4 = new String(bytes,2,2);
        System.out.println("s4 = "+s4);

        /*
        String(byte[] bytes, int offset, int length, Charset charset)
        通过使用指定的 charset 解码指定的 byte 子数组，构造一个新的 String。
        */

        try {
            String s5 = new String(bytes,2,2,"UTF-8");
            System.out.println("s5 = "+s5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*
        String(byte[] ascii, int hibyte, int offset, int count)
        已过时
        */

        /*
        String(byte[] bytes, int offset, int length, String charsetName)
        通过使用指定的字符集解码指定的 byte 子数组，构造一个新的 String。
        */

        try {
            String s6 = new String(bytes,2,2,"UTF-8");
            System.out.println("s6 = "+s6);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*
        String(byte[] bytes, String charsetName)
        通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
        */
        try {
            String s7 = new String(bytes,"UTF-8");
            System.out.println("s7 = "+s7);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*
        public String(char[] value)分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。
        该字符数组的内容已被复制；后续对字符数组的修改不会影响新创建的字符串。
        参数：
        value - 字符串的初始值
        */
        char[] c = new char[]{'a','b','c','d'};
        String s8 = new String(c);
        System.out.println("s8 = "+s8);

        /*
        public String(char[] value,int offset,int count)
        分配一个新的 String，它包含取自字符数组参数一个子数组的字符。
        offset 参数是子数组第一个字符的索引，count 参数指定子数组的长度。
        该子数组的内容已被复制；后续对字符数组的修改不会影响新创建的字符串。
            参数：
                value - 作为字符源的数组。
                offset - 初始偏移量。
                count - 长度。
         */
        String s9 = new String(c,1,2);
        System.out.println("s9 = "+s9);

        /*
        public String(int[] codePoints,int offset,int count)
        分配一个新的 String，它包含 Unicode 代码点数组参数一个子数组的字符。
        offset 参数是该子数组第一个代码点的索引，count 参数指定子数组的长度。
        将该子数组的内容转换为 char；后续对 int 数组的修改不会影响新创建的字符串。
            参数：
                codePoints - 作为 Unicode 代码点的源的数组。
                offset - 初始偏移量。
                count - 长度。
         */
        int[] i = new int[]{65,66,67,68,69,70};
        String s10 = new String(i,1,2);
        System.out.println("s10 = "+s10);

         /*
        public String(String original)
        初始化一个新创建的 String 对象，使其表示一个与参数相同的字符序列；
        换句话说，新创建的字符串是该参数字符串的副本。
        由于 String 是不可变的，所以无需使用此构造方法，除非需要 original 的显式副本。
        */
        String s11 = new String(s8);
        System.out.println("s11 = "+s11);

        /*
        public String(StringBuffer buffer)
        分配一个新的字符串，它包含字符串缓冲区参数中当前包含的字符序列。
        该字符串缓冲区的内容已被复制，后续对它的修改不会影响新创建的字符串。
        参数：
        buffer - 一个 StringBuffer*/
        StringBuffer sb = new StringBuffer("abcdef");
        String s12 = new String(sb);
        System.out.println("s12 = "+s12);

        /*
        public String(StringBuilder builder)
        分配一个新的字符串，它包含字符串生成器参数中当前包含的字符序列。
        该字符串生成器的内容已被复制，后续对它的修改不会影响新创建的字符串。
        提供此构造方法是为了简化到 StringBuilder 的迁移。
        通过 toString 方法从字符串生成器中获取字符串可能运行的更快，因此通常作为首选。
            参数：
                builder - 一个 StringBuilder
         */
        StringBuilder sbd = new StringBuilder("uvwxyz");
        String s13 = new String(sbd);
        System.out.println("s13 = "+s13);

    }
}
