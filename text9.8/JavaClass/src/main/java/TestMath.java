/**
 * Created by 王金飞 on 2016/9/27.
 */
public class TestMath {

    public static  void main(String[] args) {
        double d1 = -1;
        double d2, d3, d4, d5, d6, d7, d8, d9, d10;
        double d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21;

        int i1, i2, i3, i4;
        float f1, f2, f3, f4;
        long l1, l2, l3, l4, l5, l6, l7;


        /*   返回绝对值 (int,double,float.long)
        public static double abs(double a)
        返回 double 值的绝对值。如果参数为非负数，则返回该参数。如果参数为负数，则返回该参数的相反数。特殊情况如下：
        如果参数为正 0 或负 0，那么结果为正 0。
        如果参数为无穷大，那么结果为正无穷大。
        如果参数为 NaN，那么结果为 NaN。
        换句话说，结果等于以下表达式的值：
        Double.longBitsToDouble((Double.doubleToLongBits(a)<<1)>>>1)

        参数：
        a - 要确定绝对值的参数。
        返回：
        参数的绝对值。
        */

        d1 = Math.abs(d1);
        System.out.println("d1 = " + d1);

        /*
        public static double acos(double a)
        返回一个值的反余弦；返回的角度范围在 0.0 到 pi 之间。特殊情况如下：
        如果参数为 NaN 或它的绝对值大于 1，那么结果为 NaN。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - 要返回其反余弦的值。
        返回：
        参数的反余弦。
        */

        d2 = Math.acos(1);
        System.out.println("d2 = " + d2);

        /*
        public static double asin(double a)
        返回一个值的反正弦；返回的角度范围在 -pi/2 到 pi/2 之间。特殊情况如下：
        如果参数为 NaN 或它的绝对值大于 1，那么结果为 NaN。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - 要返回其反正弦的值。
        返回：
        参数的反正弦。
        */

        d3 = Math.asin(1);
        System.out.println("d3 = " + d3);

       /*
        public static double atan(double a)
        返回一个值的反正切；返回的角度范围在 -pi/2 到 pi/2 之间。特殊情况如下：
        如果参数为 NaN，那么结果为 NaN。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - 要返回其反正切的值。
        返回：
        参数的反正切。
        */

        /*
        public static double atan2(double y,double x)
        将矩形坐标 (x, y) 转换成极坐标 (r, theta)，返回所得角 theta。该方法通过计算 y/x 的反正切值来计算相角 theta，范围为从 -pi 到 pi。特殊情况如下：
        如果任一参数为 NaN，那么结果为 NaN。
        如果第一个参数为正 0，第二个参数为正数；或者第一个参数为正的有限值，第二个参数为正无穷大，那么结果为正 0。
        如果第一个参数为负 0，第二个参数为正数；或者第一个参数为负的有限值，第二个参数为正无穷大，那么结果为负 0。
        如果第一个参数为正 0，第二个参数为负数；或者第一个参数为正的有限值，第二个参数为负无穷大，那么结果为最接近 pi 的 double 值。
        如果第一个参数为负 0，第二个参数为负数；或者第一个参数为负的有限值，第二个参数为负无穷大，那么结果为最接近 pi 的 double 值。
        如果第一个参数为正数，第二个参数为正 0 或负 0；或者第一个参数为正无穷大，第二个参数为有限值，那么结果为最接近 pi/2 的 double 值。
        如果第一个参数为负数，第二个参数为正 0 或负 0；或者第一个参数为负无穷大，第二个参数为有限值，那么结果为最接近 -pi/2 的 double 值。
        如果两个参数都为正无穷大，那么结果为最接近 pi/4 的 double 值。
        如果第一个参数为正无穷大，第二个参数为负无穷大，那么结果为最接近 3*pi/4 的 double 值。
        如果第一个参数为负无穷大，第二个参数为正无穷大，那么结果为最接近 -pi/4 的 double 值。
        如果两个参数都为负无穷大，那么结果为最接近 -3*pi/4 的 double 值。
        计算结果必须在准确结果的 2 ulp 范围内。结果必须具有半单调性。

        参数：
        y - 纵坐标
        x - 横坐标
        返回：
        与笛卡儿坐标中点 (x, y) 对应的极坐标中点 (r, theta) 的 theta 组件。
        */


        /*
        public static double cbrt(double a)
        返回 double 值的立方根。对于正的有限值 x，cbrt(-x) == -cbrt(x)；也就是说，负值的立方根是该值数值的负立方根。特殊情况如下：
        如果参数为 NaN，那么结果为 NaN。
        如果参数为无穷大，那么结果为无穷大，符号与参数符号相同。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        计算结果必须在准确结果的 1 ulp 范围内。

        参数：
        a - 一个值。
        返回：
        a 的立方根。
        */

        d4 = Math.cbrt(8);
        System.out.println("d4 = " + d4);

        /*
        public static double ceil(double a)
        返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数。特殊情况如下：
        如果参数值已经等于某个整数，那么结果与该参数相同。
        如果参数为 NaN、无穷大、正 0 或负 0，那么结果与参数相同。
        如果参数值小于 0，但是大于 -1.0，那么结果为负 0。
        注意，Math.ceil(x) 的值与 -Math.floor(-x) 的值完全相同。
        参数：
        a - 一个值。
        返回：
        最小（最接近负无穷大）浮点值，该值大于等于该参数，并等于某个整数。
        */

        d5 = Math.ceil(8.5);
        System.out.println("d5 = " + d5);

        /*
        public static double copySign(double magnitude,double sign)
        返回带有第二个浮点参数符号的第一个浮点参数。注意，与 StrictMath.copySign 方法不同，
        此方法不要求将 NaN sign 参数视为正值；允许实现将某些 NaN 参数视为正，将另一些视为负，以获得更好的性能。
        参数：
        magnitude - 提供结果数值的参数
        sign - 提供结果符号的参数
        返回：
        一个值，带有 magnitude 的数值，sign 的符号。
        */

        d6 = Math.copySign(8, -1);
        System.out.println("d6 = " + d6);

        /*
        public static float copySign(float magnitude,
        float sign)
        返回带有第二个浮点参数符号的第一个浮点参数。注意，与 StrictMath.copySign 方法不同，此方法不要求将 NaN sign 参数视为正值；允许实现将某些 NaN 参数视为正，将另一些视为负，以获得更好的性能。
        参数：
        magnitude - 提供结果数值的参数
        sign - 提供结果符号的参数
        返回：
        一个值，带有 magnitude 的数值，sign 的符号。
        */

        /*
        public static double cos(double a)
        返回角的三角余弦。特殊情况如下：
        如果参数为 NaN 或无穷大，那么结果为 NaN。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - 以弧度表示的角。
        */

        /*
        public static double cosh(double x)
        返回 double 值的双曲线余弦。x 的双曲线余弦的定义是 (ex + e-x)/2，其中 e 是欧拉数。
        特殊情况如下：

        如果参数为 NaN，那么结果为 NaN。
        如果参数为无穷大，那么结果为正无穷大。
        如果参数为 0，那么结果为 1.0。
        计算结果必须在准确结果的 2.5 ulp 范围内。

        参数：
        x - 要返回其双曲线余弦的数字。
        返回：
        x 的双曲线余弦。
        */

        /*
        public static double exp(double a)
        返回欧拉数 e 的 double 次幂的值。特殊情况如下：
        如果参数为 NaN，那么结果为 NaN。
        如果参数为正无穷大，那么结果为正无穷大。
        如果参数为负无穷大，那么结果为正 0。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - e 的指数。
        返回：
        值 ea，其中 e 是自然对数的底数。
        */

        d7 = Math.exp(3);
        System.out.println("d7 = " + d7);

        /*
        public static double expm1(double x)
        返回 ex -1。注意，对于接近 0 的 x 值，expm1(x) + 1 的准确和比 exp(x) 更接近 ex 的真实结果。
        特殊情况如下：

        如果参数为 NaN，那么结果为 NaN。
        如果参数为正无穷大，那么结果为正无穷大。
        如果参数为负无穷大，那么结果为 -1.0。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。
        任何有限输入值的 expm1 的结果一定大于或等于 -1.0。注意，一旦 ex - 1 的准确结果在极限值 -1 的 1/2 ulp 范围内，则应该返回 -1.0。

        参数：
        x - 在 ex -1 的计算中 e 的指数。
        返回：
        值 ex - 1。
        */

        d8 = Math.expm1(3);
        System.out.println("d8 = " + d8);

        /*
        public static double floor(double a)
        返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。特殊情况如下：
        如果参数值已经等于某个整数，那么结果与该参数相同。
        如果参数为 NaN、无穷大、正 0 或负 0，那么结果与参数相同。
        参数：
        a - 一个值。
        返回：
        最大（最接近正无穷大）浮点值，该值小于等于该参数，并等于某个整数。
        */

        d9 = Math.floor(3.5);
        System.out.println("d9 = " + d9);

        /*
        public static int getExponent(double d)
        返回 double 表示形式中使用的无偏指数。特殊情况如下：
        如果参数为 NaN 或无穷大，那么结果为 Double.MAX_EXPONENT + 1。
        如果参数为 0 或 subnormal，那么结果为 Double.MIN_EXPONENT -1。
        参数：
        d - double 值
        返回：
        参数的无偏指数
        */

        d10 = 8;
        i1 = Math.getExponent(d10);
        System.out.println("i1 = " + i1);

        /*
        public static int getExponent(float f)
        返回 float 表示形式中使用的无偏指数。特殊情况如下：
        如果参数为 NaN 或无穷大，那么结果为 Float.MAX_EXPONENT + 1。
        如果参数为 0 或 subnormal，那么结果为 Float.MIN_EXPONENT -1。
        参数：
        f - 一个 float 值
        返回：
        参数的无偏指数
        */

        f1 = 8;
        i2 = Math.getExponent(f1);
        System.out.println("i2 = " + i2);

        /*
        public static double hypot(double x,double y)
        返回 sqrt(x2 +y2)，没有中间溢出或下溢。
        特殊情况如下：

        如果两个参数都为无穷大，那么结果为正无穷大。
        如果两个参数都为 NaN 且都不是无穷大，那么结果为 NaN。
        计算结果必须在准确结果的 1 ulp 范围内。如果一个参数保持常量，那么在另一个参数中，结果必须具有半单调性。

        参数：
        x - 一个值
        y - 一个值
        返回：
        没有中间溢出或下溢的 sqrt(x2 +y2)
        */

        d11 = Math.hypot(3, 4);
        System.out.println("d11 = " + d11);

        /*
        public static double IEEEremainder(double f1,double f2)
        按照 IEEE 754 标准的规定，对两个参数进行余数运算。余数的算术值等于 f1 - f2 × n，
        其中 n 是最接近商 f1/f2 准确算术值的整数，如果两个整数都同样接近 f1/f2，那么 n 是其中的偶数。
        如果余数是 0，那么它的符号与第一个参数的符号相同。特殊情况如下：
        如果两个参数都为 NaN，或者第一个参数为无穷大，或者第二个参数为正 0 或负 0，那么结果为 NaN。
        如果第一个参数为有限值，第二个参数为无穷大，那么结果与第一个参数相同。
        参数：
        f1 - 被除数。
        f2 - 除数。
        返回：
        f1 除以 f2 的余数。
        */

        d12 = Math.IEEEremainder(5, 2);
        System.out.println("d12 = " + d12);

        /*
        public static double log(double a)
        返回 double 值的自然对数（底数是 e）。特殊情况如下：
        如果参数为 NaN 或小于 0，那么结果为 NaN。
        如果参数为正无穷大，那么结果为正无穷大。
        如果参数为正 0 或负 0，那么结果为负无穷大。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - 一个值
        返回：
        ln a 的值，即 a 的自然对数。
        */

        /*
        public static double log10(double a)
        返回 double 值的底数为 10 的对数。特殊情况如下：
        如果参数为 NaN 或小于 0，那么结果为 NaN。
        如果参数为正无穷大，那么结果为正无穷大。
        如果参数为正 0 或负 0，那么结果为负无穷大。
        如果参数等于 10 n（n 为整数），那么结果为 n。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - 一个值
        返回：
        a 的底数为 10 的对数。
        */


        /*
        public static double log1p(double x)
        返回参数与 1 之和的自然对数。注意，对于小的 x 值，log1p(x) 的结果比 log(1.0+x) 的浮点计算结果更接近 ln(1 + x) 的实际结果。
        特殊情况如下：

        如果参数为 NaN 或小于 -1，那么结果为 NaN。
        如果参数为正无穷大，那么结果为正无穷大。
        如果参数为负数，那么结果为负无穷大。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        x - 一个值
        返回：
        值 ln(x + 1)，即 x + 1 的自然对数
        */

        /*  返回较大值 (int,double,float.long)
        public static double max(double a,double b)
        返回两个 double 值中较大的一个。也就是说，结果为更接近正无穷大的参数。
        如果参数值相同，那么结果也是同一个值。如果任一值为 NaN，那么结果为 NaN。
        与数值比较运算不同，该方法认为负 0 严格小于正 0。如果一个参数为正 0，另一个参数为负 0，那么结果为正 0。
        参数：
        a - 参数。
        b - 另一个参数。
        返回：
        a 和 b 中的较大者。
        */

        d13 = Math.max(5, 2);
        System.out.println("d13 = " + d13);

        /*  返回较小值 (int,double,float.long)
        public static double min(double a,double b)
        返回两个 double 值中较小的一个。也就是说，结果为更接近负无穷大的值。
        如果参数值相同，那么结果也是同一个值。如果任一值为 NaN，那么结果为 NaN。
        与数值比较运算不同，该方法认为负 0 严格小于正 0。如果一个参数为正 0，另一个参数为负 0，那么结果为负 0。
        参数：
        a - 参数。
        b - 另一个参数。
        返回：
        a 和 b 中的较小者。
        */

        d14 = Math.min(5, 2);
        System.out.println("d14 = " + d14);

        /*  (double,float)
        public static double nextAfter(double start,double direction)
        返回第一个参数和第二个参数之间与第一个参数相邻的浮点数。如果两个参数比较起来相等，则返回第二个参数。
        特殊情况如下：

        如果任一参数为 NaN，则返回 NaN。
        如果两个参数都为有符号的 0，则不做更改地返回 direction（根据要求，如果参数比较起来相等，将返回第二个参数）。
        如果 start 为 ±Double.MIN_VALUE，而 direction 的值要求结果为一个比 start 小的数值，那么将返回 0，并带有与 start 相同的符号。
        如果 start 为无穷大，而 direction 的值要求结果为一个比 start 小的数值，则返回 Double.MAX_VALUE，并带有与 start 相同的符号。
        如果 start 等于 ±Double.MAX_VALUE，而 direction 的值要求结果为一个比 start 大的数值，则返回无穷大，并带有与 start 相同的符号。
        参数：
        start - 起始浮点值。
        direction - 一个值，指示应返回 start 的某个邻数还是 start。
        返回：
        start 和 direction 之间与 start 相邻的浮点数。
        */

        d15 = Math.nextAfter(5, 2);
        System.out.println("d15 = " + d15);


        /*
        public static double nextUp(double d)
        返回 d 和正无穷大之间与 d 相邻的浮点值。此方法在语义上等同于 nextAfter(d, Double.POSITIVE_INFINITY)；
        但是，nextUp 实现的返回速度可能比其等价 nextAfter 调用快。
        特殊情况如下：

        如果参数为 NaN，那么结果为 NaN。
        如果参数为正无穷大，那么结果为正无穷大。
        如果参数为 0，那么结果为 Double.MIN_VALUE。
        参数：
        d - 起始浮点值。
        返回：
        离正无穷大较近的相邻浮点值。
        */

        d16 = Math.nextUp(5);
        System.out.println("d16 = " + d16);

        /*
        public static double pow(double a,double b)
        返回第一个参数的第二个参数次幂的值。
        参数：
        a - 底数。
        b - 指数。
        返回：
        值 ab。
        */

        d17 = Math.pow(5, 2);
        System.out.println("d17 = " + d17);

        /*
        public static double random()
        返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。返回值是一个伪随机选择的数，在该范围内（近似）均匀分布。
        第一次调用该方法时，它将创建一个新的伪随机数生成器，与以下表达式完全相同

        new java.util.Random
        之后，新的伪随机数生成器可用于此方法的所有调用，但不能用于其他地方。
        此方法是完全同步的，可允许多个线程使用而不出现错误。
        但是，如果许多线程需要以极高的速率生成伪随机数，那么这可能会减少每个线程对拥有自己伪随机数生成器的争用。

        返回：
        大于等于 0.0 且小于 1.0 的伪随机 double 值。
        */

        d18 = Math.random();
        System.out.println("d18 = " + d18);

        /*
        public static double rint(double a)
        返回最接近参数并等于某一整数的 double 值。如果两个同为整数的 double 值都同样接近，那么结果取偶数。特殊情况如下：
        如果参数值已经是整数，那么结果与参数相同。
        如果参数为 NaN、无穷大、正 0 或负 0，那么结果与参数相同。
        参数：
        a - double 值。
        返回：
        最接近 a 的整数浮点值。
        */

        /*
        public static long round(double a)
        返回最接近参数的 long。结果将舍入为整数：加上 1/2，对结果调用 floor 并将所得结果强制转换为 long 类型。换句话说，结果等于以下表达式的值：
        (long)Math.floor(a + 0.5d)
        特殊情况如下：

        如果参数为 NaN，那么结果为 0。
        如果结果为负无穷大或任何小于等于 Long.MIN_VALUE 的值，那么结果等于 Long.MIN_VALUE 的值。
        如果参数为正无穷大或任何大于等于 Long.MAX_VALUE 的值，那么结果等于 Long.MAX_VALUE 的值。
        参数：
        a - 舍入为 long 的浮点值。
        返回：
        舍入为最接近的 long 值的参数值。
        */

        l1 = Math.round(2.6);
        System.out.println("dl1 = " + l1);

        /*public static int round(float a)
        返回最接近参数的 int。结果将舍入为整数：加上 1/2，对结果调用 floor 并将所得结果强制转换为 int 类型。换句话说，结果等于以下表达式的值：
        (int)Math.floor(a + 0.5f)
        特殊情况如下：

        如果参数为 NaN，那么结果为 0。
        如果结果为负无穷大或任何小于等于 Integer.MIN_VALUE 的值，那么结果等于 Integer.MIN_VALUE 的值。
        如果参数为正无穷大或任何大于等于 Integer.MAX_VALUE 的值，那么结果等于 Integer.MAX_VALUE 的值。
        参数：
        a - 要舍入为整数的浮点值。
        返回：
        舍入为最接近的 int 值的参数值。*/

        /*
        public static double scalb(double d,int scaleFactor)
        返回 d × 2scaleFactor，其舍入方式如同将一个正确舍入的浮点值乘以 double 值集合中的一个值。
        有关浮点值集合的讨论，请参阅 Java 语言规范。
        如果结果的指数在 Double.MIN_EXPONENT 和 Double.MAX_EXPONENT 之间，则可以正确地计算答案；
        如果结果的指数大于 Double.MAX_EXPONENT，则返回无穷大。注意，如果结果为 subnormal，则可能丢失精度；
        也就是说，scalb(x, n) 为 subnormal 时，scalb(scalb(x, n), -n) 可能不等于 x。结果为非 NaN 时，结果的符号将与 d 相同。
        特殊情况如下：

        如果第一个参数为 NaN，则返回 NaN。
        如果第一个参数为无穷大，则返回带有相同符号的无穷大。
        如果第一个参数为 0，则返回带有相同符号的 0。
        参数：
        d - 要使用 2 的次幂缩放的数。
        scaleFactor - 用来缩放 d 的 2 的次幂
        返回：
        d × 2scaleFactor
        */

        /*
        public static float scalb(float f,
        int scaleFactor)
        返回 f × 2scaleFactor，其舍入方式如同将一个正确舍入的浮点值乘以 float 值集合中的一个值。有关浮点值集合的讨论，请参阅 Java 语言规范。如果结果的指数在 Float.MIN_EXPONENT 和 Float.MAX_EXPONENT 之间，则可以正确地计算答案；如果结果的指数大于 Float.MAX_EXPONENT，则返回无穷大。注意，如果结果为 subnormal，则可能丢失精度；也就是说，scalb(x, n) 为 subnormal 时，scalb(scalb(x, n), -n) 可能不等于 x。结果为非 NaN 时，结果的符号将与 f 相同。
        特殊情况如下：

        如果第一个参数为 NaN，则返回 NaN。
        如果第一个参数为无穷大，则返回带有相同符号的无穷大。
        如果第一个参数为 0，则返回带有相同符号的 0。
        参数：
        f - 要使用 2 的次幂缩放的数。
        scaleFactor - 用来缩放 f 的 2 的次幂
        返回：
        f × 2scaleFactor
        */

        /*  (double,float)
        public static double signum(double d)
        返回参数的符号函数；如果参数为 0，则返回 0；如果参数大于 0，则返回 1.0；如果参数小于 0，则返回 -1.0。
        特殊情况如下：

        如果参数为 NaN，那么结果为 NaN。
        如果参数为正 0 或负 0，那么结果与参数相同。
        参数：
        d - 要返回符号函数的浮点值
        返回：
        参数的符号函数
        */


        d19 = Math.signum(-8);
        System.out.println("d19 = " + d19);

        /*
        public static double sin(double a)
        返回角的三角正弦。特殊情况如下：
        如果参数为 NaN 或无穷大，那么结果为 NaN。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - 以弧度表示的角。
        返回：
        参数的正弦。
        */

        /*
        public static double sinh(double x)
        返回 double 值的双曲线正弦。x 双曲线正弦的定义是 (ex - e-x)/2，其中 e 是欧拉数。
        特殊情况如下：

        如果参数为 NaN，那么结果为 NaN。
        如果参数为无穷大，那么结果为无穷大，符号与参数符号相同。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        计算结果必须在准确结果的 2.5 ulp 范围内。

        参数：
        x - 要返回其双曲线正弦的数字。
        返回：
        x 的双曲线正弦。
        */


        /*
        public static double sqrt(double a)
        返回正确舍入的 double 值的正平方根。特殊情况如下：
        如果参数为 NaN 或小于 0，那么结果为 NaN。
        如果参数为正无穷大，那么结果为正无穷大。
        如果参数为正 0 或负 0，那么结果与参数相同。
        否则，结果为最接近该参数值的实际数学平方根的 double 值。
        参数：
        a - 一个值。
        返回：
        a 的正平方根。 如果参数为 NaN 或小于 0，那么结果为 NaN。
        */

        d20 = Math.sqrt(4);
        System.out.println("d20 = " + d20);

        /*
        public static double tan(double a)
        返回角的三角正切。特殊情况如下：
        如果参数为 NaN 或无穷大，那么结果为 NaN。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        计算结果必须在准确结果的 1 ulp 范围内。结果必须具有半单调性。

        参数：
        a - 以弧度表示的角。
        返回：
        参数的正切。
        */

        /*
        public static double tanh(double x)
        返回 double 值的双曲线余弦。x 的双曲线正切的定义是 (ex - e-x)/(ex + e-x)，即 sinh(x)/cosh(x)。注意，准确的 tanh 绝对值始终小于 1。
        特殊情况如下：

        如果参数为 NaN，那么结果为 NaN。
        如果参数为 0，那么结果为 0，符号与参数符号相同。
        如果参数为正无穷大，那么结果为 +1.0。
        如果参数为负无穷大，那么结果为 -1.0。
        计算结果必须在准确结果的 2.5 ulp 范围内。任何有限输入值的 tanh 结果的绝对值必定小于等于 1。注意，一旦准确的 tanh 结果在极限值 ±1 的 1/2 ulp 内，则应该返回有正确符号的 ±1.0。

        参数：
        x - 要返回其双曲线正切的数字。
        返回：
        x 的双曲线正切。
        */

        /*
        public static double toDegrees(double angrad)
        将用弧度表示的角转换为近似相等的用角度表示的角。从弧度到角度的转换通常是不精确的；用户不 应该期望 cos(toRadians(90.0)) 与 0.0 完全相等。
        参数：
        angrad - 用弧度表示的角。
        返回：
        角 angrad 用角度表示的值。
        */

        /*
        public static double toRadians(double angdeg)
        将用角度表示的角转换为近似相等的用弧度表示的角。从角度到弧度的转换通常是不精确的。
        参数：
        angdeg - 用角度表示的角
        返回：
        角 angrad 用弧度表示的值。
        */

        /*  (double,float)
        public static double ulp(double d)
        返回参数的 ulp 大小。double 值的 ulp 是此浮点值与下一个数值较大的 double 值之间的正距离。注意，对于非 NaN x，ulp(-x) == ulp(x)。
        特殊情况如下：

        如果参数为 NaN，那么结果为 NaN。
        如果参数为正的或负的无穷大，那么结果为正无穷大。
        如果参数为正 0 或负 0，那么结果为 Double.MIN_VALUE。
        如果参数为 ±Double.MAX_VALUE，那么结果等于 2971。
        参数：
        d - 要返回 ulp 的浮点值
        返回：
        参数的 ulp 大小
        */

        d21 = Math.ulp(4);
        System.out.println("d21 = " + d21);


    }

}
