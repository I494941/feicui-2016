/**
 * Created by 王金飞 on 2016/9/27.
 */
public class TestString {

    public static void main(String[] args) {

        String s = "abcdefg";
        char c1;
        int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16;
        int i17,i18,i19,i20;

        boolean bln;
        String s1, s2, s3, s4, s5;
        CharSequence cs = "abcdefg";
        StringBuffer sb = new StringBuffer("abcdefg");
        //char[] ch ;
        char ch[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        byte bt[];
        char ch1[] = new char[10];
        double d1;

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
        s3 = s.copyValueOf(ch, 2, 4);
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
        System.out.println("bt[0] = " + bt[0]);


        /*
        public byte[] getBytes(Charset charset)
        使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。
        此方法总是使用此字符集的默认替代 byte 数组替代错误输入和不可映射字符序列。如果需要对编码过程进行更多控制，则应该使用 CharsetEncoder 类。

        参数：
        charset - 用于编码 String 的 Charset
        返回：
        所得 byte 数组
        */

        bt = s.getBytes();
        System.out.println("bt[0] = " + bt[0]);

       /*
        public void getBytes(int srcBegin,int srcEnd,byte[] dst,int dstBegin)

        已过时。 该方法无法将字符正确转换为字节。从 JDK 1.1 起，完成该转换的首选方法是通过 getBytes() 方法，该方法使用平台的默认字符集。
        将字符从此字符串复制到目标 byte 数组中。每个 byte 接收相应字符的 8 个低位。不复制每个字符的高位，它们不参与任何方式的转换。
        要复制的第一个字符位于索引 srcBegin 处；要复制的最后一个字符位于索引 srcEnd-1 处。要复制的字符总数为 srcEnd-srcBegin。将转换为 byte 的字符复制到 dst 的子数组中，从索引 dstBegin 处开始，并结束于索引：

        dstbegin + (srcEnd-srcBegin) - 1

        参数：
        srcBegin - 字符串中要复制的第一个字符的索引
        srcEnd - 字符串中要复制的最后一个字符之后的索引
        dst - 目标数组
        dstBegin - 目标数组中的起始偏移量
        */

       /*
        public byte[] getBytes(String charsetName)
                throws UnsupportedEncodingException
        使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
        当此字符串不能使用给定的字符集编码时，此方法的行为没有指定。如果需要对编码过程进行更多控制，则应该使用 CharsetEncoder 类。

        参数：
        charsetName - 受支持的 charset 名称
        返回：
        所得 byte 数组
        */



        /*
        public void getChars(int srcBegin,int srcEnd,char[] dst,int dstBegin)
        将字符从此字符串复制到目标字符数组。
        要复制的第一个字符位于索引 srcBegin 处；
        要复制的最后一个字符位于索引 srcEnd-1 处（因此要复制的字符总数是 srcEnd-srcBegin）。
        要复制到 dst 子数组的字符从索引 dstBegin 处开始，并结束于索引：

        dstbegin + (srcEnd-srcBegin) - 1

            参数：
                srcBegin - 字符串中要复制的第一个字符的索引。
                srcEnd - 字符串中要复制的最后一个字符之后的索引。
                dst - 目标数组。
                dstBegin - 目标数组中的起始偏移量。
        */


        s.getChars(2, 5, ch1, 2);
        System.out.println("ch1[0] = " + ch1[0]);
        System.out.println("ch1[1] = " + ch1[1]);
        System.out.println("ch1[2] = " + ch1[2]);
        System.out.println("ch1[3] = " + ch1[3]);
        System.out.println("ch1[4] = " + ch1[4]);

        /*
        public int hashCode()
        返回此字符串的哈希码。String 对象的哈希码根据以下公式计算：
        s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]

        使用 int 算法，这里 s[i] 是字符串的第 i 个字符，n 是字符串的长度，^ 表示求幂。（空字符串的哈希值为 0。）
        */

        i10 = "ab".hashCode();
        System.out.println("i10 = " + i10);

        /*
        public int indexOf(int ch)
        返回指定字符在此字符串中第一次出现处的索引。
        如果在此 String 对象表示的字符序列中出现值为 ch 的字符，则返回第一次出现该字符的索引（以 Unicode 代码单元表示）。
        对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 的值，返回值
        是this.charAt(k) == ch

        为 true 的最小 k 值。对于其他 ch 值，返回值是
        this.codePointAt(k) == ch

        为 true 最小 k 值。无论哪种情况，如果此字符串中没有这样的字符，则返回 -1。
        参数：
        ch - 一个字符（Unicode 代码点）。
        */

        i11 = s.indexOf(98);
        System.out.println("i11 = " + i11);

        /*
        public int indexOf(int ch,int fromIndex)
        返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
        在此 String 对象表示的字符序列中，如果带有值 ch 的字符的索引不小于 fromIndex，则返回第一次出现该值的索引。对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 值，返回值是

                (this.charAt(k) == ch) && (k >= fromIndex)

        为 true 的最小 k 值。对于其他 ch 值，返回值是
                (this.codePointAt(k) == ch) && (k >= fromIndex)

        为 true 的最小 k 值。无论哪种情况，如果此字符串中 fromIndex 或之后的位置没有这样的字符出现，则返回 -1。
        fromIndex 的值没有限制。如果它为负，则与它为 0 的效果同样：将搜索整个字符串。如果它大于此字符串的长度，则与它等于此字符串长度的效果相同：返回 -1。

        所有索引都在 char 值中指定（Unicode 代码单元）。

        参数：
        ch - 一个字符（Unicode 代码点）。
        fromIndex - 开始搜索的索引。
        */

        i12 = s.indexOf(100, 1);
        System.out.println("i12 = " + i12);
        i12 = s.indexOf(100, 5);
        System.out.println("i12 = " + i12);



        /*
        public int indexOf(String str)
        返回指定子字符串在此字符串中第一次出现处的索引。返回的整数是
        this.startsWith(str, k)

        为 true 的最小 k 值。
        参数：
        str - 任意字符串。
        返回：
        如果字符串参数作为一个子字符串在此对象中出现，则返回第一个这种子字符串的第一个字符的索引；如果它不作为一个子字符串出现，则返回 -1。
        */
        i13 = s.indexOf("de");
        System.out.println("i13 = " + i13);

        /*
        public int indexOf(String str,int fromIndex)
        返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。返回的整数是满足下式的最小 k 值：
        k >= Math.min(fromIndex, this.length()) && this.startsWith(str, k)

        如果不存在这样的 k 值，则返回 -1。
        参数：
        str - 要搜索的子字符串。
        fromIndex - 开始搜索的索引位置。
        返回：
        指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
        */

        i14 = s.indexOf("de", 3);
        System.out.println("i14 = " + i14);


        /*
        public String intern()
        返回字符串对象的规范化表示形式。
        一个初始为空的字符串池，它由类 String 私有地维护。

        当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（用 equals(Object) 方法确定），则返回池中的字符串。否则，将此 String 对象添加到池中，并返回此 String 对象的引用。

        它遵循以下规则：对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true。

        所有字面值字符串和字符串赋值常量表达式都使用 intern 方法进行操作。字符串字面值在 Java Language Specification 的 §3.10.5 定义。

        返回：
        一个字符串，内容与此字符串相同，但一定取自具有唯一字符串的池。
        */

        s4 = s.intern();
        System.out.println("s4 = " + s4);



        /*
        public boolean isEmpty()
        当且仅当 length() 为 0 时返回 true。
        返回：
        如果 length() 为 0，则返回 true；否则返回 false。
        */

        bln = s.isEmpty();
        System.out.println("bln = " + bln);
        bln = "".isEmpty();
        System.out.println("bln = " + bln);
        bln = " ".isEmpty();
        System.out.println("bln = " + bln);

        /*
        public int lastIndexOf(int ch)
        返回指定字符在此字符串中最后一次出现处的索引。对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 的值，
        返回的索引（Unicode 代码单元）是
        this.charAt(k) == ch

        为 true 最大 k 值。对于其他 ch 值，返回值是
        this.codePointAt(k) == ch

        为 true 的最大 k 值。无论哪种情况，如果此字符串中没有这样的字符出现，则返回 -1。从最后一个字符开始反向搜索此 String。
        参数：
        ch - 一个字符（Unicode 代码点）。
        返回：
        在此对象表示的字符序列中最后一次出现该字符的索引；如果未出现该字符，则返回 -1。*/

        i15 = s.lastIndexOf(99);
        System.out.println("i15 = " + i15);

        /*
        public int lastIndexOf(int ch,int fromIndex)
        返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 值，返回的索引是
                (this.charAt(k) == ch) && (k <= fromIndex)

        为 true 的最大 k 值。对于 ch 的其他值，返回值是
                (this.codePointAt(k) == ch) && (k <= fromIndex)

        为 true 的最大 k 值。无论哪种情况，如果此字符串中 fromIndex 或之前的位置没有这样的字符出现，则返回 -1。
        所有的索引都以 char 值指定（Unicode 代码单元）。

        参数：
        ch - 一个字符（Unicode 代码点）。
        fromIndex - 开始搜索的索引。fromIndex 的值没有限制。
        如果它大于等于此字符串的长度，则与它小于此字符串长度减 1 的效果相同：将搜索整个字符串。如果它为负，则与它为 -1 的效果相同：返回 -1。
        返回：
        在此对象表示的字符序列（小于等于 fromIndex）中最后一次出现该字符的索引；如果在该点之前未出现该字符，则返回 -1。
        */

        i16 = "abcdefg".lastIndexOf(99,6);
        System.out.println("i16 = " + i16);

       /*
       public int lastIndexOf(String str)
        返回指定子字符串在此字符串中最右边出现处的索引。
        将最右边的空字符串 "" 视为出现在索引值 this.length() 处。返回的索引是
        this.startsWith(str, k)
        为 true 的最大 k 值。

        参数：
        str - 要搜索的子字符串。
        返回：
        如果字符串参数作为一个子字符串在此对象中出现一次或多次，
        则返回最后一个这种子字符串的第一个字符。如果它不作为一个子字符串出现，则返回 -1。
        */

        i17 = s.lastIndexOf("de");
        System.out.println("i17 = " + i17);

       /*
       public int lastIndexOf(String str,int fromIndex)
        返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。返回的整数是满足下式的最大 k 值：
        k <= Math.min(fromIndex,this.length()) && this.startsWith(str, k)
        如果不存在这样的 k 值，则返回 -1。

        参数：
        str - 要搜索的子字符串。
        fromIndex - 开始搜索的索引位置。
        返回：
        指定子字符串在此字符串中最后一次出现处的索引。
        */

        /*
        public int length()
        返回此字符串的长度。长度等于字符串中 Unicode 代码单元的数量。

        指定者：
        接口 CharSequence 中的 length
        返回：
        此对象表示的字符序列的长度。
        */

        i18 = s.length();
        System.out.println("i18 = " + i18);

        /*
        public boolean matches(String regex)
        告知此字符串是否匹配给定的正则表达式。
        调用此方法的 str.matches(regex) 形式与以下表达式产生的结果完全相同：

        Pattern.matches(regex, str)

        参数：
        regex - 用来匹配此字符串的正则表达式
        返回：
        当且仅当此字符串匹配给定的正则表达式时，返回 true
        抛出：
        PatternSyntaxException - 如果正则表达式的语法无效
        */

        bln = "a".matches("[abcd]");
        System.out.println("bln = " + bln);


        /*
        public int offsetByCodePoints(int index,
        int codePointOffset)
        返回此 String 中从给定的 index 处偏移 codePointOffset 个代码点的索引。
        文本范围内由 index 和 codePointOffset 给定的未配对代理项各计为一个代码点。
        参数：
        index - 要偏移的索引
        codePointOffset - 代码点中的偏移量
        返回：
        String 的索引
        抛出：
        IndexOutOfBoundsException - 如果 index 为负或大于此 String 的长度；
        或者 codePointOffset 为正，且以 index 开头子字符串的代码点比 codePointOffset 少；
        如果 codePointOffset 为负，且 index 前面子字符串的代码点比 codePointOffset 的绝对值少。
        */

        i19 = s.offsetByCodePoints(3,-3);
        System.out.println("i19 = " + i19);

        /*
        public boolean regionMatches(boolean ignoreCase, int toffset, String other,int ooffset, int len)
        测试两个字符串区域是否相等。
        将此 String 对象的子字符串与参数 other 的子字符串进行比较。
        如果这两个子字符串表示相同的字符序列，则结果为 true，当且仅当 ignoreCase 为 true 时忽略大小写。
        要比较的此 String 对象的子字符串从索引 toffset 处开始，长度为 len。要比较的 other 的子字符串从索引 ooffset 处开始，长度为 len。
        当且仅当下列至少一项为 true 时，结果才为 false：

        toffset 为负。
        ooffset 为负。
        toffset+len 大于此 String 对象的长度。
        ooffset+len 大于另一个参数的长度。
        ignoreCase 为 false，且存在某个小于 len 的非负整数 k，即：
        this.charAt(toffset+k) != other.charAt(ooffset+k)

        ignoreCase 为 true，且存在某个小于 len 的非负整数 k，即：
        Character.toLowerCase(this.charAt(toffset+k)) !=
                Character.toLowerCase(other.charAt(ooffset+k))

        以及：
        Character.toUpperCase(this.charAt(toffset+k)) !=
                Character.toUpperCase(other.charAt(ooffset+k))

        参数：
        ignoreCase - 如果为 true，则比较字符时忽略大小写。
        toffset - 此字符串中子区域的起始偏移量。
        other - 字符串参数。
        toffset - 字符串参数中子区域的起始偏移量。
        len - 要比较的字符数。
        返回：
        如果此字符串的指定子区域匹配字符串参数的指定子区域，则返回 true；否则返回 false。是否完全匹配或考虑大小写取决于 ignoreCase 参数。
        */

        bln = s.regionMatches(true,1,"bCdefg",0,6);
        System.out.println("bln = " + bln);


        /*
        public boolean regionMatches(int toffset,String other,int ooffset,int len)
        测试两个字符串区域是否相等。
        将此 String 对象的一个子字符串与参数 other 的一个子字符串进行比较。
        如果这两个子字符串表示相同的字符序列，则结果为 true。要比较的此 String 对象的子字符串从索引 toffset 处开始，长度为 len。
        要比较的 other 的子字符串从索引 ooffset 处开始，长度为 len。当且仅当下列至少一项为 true 时，结果才为 false ：

        toffset 为负。
        ooffset 为负。
        toffset+len 大于此 String 对象的长度。
        ooffset+len 大于另一个参数的长度。
        存在某个小于 len 的非负整数 k，它满足：this.charAt(toffset+k) != other.charAt(ooffset+k)
        参数：
        toffset - 字符串中子区域的起始偏移量。
        other - 字符串参数。
        ooffset - 字符串参数中子区域的起始偏移量。
        len - 要比较的字符数。
        返回：
        如果此字符串的指定子区域完全匹配字符串参数的指定子区域，则返回 true；否则返回 false
        */

        bln = s.regionMatches(1,"bCdefg",0,6);
        System.out.println("bln = " + bln);


        /*
        public String replace(char oldChar,
        char newChar)
        返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
        如果 oldChar 在此 String 对象表示的字符序列中没有出现，则返回对此 String 对象的引用。
        否则，创建一个新的 String 对象，它所表示的字符序列除了所有的 oldChar 都被替换为 newChar 之外，与此 String 对象表示的字符序列相同。

        示例：

        "mesquite in your cellar".replace('e', 'o')
        returns "mosquito in your collar"
        "the war of baronets".replace('r', 'y')
        returns "the way of bayonets"
        "sparring with a purple porpoise".replace('p', 't')
        returns "starring with a turtle tortoise"
        "JonL".replace('q', 'x') returns "JonL" (no change)

        参数：
        oldChar - 原字符。
        newChar - 新字符。
        返回：
        一个从此字符串派生的字符串，它将此字符串中的所有 oldChar 替代为 newChar。
        */


        /*
        public String replace(CharSequence target,
                CharSequence replacement)
        使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
        该替换从字符串的开头朝末尾执行，例如，用 "b" 替换字符串 "aaa" 中的 "aa" 将生成 "ba" 而不是 "ab"。
        参数：
        target - 要被替换的 char 值序列
        replacement - char 值的替换序列
        返回：
        所得 String
        抛出：
        NullPointerException - 如果 target 或 replacement 为 null。
        */

        s5 = s.replace("c","wjf");
        System.out.println("s5 = " + s5);





        /*
        public static String valueOf(double d)
        返回 double 参数的字符串表示形式。
        该表示形式恰好是单参数的 Double.toString 方法返回的结果。

        参数：
        d - 一个 double。
        返回：
        double 参数的字符串表示形式。
        */
        d1 = 10;
        s4 = String.valueOf(d1);
        System.out.println("s4 = " + s4);









    }
}
