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
