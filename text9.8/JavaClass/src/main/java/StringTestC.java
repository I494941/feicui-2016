/**
 * Created by apple on 16/9/22.
 */
public class StringTestC {
    public static void main(String[] args) {

        String s = "abcdefg";
        char c1;
        int i1,i2,i3,i4,i5,i6,i7,i8,i9;
        boolean bln;
        String s1,s2,s3;
        CharSequence cs = "abcdefg";
        StringBuffer sb = new StringBuffer("abcdefg");
        //char[] ch ;
        char ch[] = {'a','b','c','d','e','f','g'};
        byte bt[];

    /*
    public char charAt(int index)
     返回指定索引处的 char 值。
     索引范围为从 0 到 length() - 1。序列的第一个 char 值位于索引 0 处，第二个位于索引 1 处，
     依此类推，这类似于数组索引。
     */
        c1 = s.charAt(2);
        System.out.println("c1 = " + c1);

    /*
    codePointAt(int index)
    返回指定索引处的字符（Unicode 代码点）。
    */
        i1 = s.codePointAt(2);
        System.out.println("i1 = " + i1);

    /*
    codePointBefore(int index)
    返回指定索引之前的字符（Unicode 代码点）。
    */
        i2 = s.codePointBefore(2);
        System.out.println("i2 = " + i2);

    /*
    codePointCount(int beginIndex, int endIndex)
    返回此 String 的指定文本范围中的 Unicode 代码点数。
    */
        i3 = s.codePointCount(0, 7);
        System.out.println("i3 = " + i3);

    /*
    public int compareTo(String anotherString)
    按字典顺序比较两个字符串。该比较基于字符串中各个字符的 Unicode 值。
    按字典顺序将此 String 对象表示的字符序列与参数字符串所表示的字符序列进行比较。
    如果按字典顺序此 String 对象位于参数字符串之前，则比较结果为一个负整数。
    如果按字典顺序此 String 对象位于参数字符串之后，则比较结果为一个正整数。
    如果这两个字符串相等，则结果为 0；compareTo 只在方法 equals(Object) 返回 true 时才返回 0。
    这是字典排序的定义。
    如果这两个字符串不同，那么它们要么在某个索引处的字符不同（该索引对二者均为有效索引），要么长度不同，或者同时具备这两种情况。
    如果它们在一个或多个索引位置上的字符不同，
    假设 k 是这类索引的最小值；则在位置 k 上具有较小值的那个字符串（使用 < 运算符确定），其字典顺序在其他字符串之前。
    在这种情况下，compareTo 返回这两个字符串在位置 k 处两个char 值的差，即值：
     this.charAt(k)-anotherString.charAt(k)
     如果没有字符不同的索引位置，则较短字符串的字典顺序在较长字符串之前。
     在这种情况下，compareTo 返回这两个字符串长度的差，即值：
     this.length()-anotherString.length()
     */
        i4 = s.compareTo("abcdefg");
        i5 = s.compareTo("abcd");
        i6 = s.compareTo("aBcdefg");

        System.out.println("i4 = " + i4);
        System.out.println("i5 = " + i5);
        System.out.println("i6 = " + i6);

    /*
    public int compareToIgnoreCase(String str)
    按字典顺序比较两个字符串，不考虑大小写。
    此方法返回一个整数，其符号与使用规范化的字符串调用 compareTo 所得符号相同，
    规范化字符串的大小写差异已通过对每个字符调用 Character.toLowerCase(Character.toUpperCase(character)) 消除。
    注意，此方法不 考虑语言环境，因此可能导致在某些语言环境中的排序效果不理想。
    java.text 包提供 Collators 完成与语言环境有关的排序。
    参数：
    str - 要比较的 String。
    返回：
    根据指定 String 大于、等于还是小于此 String（不考虑大小写），分别返回一个负整数、0 或一个正整数。
    */
        i7 = s.compareToIgnoreCase("ABCDEFG");
        i8 = s.compareToIgnoreCase("aBcdefg");
        i9 = s.compareToIgnoreCase("AbCDEFG");

        System.out.println("i7 = " + i7);
        System.out.println("i8 = " + i8);
        System.out.println("i9 = " + i9);


        /*
        public String concat(String str)
        将指定字符串连接到此字符串的结尾。
        如果参数字符串的长度为 0，则返回此 String 对象。
        否则，创建一个新的 String 对象，用来表示由此 String 对象表示的字符序列和参数字符串表示的字符序列连接而成的字符序列。
        示例：
        "cares".concat("s") returns "caress"
        "to".concat("get").concat("her") returns "together"
        */

        s1 = s.concat("h");
        System.out.println("s1 = " + s1);

        /*
        public boolean contains(CharSequence s)
        当且仅当此字符串包含指定的 char 值序列时，返回 true。
        参数：
        s - 要搜索的序列
        返回：
        如果此字符串包含 s，则返回 true，否则返回 false
        */

        bln = s.contains("h");
        System.out.println("bln = " + bln);

        /*
        public boolean contentEquals(CharSequence cs)
        将此字符串与指定的 CharSequence 比较。当且仅当此 String 与指定序列表示相同的 char 值序列时，结果才为 true。
        参数：
        cs - 要与此 String 比较的序列
        返回：
        如果此 String 与指定序列表示相同的 char 值序列，则返回 true；否则返回 false。
        */

        bln = s.contentEquals(cs);
        System.out.println("bln = " + bln);


        /*
        public boolean contentEquals(StringBuffer sb)
        将此字符串与指定的 StringBuffer 比较。当且仅当此 String 与指定 StringBuffer 表示相同的字符序列时，结果才为 true。
        参数：
        sb - 要与此 String 比较的 StringBuffer。
        返回：
        如果此 String 与指定 StringBuffer 表示相同的字符序列，则返回 true；否则返回 false。
        */

        bln = s.contentEquals(sb);
        System.out.println("bln = " + bln);


        /*
        public static String copyValueOf(char[] data)
        返回指定数组中表示该字符序列的 String。
        参数：
        data - 字符数组。
        返回：
        一个 String，它包含字符数组的字符。
        */
        s2 = s.copyValueOf(ch);
        System.out.println("s2 = " + s2);

        /*
        public static String copyValueOf(char[] data,int offset,int count)
        返回指定数组中表示该字符序列的 String。
            参数：
                data - 字符数组。
                offset - 子数组的初始偏移量。
                count - 子数组的长度。
        */
        s3 = s.copyValueOf(ch,2,4);
        System.out.println("s3 = " + s3);

        /*
        public boolean endsWith(String suffix)
        测试此字符串是否以指定的后缀结束。
        参数：
        suffix - 后缀。
        返回：
        如果参数表示的字符序列是此对象表示的字符序列的后缀，则返回 true；否则返回 false。
        注意，如果参数是空字符串，或者等于此 String 对象（用 equals(Object) 方法确定），
        则结果为 true。
        */
        bln = s.endsWith("fg");
        System.out.println("bln = " + bln);
        bln = "fg".endsWith("fg");
        System.out.println("bln = " + bln);

        /*
        public boolean equals(Object anObject)
        将此字符串与指定的对象比较。当且仅当该参数不为 null，
        并且是与此对象表示相同字符序列的 String 对象时，结果才为 true。
            覆盖：
                类 Object 中的 equals
            参数：
                anObject - 与此 String 进行比较的对象。
            返回：
                如果给定对象表示的 String 与此 String 相等，则返回 true；否则返回 false。
        */

        bln = s.equals("abcdefg");
        System.out.println("bln = " + bln);

        /*
        public boolean equalsIgnoreCase(String anotherString)
        将此 String 与另一个 String 比较，不考虑大小写。
        如果两个字符串的长度相同，并且其中的相应字符都相等（忽略大小写），
        则认为这两个字符串是相等的。

        在忽略大小写的情况下，如果下列至少一项为 true，则认为 c1 和 c2 这两个字符相同。

            这两个字符相同（使用 == 运算符进行比较）。
            对每个字符应用方法 Character.toUpperCase(char) 生成相同的结果。
            对每个字符应用方法 Character.toLowerCase(char) 生成相同的结果。
        */

        bln = s.equalsIgnoreCase("ABCDEFG");
        System.out.println("bln = " + bln);

        /*
        public static String format(Locale l,String format,Object... args)
        使用指定的语言环境、格式字符串和参数返回一个格式化字符串。
            参数：
                l - 格式化过程中要应用的语言环境。如果 l 为 null，则不进行本地化。
                format - 格式字符串
                args - 格式字符串中由格式说明符引用的参数。
                如果还有格式说明符以外的参数，则忽略这些额外的参数。
                参数的数目是可变的，可以为 0。
                参数的最大数目受 Java Virtual Machine Specification 所定义的
                Java 数组最大维度的限制。有关 null 参数的行为依赖于转换。
            返回：
                一个格式化字符串
         */

        /*
        public static String format(String format,Object... args)
        使用指定的格式字符串和参数返回一个格式化字符串。
        始终使用 Locale.getDefault() 返回的语言环境。

            参数：
                format - 格式字符串
                args - 格式字符串中由格式说明符引用的参数。如果还有格式说明符以外的参数，则忽略这些额外的参数。参数的数目是可变的，可以为 0。参数的最大数目受 Java Virtual Machine Specification 所定义的 Java 数组最大维度的限制。有关 null 参数的行为依赖于转换。
            返回：
                一个格式化字符串
        */



        /*
        public byte[] getBytes()
        使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
        当此字符串不能使用默认的字符集编码时，此方法的行为没有指定。
        如果需要对编码过程进行更多控制，则应该使用 CharsetEncoder 类。

        返回：
        所得 byte 数组
        */
        bt = s.getBytes();
        System.out.println("bt[0] = "+bt[0]);

        /*
        public byte[] getBytes(Charset charset)
        使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。
        此方法总是使用此字符集的默认替代 byte 数组替代错误输入和不可映射字符序列。
        如果需要对编码过程进行更多控制，则应该使用 CharsetEncoder 类。

        参数：
        charset - 用于编码 String 的 Charset
        返回：
        所得 byte 数组
        */









    }

}
