# 工厂方法模式实现火锅订单系统
## 类图  
![类图](https://gitee.com/htt1103/se_homework/raw/master/hw7/img/%E7%B1%BB%E5%9B%BE.jpg)

## 关于工厂模式
    1.抽象工厂模式定义了一个interface用于创建相关或有依赖关系的对象簇，而无需指明具体的类。  
    2.抽象工厂模式可以将简单工厂模式和工厂方法模式进行整合。  
    3.从设计层面看，抽象工厂模式就是对简单工厂模式的改进(或者称为进一步的抽象)，将工厂抽象成两层，AbsFactory(抽象工厂) 和 具体实现的工厂子类。  
    4.程序员可以根据创建对象类型使用对应的工厂子类。这样将单个的简单工厂类变成了工厂簇，更利于代码的维护和扩展。

## 实现步骤
### 一：创建一个HotPot抽象类
```
public abstract class HotPot {
    public String name;
    public abstract void prepare();
    public void serve() {
        System.out.println(name + " serving");
    }
    public void cut() {
        System.out.println(name + " cutting");
    }
    public void setName(String name) {
        this.name = name;
    }
}
```
分析：这个类用来代表制作火锅的整个流程：准备阶段prepare()、切菜阶段cut()和上菜阶段serve() ，假设各类火锅的准备阶段需要的材料不一样，所以把准备阶段定义为一个抽象方法，其它三个阶段都一样。

### 二：创建四个火锅类
```
public class CQMaoduHotpot extends  HotPot{
    @Override
    public void prepare() {
        setName("重庆的毛肚火锅");
        System.out.println("重庆的毛肚火锅准备原材料：");
    }
}
```
分析： 此类是用来创建重庆的毛肚口味的火锅,创建其他类火锅（重庆羊肉火锅、成都毛肚火锅、成都羊肉火锅）操作类似，不再赘述。

### 三：创建总工厂接口
```
public interface AbsFactory {
    public HotPot createHotpot(String orderType);
}
```
分析： 此类是用来让下面的工厂子类来具体实现

### 四：创建分工厂
```
public class CQFactory implements AbsFactory{
    @Override
    public HotPot createHotpot(String orderType) {
        HotPot hotpot = null;
        if(orderType.equals("毛肚")) {
            hotpot = new CQMaoduHotpot();
        } else if (orderType.equals("羊肉")){
            hotpot = new CQYangrouHotpot();
        }
        return hotpot;
    }
}
```
分析： 这是工厂子类，用来制作重庆的火锅
```
public class CDFactory implements AbsFactory{
    @Override
    public HotPot createHotpot(String orderType) {
        HotPot hotpot =null;
        if (orderType.equals("毛肚")) {
            hotpot = new CDMaoduHotpot();
        } else if (orderType.equals("羊肉")) {
            hotpot = new CDYangrouHotpot();
        }
        return hotpot;
    }
}
```
分析： 这是工厂子类，用来制作成都的火锅

### 五：创建订购类
```
public class OrderHotpot {
    private AbsFactory factory;
    public OrderHotpot(AbsFactory factory){
        setFactory(factory);
    }
    private void setFactory(AbsFactory factory){
        do{
            this.factory = factory;
            String orderType = getType();
            HotPot hotpot=factory.createHotpot(orderType);
            if(hotpot==null){
                System.out.println("很遗憾！订购失败！");
                break;
            }
            hotpot.prepare();
            hotpot.cut();
            hotpot.serve();
        }while(true);
    }
    private String getType(){
        try{
            BufferedReader strin;
            strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input hotpot 种类:");
            String str = strin.readLine();
            return str;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
```
分析： HotPot hotpot = factory.createHotpot(orderType);这一语句主要运用的是java基础里面的多态，具体的实现功能交给实现其接口的子类

### 六：创建运行类
```
public class HotPotStore {
    public static void main(String[] args){
        new OrderHotpot(new CQFactory());
    }
}
```
分析：假设买的是重庆地区的火锅

## 运行结果：
![运行结果](https://gitee.com/htt1103/se_homework/raw/master/hw7/img/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C.png)

## 总结：
1.工厂模式的意义：  

    将实例化对象的代码提取出来，放到一个类中统一管理和维护，达到和主项目的依赖关系的解耦。从而提高项目的扩展和维护性  
2.设计模式的依赖抽象原则:  

    创建对象实例时，不要直接 new 类, 而是把这个new 类的动作放在一个工厂的方法中，并返回。不要让类继承具体类，而是继承抽象类或者是实现interface(接口) 不要覆盖基类中已经实现的方法。


