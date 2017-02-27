# 2016-09-26工作日志
======================

1. 已完成工作

	    TestMath
      
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
    
    
    	    TestRandom 
          
          
          import java.util.Random;

        /**
         * Created by 王金飞 on 2016/9/27.
         */
        public class TestRandom {

        public static void main(String[] args) {

        Random rd = new Random();
	
        int i1,i2;
	
        double d1,d2;
	
        boolean bln;



        /*
        protected int next(int bits)生成下一个伪随机数。当被所有其他方法使用时，子类应该重写此方法。
        next 的常规协定是，返回一个 int 值，如果参数 bits 位处于 1 和 32（包括）之间，那么返回值的多数低位都将（大致）是单独选择的位值，
        每个位值是 0 或 1 的机会（大致）相等。通过将种子自动更新为

                (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1)并返回
                (int)(seed >>> (48 - bits))，Random 类可实现 next 方法。这是一个线性同余伪随机数生成器，
                由 D. H. Lehmer 定义，Donald E. Knuth 在 The Art of Computer Programming, Volume 3: Seminumerical Algorithms 的第 3.2.1 节中进行了描述。

            参数：
                bits - 随机位。
                返回：
                随机数生成器序列的下一个伪随机值。
        */

        /*
        public boolean nextBoolean()返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 boolean 值。
        nextBoolean 的常规协定是，伪随机地生成并返回一个 boolean 值。值 true 和 false 的生成概率（大致）相同。
        Random 类按如下方式实现 nextBoolean 方法：

        public boolean nextBoolean() {
            return next(1) != 0;
        }
            返回：
            下一个伪随机数，它是此随机数生成器的序列中均匀分布的 boolean 值
        */

        bln = rd.nextBoolean();
	
        System.out.println("bln = "+bln);

        /*
        public void nextBytes(byte[] bytes)生成随机字节并将其置于用户提供的 byte 数组中。所生成的随机字节数等于该 byte 数组的长度。
        Random 类按如下方式实现 nextBytes 方法：

        public void nextBytes(byte[] bytes) {
            for (int i = 0; i < bytes.length; )
                for (int rnd = nextInt(), n = Math.min(bytes.length - i, 4);
                     n-- > 0; rnd >>= 8)
                    bytes[i++] = (byte)rnd;
        }
        参数：
        bytes - 用随机字节填充的 byte 数组
        抛出：
        NullPointerException - 如果 byte 数组为 null
        */

        /*
        public double nextDouble()返回下一个伪随机数，它是取自此随机数生成器序列的、在 0.0 和 1.0 之间均匀分布的 double 值。
        nextDouble 的常规协定是，伪随机地生成并返回一个从 0.0d（包括）到 1.0d（不包括）范围内均匀选择（大致）的 double 值。

        Random 类按如下方式实现 nextDouble 方法：

        public double nextDouble() {
            return (((long)next(26) << 27) + next(27))
                    / (double)(1L << 53);
        }前面的描述中使用了不确定的词“大致”，因为 next 方法只是一个大致上独立选择位的无偏源。如果它是一个随机选择位的最佳源，
        那么给出的算法应该从规定范围完全一致地选择 double 值。

        [在 Java 的早期版本中，结果被错误地计算为：

        return (((long)next(27) << 27) + next(27))
                / (double)(1L << 54);这可能看似等效（如果不是更好的话），但实际上由于浮点数舍入中的偏差，它会引入较大的不均匀性：
                有效数的低位出现 0 的可能性是 1 的三倍！这种不均匀性在实践中可能没什么关系，但我们总是力求完美。]

        返回：
        下一个伪随机数，它是此随机数生成器序列中 0.0 和 1.0 之间均匀分布的 double 值
        */

        d1 = rd.nextDouble();
	
        System.out.println("d1 = "+d1);

        /*
        public float nextFloat()返回下一个伪随机数，它是取自此随机数生成器序列的、在 0.0 和 1.0 之间均匀分布的 float 值。
        nextFloat 的常规协定是，伪随机地生成并返回一个从 0.0f（包括）到 1.0f（包括）范围内均匀选择（大致）的 float 值。
        所有可能的 224 个 float 值（其形式为 m x 2-24，其中 m 是一个小于 224 的正整数）的生成概率（大致）相同。

        Random 类按如下方式实现 nextFloat 方法：

        public float nextFloat() {
            return next(24) / ((float)(1 << 24));
        }前面的描述中使用了不确定的词“大致”，因为 next 方法只是一个大致上独立选择位的无偏源。
        如果它是一个随机选择位的最佳来源，那么给出的算法应该从规定范围完全一致地选择 float 值。

            [在 Java 的早期版本中，结果被错误地计算为：

        return next(30) / ((float)(1 << 30));这可能看似等效（如果不是更好的话），但实际上由于浮点数舍入中的偏差，它会导致轻微的不均匀性：
        有效数的低位更可能是 0 而不是 1。]

        返回：
        下一个伪随机数，它是取自此随机数生成器序列的、在 0.0 和 1.0 之间均匀分布的 float 值
        */


        /*
        public double nextGaussian()返回下一个伪随机数，它是取自此随机数生成器序列的、呈高斯（“正态”）分布的 double 值，其平均值是 0.0，标准差是 1.0。
        nextGaussian 的常规协定是，伪随机地生成并返回一个 double 值，该值从（大致）具有平均值 0.0 和标准差 1.0 的标准正态分布中选择。

        Random 类按以下这种线程安全的方式实现 nextGaussian 方法：


        private double nextNextGaussian;
        private boolean haveNextNextGaussian = false;

        public double nextGaussian() {
            if (haveNextNextGaussian) {
                haveNextNextGaussian = false;
                return nextNextGaussian;
            } else {
                double v1, v2, s;
                do {
                    v1 = 2 * nextDouble() - 1;   // between -1.0 and 1.0
                    v2 = 2 * nextDouble() - 1;   // between -1.0 and 1.0
                    s = v1 * v1 + v2 * v2;
                } while (s >= 1 || s == 0);
                double multiplier = StrictMath.sqrt(-2 * StrictMath.log(s)/s);
                nextNextGaussian = v2 * multiplier;
                haveNextNextGaussian = true;
                return v1 * multiplier;
            }
        }这使用了 G. E. P. Box、M. E. Muller 和 G. Marsaglia 的极坐标法 (polar method)，
        该方法在 Donald E. Knuth 的 The Art of Computer Programming, Volume 3:Seminumerical Algorithms 的第 3.4.1 节，
        小节 C，算法 P 中进行了描述。注意，它只需调用一次 StrictMath.log 和调用一次 StrictMath.sqrt> 就可以生成两个独立的值。

        返回：
        下一个伪随机数，它是取自此随机数生成器序列的、呈高斯（“正态”）分布的 double 值，其平均值是 0.0，标准差是 1.0。
        */

        d2 = rd.nextGaussian();
        System.out.println("d2 = "+d2);

        /*
        public int nextInt()返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。
        nextInt 的常规协定是，伪随机地生成并返回一个 int 值。所有 232 个可能 int 值的生成概率（大致）相同。
        Random 类按如下方式实现 nextInt 方法：

        public int nextInt() {
            return next(32);
        }
        返回：
        下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。
        */


        i1 = rd.nextInt();
	
        System.out.println("i1 = "+i1);

        /*
        public int nextInt(int n)返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）和指定值（不包括）之间均匀分布的 int 值。
        nextInt 的常规协定是，伪随机地生成并返回指定范围中的一个 int 值。所有可能的 n 个 int 值的生成概率（大致）相同。
        Random 类按如下方式实现 nextInt(int n) 方法：
        public int nextInt(int n) {
            if (n<=0)
                throw new IllegalArgumentException("n must be positive");

            if ((n & -n) == n)  // i.e., n is a power of 2
                return (int)((n * (long)next(31)) >> 31);

            int bits, val;
            do {
                bits = next(31);
                val = bits % n;
            } while(bits - val + (n-1) < 0);
            return val;
        }前面的描述中使用了不确定的词“大致”，因为 next 方法只是一个大致上独自选择位的无偏源。
        如果它是一个随机选择位的最佳源，那么给出的算法应该从规定范围完全一致地选择 int 值。

        该算法稍微有些复杂。它拒绝那些会导致不均匀分布的值（由于 2^31 无法被 n 整除）。
        某个值被拒绝的概率取决于 n。最坏的情况是 n=2^30+1，拒绝的概率是 1/2，循环终止前的预计迭代次数是 2。

        该算法特别对待 n 是 2 的次幂的情况：它从底层伪随机数生成器中返回正确的高位数。
        在不是特殊处理的情况中，将返回正确的低 位数。众所周知，线性同余伪随机数生成器（比如此类所实现的）在其低位的值序列中周期较短。
        因此，如果 n 是 2 的次幂（幂值较小），则这种特殊情况将大大增加此方法的后续调用所返回的值序列长度。


        参数：
        n - 要返回的随机数的范围。必须为正数。
        返回：
        下一个伪随机数，在此随机数生成器序列中 0（包括）和 n（不包括）之间均匀分布的 int 值。
        */

        i2 = rd.nextInt(35);
	
        System.out.println("i2 = "+i2);

       /*
        public long nextLong()返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 long 值。nextLong 的常规协定是，伪随机地生成并返回一个 long 值。
        Random 类按如下方式实现 nextLong 方法：

        public long nextLong() {
            return ((long)next(32) << 32) + next(32);
        }因为 Random 类使用只以 48 位表示的种子，所以此算法不会返回所有可能的 long 值。

        返回：
        下一个伪随机数，它是此随机数生成器序列中均匀分布的 long 值。
        */

        /*
        public void setSeed(long seed)使用单个 long 种子设置此随机数生成器的种子。setSeed 的常规协定是它更改此随机数生成器对象的状态，使其状态好像是刚刚使用参数 seed 作为种子创建它的状态一样。通过将种子自动更新为
                (seed ^ 0x5DEECE66DL) & ((1L << 48) - 1)并清除 nextGaussian() 使用的 haveNextNextGaussian 标志，Random 类可实现 setSeed 方法。
        Random 类实现的 setSeed 恰好只使用 48 位的给定种子。但是，通常重写方法可能使用 long 参数的所有 64 位作为种子值。


        参数：
        seed - 初始种子。
        */





    }
}


      TestArrays
      
      
      import java.util.Arrays;

        /**
	
         * Created by 王金飞 on 2016/9/27.
	 
         */
	 
        public class TestArrays {

        public static void main(String[] args) {

        int[] array = new int[]{9,8,7,6,5,4,3,2,1};


        /*
        public static void sort(int[] a)对指定的 int 型数组按数字升序进行排序。
        该排序算法是一个经过调优的快速排序法，
        改编自 Jon L. Bentley 和 M. Douglas McIlroy 合著的
        Engineering a Sort Function", Software-Practice and Experience Vol. 23(11) P. 1249-1265 (November 1993)。
        此算法在许多数据集上提供 n*log(n) 性能，这导致其他快速排序会降低二次型性能。

        参数：
        a - 要排序的数组
        */

        System.out.println("sort前");
	
        for (int tmp:array) {
	
            System.out.print(tmp+",");
	    
        }
	
        System.out.println("");
	

        Arrays.sort(array);

        System.out.println("sort后");
	
        for (int tmp:array) {
	
            System.out.print(tmp+",");
	    
        }




    }
}
          
          
          TestSystem
          
          
          /**
	  
           * Created by 王金飞 on 2016/9/27.
	   
           */
	   
          public class TestSystem {
	  

         public static void main(String[] args) {
	 

        int [] array1={3,1,3,6};
	
        int [] array2=new int[7];

        /*
        public static void arraycopy(Object src,
        int srcPos,
        Object dest,
        int destPos,
        int length)从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
        从 src 引用的源数组到 dest 引用的目标数组，数组组件的一个子序列被复制下来。被复制的组件的编号等于 length 参数。
        源数组中位置在 srcPos 到 srcPos+length-1 之间的组件被分别复制到目标数组中的 destPos 到 destPos+length-1 位置。
        如果参数 src 和 dest 引用相同的数组对象，则复制的执行过程就好像首先将 srcPos 到 srcPos+length-1 位置的组件复制到一个带有 length 组件的临时数组，
        然后再将此临时数组的内容复制到目标数组的 destPos 到 destPos+length-1 位置一样。

        If 如果 dest 为 null，则抛出 NullPointerException 异常。

        如果 src 为 null, 则抛出 NullPointerException 异常，并且不会修改目标数组。

        否则，只要下列任何情况为真，则抛出 ArrayStoreException 异常并且不会修改目标数组：

        src 参数指的是非数组对象。
        dest 参数指的是非数组对象。
        src 参数和 dest 参数指的是那些其组件类型为不同基本类型的数组。
        src 参数指的是具有基本组件类型的数组且 dest 参数指的是具有引用组件类型的数组。
        src 参数指的是具有引用组件类型的数组且 dest 参数指的是具有基本组件类型的数组。
        否则，只要下列任何情况为真，则抛出 IndexOutOfBoundsException 异常，并且不会修改目标数组：

        srcPos 参数为负。
        destPos 参数为负。
        length 参数为负。
        srcPos+length 大于 src.length，即源数组的长度。
        destPos+length 大于 dest.length，即目标数组的长度。
        否则，如果源数组中 srcPos 到 srcPos+length-1 位置上的实际组件通过分配转换并不能转换成目标数组的组件类型，则抛出 ArrayStoreException 异常。
        在这种情况下，将 k 设置为比长度小的最小非负整数，这样就无法将 src[srcPos+k] 转换为目标数组的组件类型；
        当抛出异常时，从 srcPos 到 srcPos+k-1 位置上的源数组组件已经被复制到目标数组中的 destPos 到 destPos+k-1 位置，
        而目标数组中的其他位置不会被修改。（因为已经详细说明过的那些限制，只能将此段落有效地应用于两个数组都有引用类型的组件类型的情况。）


        参数：
        src - 源数组。
        srcPos - 源数组中的起始位置。
        dest - 目标数组。
        destPos - 目标数据中的起始位置。
        length - 要复制的数组元素的数量。
        */

        System.arraycopy(array1,2,array2,2,1);

        System.out.println("array2 = ");
	
        for (int tmp:array2) {
	
            System.out.print(tmp+",");
	    
        }


        /*
        public static long currentTimeMillis()返回以毫秒为单位的当前时间。注意，当返回值的时间单位是毫秒时，
        值的粒度取决于底层操作系统，并且粒度可能更大。例如，许多操作系统以几十毫秒为单位测量时间。
        请参阅 Date 类的描述，了解可能发生在“计算机时间”和协调世界时（UTC）之间的细微差异的讨论。


        返回：
        当前时间与协调世界时 1970 年 1 月 1 日午夜之间的时间差（以毫秒为单位测量）。
        */


       //long time = System.currentTimeMills();

        /*
        public static void exit(int status)终止当前正在运行的 Java 虚拟机。参数用作状态码；根据惯例，非 0 的状态码表示异常终止。
        该方法调用 Runtime 类中的 exit 方法。该方法永远不会正常返回。

        调用 System.exit(n) 实际上等效于调用：

        Runtime.getRuntime().exit(n)

        参数：
        status - 退出状态。
        抛出：
        SecurityException - 如果安全管理器存在并且其 checkExit 方法不允许以指定状态退出。
        */



        /*
        public static void gc()运行垃圾回收器。
        调用 gc 方法暗示着 Java 虚拟机做了一些努力来回收未用对象，以便能够快速地重用这些对象当前占用的内存。当控制权从方法调用中返回时，虚拟机已经尽最大努力从所有丢弃的对象中回收了空间。

        调用 System.gc() 实际上等效于调用：

        Runtime.getRuntime().gc()
        */




    }
}
          
          
          
          
          
          
          
          
          
          
