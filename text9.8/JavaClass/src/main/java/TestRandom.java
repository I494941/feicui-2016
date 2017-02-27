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
