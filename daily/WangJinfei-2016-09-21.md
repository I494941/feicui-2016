# 2016-09-21工作日志
======================

1. 已完成工作

  (1) Java 继承
  
      继承是java面向对象编程技术的一块基石，因为它允许创建分等级层次的类。
      继承可以理解为一个对象从另一个对象获取属性的过程。
      如果类A是类B的父类，而类B是类C的父类，我们也称C是A的子类，类C是从类A继承而来的。
      在Java中，类的继承是单一继承，也就是说，一个子类只能拥有一个父类 。
      继承中最常使用的两个关键字是extends和implements。
      这两个关键字的使用决定了一个对象和另一个对象是否是IS-A(是一个)关系。
      通过使用这两个关键字，我们能实现一个对象获取另一个对象的属性。
      所有Java的类均是由java.lang.Object类继承而来的，所以Object是所有类的祖先类，而除了Object外，所有类必须有一个父类。
      通过过extends关键字可以申明一个类是继承另外一个类而来的，一般形式如下： 
          // A.java
          public class A {
              private int i;
              protected int j;
           
              public void func() {
           
              }
          }
           
          // B.java
          public class B extends A {
          }
      以上的代码片段说明，B由A继承而来的，B是A的子类。而A是Object的子类，这里可以不显示地声明。
      作为子类，B的实例拥有A所有的成员变量，但对于private的成员变量B却没有访问权限，这保障了A的封装性。
      IS-A就是说:一个对象是另一个对象的一个分类。
      下面是使用关键字extends实现继承。
             public class Animal{
            }
            
            public class Mammal extends Animal{
            }
            
            public class Reptile extends Animal{
            }
            
            public class Dog extends Mammal{
            }
      基于上面的例子，以下说法是正确的：
        Animal类是Mammal类的父类。 
        Animal类是Reptile类的父类。 
        Mammal类和Reptile类是Animal类的子类。 
        Dog类既是Mammal类的子类又是Animal类的子类。 
          
      分析以上示例中的IS-A关系，如下：
          Mammal IS-A Animal 
          Reptile IS-A Animal 
          Dog IS-A Mammal 
          因此 : Dog IS-A Animal
          
      通过使用关键字extends，子类可以继承父类的除private属性外所有的属性。
      
      我们通过使用instanceof 操作符，能够确定Mammal IS-A Animal
          
        实例
          
           public class Dog extends Mammal{
          
             public static void main(String args[]){
          
                Animal a = new Animal();
                Mammal m = new Mammal();
                Dog d = new Dog();
          
                System.out.println(m instanceof Animal);
                System.out.println(d instanceof Mammal);
                System.out.println(d instanceof Animal);
             }
          }
          
      以上实例编译运行结果如下：
            true
            true
            true
            
      介绍完extends关键字之后，我们再来看下implements关键字是怎样使用来表示IS-A关系。
      Implements关键字使用在类继承接口的情况下， 这种情况不能使用关键字extends。
          
        实例
                      
                public interface Animal {}
              
                public class Mammal implements Animal{}
                public class Dog extends Mammal{}
            
      instanceof 关键字
            
      可以使用 instanceof 运算符来检验Mammal和dog对象是否是Animal类的一个实例。
      
              interface Animal{}
              
              class Mammal implements Animal{}
              
              public class Dog extends Mammal{
                 public static void main(String args[]){
              
                    Mammal m = new Mammal();
                    Dog d = new Dog();
              
                    System.out.println(m instanceof Animal);
                    System.out.println(d instanceof Mammal);
                    System.out.println(d instanceof Animal);
                 }
              } 

      以上实例编译运行结果如下：
          
          true
          true
          true
                
      HAS-A 关系
       HAS-A代表类和它的成员之间的从属关系。这有助于代码的重用和减少代码的错误。
            例子
                public class Vehicle{}
                public class Speed{}
                public class Van extends Vehicle{
                	private Speed sp;
                } 
      Van类和Speed类是HAS-A关系(Van有一个Speed)，这样就不用将Speed类的全部代码粘贴到Van类中了，
      并且Speed类也可以重复利用于多个应用程序。

      在面向对象特性中，用户不必担心类的内部怎样实现。

      Van类将实现的细节对用户隐藏起来，因此，用户只需要知道怎样调用Van类来完成某一功能，
      而不必知道Van类是自己来做还是调用其他类来做这些工作。

      Java只支持单继承，也就是说，一个类不能继承多个类。

      下面的做法是不合法的：

      public class extends Animal, Mammal{} 
      Java只支持单继承（继承基本类和抽象类），但是我们可以用接口来实现（多继承接口来实现）,脚本结构如：
      
      public class Apple extends Fruit implements Fruit1, Fruit2{}
      一般我们继承基本类和抽象类用extends关键字，实现接口类的继承用implements关键字。
  (2) Java 重写(Override)与重载(Overload)
  
        重写(Override)
  
          重写是子类对父类的允许访问的方法的实现过程进行重新编写！返回值和形参都不能改变。即外壳不变，核心重写！
          重写的好处在于子类可以根据需要，定义特定于自己的行为。
          也就是说子类能够根据需要实现父类的方法。
          在面向对象原则里，重写意味着可以重写任何现有方法。实例如下：
          
            class Animal{
    
               public void move(){
                  System.out.println("动物可以移动");
               }
            }
            
            class Dog extends Animal{
            
               public void move(){
                  System.out.println("狗可以跑和走");
               }
            }
            
            public class TestDog{
            
               public static void main(String args[]){
                  Animal a = new Animal(); // Animal 对象
                  Animal b = new Dog(); // Dog 对象
            
                  a.move();// 执行 Animal 类的方法
            
                  b.move();//执行 Dog 类的方法
               }
            }
            
          以上实例编译运行结果如下：

              动物可以移动
              狗可以跑和走
              
          在上面的例子中可以看到，尽管b属于Animal类型，但是它运行的是Dog类的move方法。
          这是由于在编译阶段，只是检查参数的引用类型。
          然而在运行时，Java虚拟机(JVM)指定对象的类型并且运行该对象的方法。
          因此在上面的例子中，之所以能编译成功，是因为Animal类中存在move方法，然而运行时，运行的是特定对象的方法。
          
          思考以下例子：
          
          class Animal{
          
             public void move(){
                System.out.println("动物可以移动");
             }
          }
          
          class Dog extends Animal{
          
             public void move(){
                System.out.println("狗可以跑和走");
             }
             public void bark(){
                System.out.println("狗可以吠叫");
             }
          }
          
          public class TestDog{
          
             public static void main(String args[]){
                Animal a = new Animal(); // Animal 对象
                Animal b = new Dog(); // Dog 对象
          
                a.move();// 执行 Animal 类的方法
                b.move();//执行 Dog 类的方法
                b.bark();
             }
          }
          以上实例编译运行结果如下：
          
          TestDog.java:30: cannot find symbol
          symbol  : method bark()
          location: class Animal
                          b.bark();
                           ^
          该程序将抛出一个编译错误，因为b的引用类型Animal没有bark方法。
          
        方写重写的规则
  
          参数列表必须完全与被重写方法的相同；
          返回类型必须完全与被重写方法的返回类型相同；
          访问权限不能比父类中被重写的方法的访问权限更高。例如：如果父类的一个方法被声明为public，
            那么在子类中重写该方法就不能声明为protected。
          父类的成员方法只能被它的子类重写。
          声明为final的方法不能被重写。
          声明为static的方法不能被重写，但是能够被再次声明。
          如果一个方法不能被继承，那么该方法不能被重写。
          子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为private和final的方法。
          子类和父类不在同一个包中，那么子类只能够重写父类的声明为public和protected的非final方法。
          重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，
            或者比被重写方法声明的更广泛的强制性异常，反之则可以。
          构造方法不能被重写。
          如果不能继承一个方法，则不能重写这个方法。
          
        Super关键字的使用
          当需要在子类中调用父类的被重写方法时，要使用super关键字。
          
          class Animal{
          
             public void move(){
                System.out.println("动物可以移动);
             }
          }
          
          class Dog extends Animal{
          
             public void move(){
                super.move(); // 应用super类的方法
                System.out.println("狗可以跑和走");
             }
          }
          
          public class TestDog{
          
             public static void main(String args[]){
          
                Animal b = new Dog(); /
                b.move(); //执行 Dog类的方法
          
             }
          }
          
        以上实例编译运行结果如下：
          
          动物可以移动
          狗可以跑和走
          
      重载(Overload)
      
        重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型呢？可以相同也可以不同。
        每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。
        只能重载构造函数
        
        重载规则
        
          被重载的方法必须改变参数列表；
          被重载的方法可以改变返回类型；
          被重载的方法可以改变访问修饰符；
          被重载的方法可以声明新的或更广的检查异常；
          方法能够在同一个类中或者在一个子类中被重载。
          
        实例
          
          public class Overloading {
 
          	public int test(){
          		System.out.println("test1");
          		return 1;
          	}
           
          	public void test(int a){
          		System.out.println("test2");
          	}	
           
          	//以下两个参数类型顺序不同
          	public String test(int a,String s){
          		System.out.println("test3");
          		return "returntest3";
          	}	
           
          	public String test(String s,int a){
          		System.out.println("test4");
          		return "returntest4";
          	}	
           
          	public static void main(String[] args){
          		Overloading o = new Overloading();
          		System.out.println(o.test());
          		o.test(1);
          		System.out.println(o.test(1,"test3"));
          		System.out.println(o.test("test4",1));
          	}
          }
          
        以上实例编译运行结果如下：
          
          test1
          1
          test2
          test3
          returntest3
          test4
          returntest4
          
      重写与重载之间的区别
      
| 区别点        | 重载方法     | 重写方法                                       |
| ------------- | ------------ | ---------------------------------------------- |
| 参数列表      | 必须修改     | 一定不能修改                                   |
| 返回类型      | 可以修改     | 一定不能修改                                   |
| 异常          | 可以修改     | 可以减少或删除，一定不能抛出新的或者更广的异常 |
| 访问          | 可以修改     | 一定不能做更严格的限制（可以降低限制)          |
