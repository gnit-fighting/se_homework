# 单一职责原则-Single Responsibility Principle
## 一、什么是单一职责原则
**一个类、接口、方法只负责一项职责，不要存在多于一个导致类变更的原因。**     

如果一个对象承担了太多的职责，会至少存在以下两个缺点： 

    1.一个职责的变化可能会削弱或抑制这个类实现其他职责的能力；  
    2.当客户端需要该对象的某一个职责时，不得不将其他不需要的职责全都包含进来，从而造成冗余代码或代码浪费。

优点：  

    使用好单一职责原则，可以降低类的复杂度，提高类的可读性，提高系统的可维护性，降低因变更参数引起的风险等。但使用单一职责原则也不是任何情况下都追求完全的遵守。该原则适用于类也适用于方法。

## 二、单一职责原则应用的范围
单一职责原则适用的范围有**接口、方法、类**。按大家的说法，接口和方法必须保证单一职责，类就不必保证，只要符合业务就行。
### 2.1 方法层面
假设场景：修改用户的用户名和密码  
第一种实现：
```
public enum OperateEnum {
    UPDATE_USERNAME,
    UPDATE_PASSWORD;
}
public interface UserOperate {
    void updateUserInfo(OperateEnum type, UserInfo userInfo);
}
public class UserOperateImpl implements UserOperate{
    @Override
    public void updateUserInfo(OperateEnum type, UserInfo userInfo) {
        if (type == OperateEnum.UPDATE_PASSWORD) {
            // 修改密码
        } else if(type == OperateEnum.UPDATE_USERNAME) {
            // 修改用户名
        }
    }
}
```
第二种方法：
```
public interface UserOperate {
    void updateUserName(UserInfo userInfo);
    void updateUserPassword(UserInfo userInfo);
}
public class UserOperateImpl implements UserOperate {
    @Override
    public void updateUserName(UserInfo userInfo) {
        // 修改用户名逻辑
    }
    @Override
    public void updateUserPassword(UserInfo userInfo) {
        // 修改密码逻辑
    }
}
```
区别：  
    第一种实现是根据操作类型进行区分，不同类型执行不同的逻辑。把修改用户名和修改密码这两件事耦合在一起了。如果客户端在操作的时候传错了类型，那么就会发生错误。  
    第二种实现是更推荐的实现方式。修改用户名和修改密码逻辑分开。各自执行各自的职责，互不干扰。功能清晰明了。
    由此可见，第二种设计是符合单一职责原则的。这是在方法层面实现单一职责原则。
### 2.2 接口层面
假设场景：大家一起做家务，张三扫地，李四买菜，李四买完菜回来还得做饭。  
第一种实现：
```
public interface HouseWork {
    void sweepFloor();// 扫地
    void shopping();// 购物
}
public class Zhangsan implements HouseWork{
    @Override
    public void sweepFloor() {
        // 扫地
    }
    @Override
    public void shopping() {

    }
}
public class Lisi implements HouseWork{
    @Override
    public void sweepFloor() {

    }
    @Override
    public void shopping() {
        // 购物
    }
}
```
首先定义了一个做家务的接口，定义两个方法扫地和买菜。张三扫地，就实现扫地接口。李四买菜，就实现买菜接口。李四买完菜回来还要做饭，于是就要在接口类中增加一个方法cooking。张三和李四都重写这个方法，但只有李四有具体实现。这样设计本身就是不合理的：   
 1.张三只扫地，但是他需要重写买菜方法，李四不需要扫地，但是李四也要重写扫地方法。  
 2.这也不符合开闭原则。增加一种类型做饭，要修改3个类。这样当逻辑很复杂的时候，很容易引起意外错误。  

上面这种设计不符合单一职责原则，修改一个地方，影响了其他不需要修改的地方。

第二种实现：
```
public interface Hoursework {
}
public interface Shopping extends Hoursework{
    void shopping(); // 购物
}
public interface SweepFloor extends Hoursework{
    void sweepFlooring();// 扫地
}
public class Zhangsan implements SweepFloor{
    @Override
    public void sweepFlooring() {
        // 张三扫地
    }
}
public class Lisi implements Shopping{
    @Override
    public void shopping() {
        // 李四购物
    }
}
```
上面做家务不是定义成一个接口，而是将扫地和做家务分开了。张三扫地，那么张三就实现扫地的接口。李四购物，李四就实现购物的接口。后面李四要增加一个功能做饭，那么就新增一个做饭接口。现在只需要李四实现做饭接口就可以了。
```
public interface Cooking extends Hoursework{ 
    void cooking();
}
public class Lisi implements Shopping, Cooking{
    @Override
    public void shopping() {
        // 李四购物
    }
    @Override
    public void cooking() {
        // 李四做饭
    }
}
```
如上，张三没有实现多余的接口，李四也没有。而且当新增功能的时候，只影响了李四，并没有影响张三。这就符合单一职责原则，一个类只做一件事，并且他的修改不会带来其他的变化。

### 2.3 类层面
从类的层面来讲，没有办法完全按照单一职责原来来拆分。类的职责可大可小，不像接口那样可以很明确的按照单一职责原则拆分。只要符合逻辑有道理即可。  
假设场景：网站用户注册、登录、登出  
第一种实现:
```
public interface UserOperate {
    void login(UserInfo userInfo);
    void register(UserInfo userInfo);
    void logout(UserInfo userInfo);
}
public class UserOperateImpl implements UserOperate{
    @Override
    public void login(UserInfo userInfo) {
        // 用户登录
    }
    @Override
    public void register(UserInfo userInfo) {
        // 用户注册
    }
    @Override
    public void logout(UserInfo userInfo) {
        // 用户登出
    }
}
```
第二种实现(按单一职责原则划分类):
```
public interface Register {
    void register();
}
public interface Login {
    void login();
}
public interface Logout {
    void logout();
}
public class RegisterImpl implements Register{
    @Override
    public void register() {
        // 用户注册
    }
}
public class LoginImpl implements Login{
    @Override
    public void login() {
        // 用户登录
    }
}
public class LogoutImpl implements Logout{
    @Override
    public void logout() {
        // 用户登出
    }
}
```
第二种实现遵循单一职责原则，实现起来类较多。如果登录、注册、注销操作代码很多，那么可以这么写。



