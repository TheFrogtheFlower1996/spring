# spring

* 学习内容
~~~text
Spring IOC 控制反转、依赖注入
Spring AOP 面向切面编程
Spring JDBC + 事务
Spring Task 定时调度
Spring Mail 邮件发送
~~~

* Spring的作用
~~~text
Controller层
    Servlet（接收请求、响应数据、地址配置、页面转发）
    对应框架：Spring MVC

Service层
    Spring框架并不是针对service层的业务逻辑的，service没有适合框架

DAO层
    JDBC操作
    对应的框架：MyBatis
~~~

* Spring基于分布式的应用程序
~~~text
基于轻量级的框架
    配置管理
    Bean对象的实例化-IOC

集成第三方框架
    MyBatis、Hibernate（持久层框架）
    Spring MVC
    Spring Security权限
    Quartz时钟框架（定时任务处理）
    Elasticsearch搜索引擎

自带服务
    Mail邮件发送
    Task定时任务处理-定时调度（定时短信、定时任务）
    消息处理（异步处理）
~~~

* Spring模块划分
~~~text
Spring IOC模块：Bean对象的实例化，Bean的创建
Spring AOP模块：面向切面编程，动态代理
Spring JDBC + 事务模块
Spring Web模块

~~~

# Bean对象实例化

## bean对象实例化模拟实现
* 定义工具类
~~~java
public class UserDao {
    public void test(){
        System.out.println("UserDao类");
    }
}
~~~

* 定义spring XML配置文件
~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans >

    <bean id="userDao" clazz="com.zh.dao.UserDao"></bean>
    <bean id="userService" clazz="com.zh.service.UserService"></bean>

</beans>
~~~

* 定义MyBean实体类，用于存放id和class的值
~~~java
/**
 * @author zh
 * @date 2022/3/25 11:34
 * @description: Bean属性对象，用来存放配置文件中的bean标签和class属性值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBean {

    private String id;
    private String clazz;

}

~~~

* 定义一个工厂接口 MyFactory 和一个抽象方法 getBean()
~~~java
//工厂模式：自定义工具类
public interface MyFactory {

    //通过id属性值获取实例化对象
    public Object getBean(String id);
}
~~~

* 定义工厂接口实现类MyClassPathXmlApplication，实现MyFactory工厂接口
~~~java
/**
 * @author zh
 * @date 2022/3/25 11:53
 * @description:说明 工厂接口实现类
 * 1. 通过构造器的形参传递要解析的配置文件
 * 2. 解析配置文件，得到对应的bean标签的 id与class的属性值，并设置到对应的bean对象中，存放到List集合
 * 3. 遍历List集合，得到每个Bean对象，得到class属性对应的实例化对象，并设置到map中，通过id实例化bean对象
 * 4. 通过getBean方法，从map对象中通过id获取指定value，value就是实例化的对象
 */
public class MyClassPathXmlApplication implements MyFactory{

    //定义map对象，用来存放id属性与对应class属性实例化好的bean对象
    private Map<String,Object> beanMap = new HashMap<>();

    //定义List集合，用来存放myBean对象（myBean是用来存放bean标签的id和对应的class属性值）
    private List<MyBean> beanList = null;

    /**
     * 有参构造
     * 1. 通过构造器的形参传递要解析的配置文件
     *
     * */
    public MyClassPathXmlApplication(String fileName) {

        /*解析配置文件*/
        parseXml(fileName);

        /*得到实例化对象*/
        instanceBean();
    }


    /**
     * 2. 解析配置文件，得到对应的bean标签的id与class的属性值，并设置到对应的bean对象中，存放到List集合
     *
     * */
    private void parseXml(String fileName) {

        try {
            //得到解析器
            SAXReader reader = new SAXReader();
            //得到配置文件对应的URL
            URL url = this.getClass().getClassLoader().getResource(fileName);
            //解析配置文件，得到Document对象
            Document document = reader.read(url);
            //XPath 使用路径表达式来选取 XML文档中的节点或节点集；定义XPath语法，获取beans标签下的所有子元素bean标签
            XPath xPath = document.createXPath("beans/bean");
            //通过xpath语法，得到对应的bean标签，返回Element集合
            List<Element> elementList = xPath.selectNodes(document);
            //判断集合是否为空
            if (elementList != null && elementList.size() > 0){
                //实例化List集合
                beanList = new ArrayList<>();
                //遍历Element集合，得到Element对象，得到对应的属性值
                for (Element element : elementList) {
                    String id = element.attributeValue("id");
                    String clazz = element.attributeValue("clazz");
                    //将id、clazz放入MyBean对象
                    MyBean myBean = new MyBean(id, clazz);
                    beanList.add(myBean);
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    /**
     * 3. 遍历List集合，得到每个Bean对象，得到class属性对应的实例化对象，并设置到map中，通过id实例化bean对象
     *
     * */
    private void instanceBean() {
        try {
            //判断beanList是否为空，并遍历
            if (beanList != null && beanList.size() > 0){
                for (MyBean myBean : beanList) {
                    String id = myBean.getId();
                    String clazz = myBean.getClazz();
                    //通过反射，实例化指定class属性值对应的Bean对象
                    Object object = Class.forName(clazz).newInstance();
                    //将id值与实例化好的bean对象，设置到map中
                    beanMap.put(id,object);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 4. 通过getBean方法，从map对象中通过id获取指定value，value就是实例化的对象
     *
     * */
    @Override
    public Object getBean(String id) {
        //通过id，从map对象获取对应的实例对象
        Object object = beanMap.get(id);
        return object;
    }
}
~~~

* 实现类
~~~java
public class Starter {
    public static void main(String[] args) {

        //得到spring上下文环境，ApplicationContext接口代表Spring IOC容器，并负责实例化，配置和组装Bean
        BeanFactory ac = new ClassPathXmlApplicationContext("spring.xml");

        //得到被实例化的对象
        UseService us = (UseService) ac.getBean("useService");

        us.test1();
    }

}
~~~

## Bean对象实例化

### 构造器实例化

* 设置配置文件 spring.xml
~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="useService" class="com.zh.service.UseService"></bean>
    
</beans>
~~~

* 获取实例化对象
~~~java
    //注明：使用默认构造器创建 空构造方法必须存在 否则创建失败
    
    //得到spring上下文环境，ApplicationContext接口代表Spring IOC容器，并负责实例化，配置和组装Bean
    BeanFactory ac = new ClassPathXmlApplicationContext("spring.xml");
    //得到被实例化的对象
    UseService us = (UseService) ac.getBean("useService");
    us.test1();
~~~

### 静态方法实例化

~~~text
当我们指定Spring使用静态工厂方法创建Bean对象时，Spring将先解析配置文件，并根据配置文件指定的信息，通过反射调用静态工厂类的静态工厂方法，并将该静态方法的返回值作为Bean实例。
在这个过程中，Spring不再负责创建Bean实例，Bean实例是由用户提供的静态工厂方法提供的。
~~~


* 定义静态工厂类 StaticFactory.java
~~~java
public class StaticFactory {

    /**
     *@描述 定义静态方法，返回需要实例化的Bean对象
     */
    public static AccountService accountService(){
        return new AccountService();
    }
}
~~~

* xml文件中，注明工厂实例化方法
~~~xml
    <!--静态工厂实例化 加载Bean对象-->
    <bean id="accountService" class="com.zh.factory.StaticFactory" factory-method="accountService"/>
~~~

### 实例化工厂实例化

* 区别
~~~text
工厂方法为非静态方法
需要配置工厂bean，并在业务bean中配置factory-bean，factory-method属性
~~~

* 定义工厂类
~~~java
public class InstanceFactory {

    public UseService useService(){
        return new UseService();
    }
}
~~~

* xml文件实例化，以com.zh.factory.InstanceFactory为例
~~~xml

<!--定义实例化工厂bean，引用bean 指定工厂方法（方法为非静态）-->
<bean id="instanceFactory" class="com.zh.factory.InstanceFactory"></bean>
<bean id="useService" factory-bean="instanceFactory" factory-method="useService"></bean>
~~~

# 依赖注入 DI

## 手动注入

### set方法 注入bean对象

* 定义TypeDao.java
~~~java
public class TypeDao {

    public void test1() {
        System.out.println("TypeDao...");
    }
}
~~~

* 定义TypeService.java，service层set方法 手动注入bean对象
~~~java
public class TypeService {

    //bean对象
    private TypeDao typeDao;

    /**
     * set方法注入，需要给属性字段提供set方法
     * */
    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public void test() {
        System.out.println("TypeService....业务类");
        typeDao.test1();
    }
}
~~~

* 对应spring02.xml配置
~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="typeDao" class="com.zh.dao.TypeDao"/>
    <bean id="typeService" class="com.zh.service.TypeService">
        <!--set方法注入，通过property属性实现set方法注入-->
        <property name="typeDao" ref="typeDao"/>
    </bean>
</beans>
~~~

### 构造函数 注入bean对象

~~~text
构造器注入存在循环依赖的问题（两个bean对象互相注入），最好使用set方法注入
~~~

* service类定义有参构造函数
~~~java
public class TypeService {

    //bean对象
    private TypeDao typeDao;

    //构造器注入
    public TypeService(TypeDao typeDao) {
        this.typeDao = typeDao;
    }
    /**
     * set方法注入，需要给属性字段提供set方法
     * */
    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }
    public void test() {
        System.out.println("TypeService....业务类");
        typeDao.test1();
    }
}
~~~

* xml配置文件的bean标签内添加 constructor-arg 构造函数标签
~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="typeDao" class="com.zh.dao.TypeDao"/>
    
    <bean id="typeService" class="com.zh.service.TypeService">
        <!--构造函数注入bean对象-->
        <constructor-arg name="typeDao" ref="typeDao"/>
    </bean>
</beans>
~~~

## 自动注入

### @Resource

* 注解方式注入bean
~~~text
对于bean的注入，除了使用xml配置外，可以使用注解配置。注解的配置，可以简化配置文件，提高开发速度，使程序看上去更加简洁。
对于注解的解释，Spring对于注解的解释有专门的解释器，对定义的注解进行解析，实现对应bean对象的注入。通过反射技术实现。
~~~

* @Resource 实现bean对象自动注入
~~~text
默认会根据bean标签的id属性值查找（属性字段名与bean标签的属性值相同）
如果属性名称未找到，会根据类型（class）查找
如果注入的是接口，接口只有一个实现类时，能正常注入；如果接口有多个实现类，则需要使用name属性设置对应id值
~~~

UserDao01.java UserDao02.java 实现 IUserDao 接口

* xml文件配置
~~~xml
<bean id="userDao01" class="com.zh.dao.UserDao01"/>
<bean id="userDao02" class="com.zh.dao.UserDao02"/>
~~~

* service层配置
~~~java
@Resource(name = "userDao02")
private IUserDao iUserDao;
~~~

### @Autowired

~~~text
默认通过类型（Class）查找Bean对象，与属性字段的名称无关
属性可以提供set方法，也可以不提供set方法
注解可以声明在属性级别或set方法级别
可以添加 @Qualifier 结合使用，通过value属性值查找bean对象（value属性值必须设置，且值要与bean标签的id属性值对应）
~~~

* service层定义 bean对象别名
~~~java
    //bean对象
    @Autowired
    @Qualifier("td")
    private TypeDao typeDao;
~~~

* xml文件配置
~~~xml
    <bean id="td" class="com.zh.dao.TypeDao"/>
~~~

# IOC扫描器（自动实例化）

* 扫描器说明
~~~text
作用：bean对象统一进行管理，简化开发配置，提高开发效率

1. 设置自动化扫描的范围
    如果bean对象未在指定包范围，即使声明了注解，也无法实例化

2. 使用指定的注解（声明在类级别）  bean对象的id属性默认是：类的首字母小写
    DAO层：@Repository
    Service层：@Service
    Controller：@Controller
    任意类：@Component
~~~

* 在xml配置 自动扫描IOC的bean对象
~~~xml
    <!--开启自动扫描，设置扫描包的范围-->
    <context:component-scan base-package="com.zh"/>
~~~

#bean对象作用域和生命周期

* bean对象的作用域
~~~text
单例作用域（singleton）
    Spring容器在启动时会实例化bean对象，并将对象设置到单例缓存池中，下次获取时直接从缓存池中得到。
    scope="singleton" 默认情况下，Spring容器中加载的bean对象都是单例。
    
    lazy-init属性，表示懒加载，默认为false。
    如果为true，表示容器在启动时不会自动实例化Bean对象，而是在程序调用时才实例化Bean对象

原型作用域（prototype）
    Spring容器启动时会实例化bean对象，不会将对象设置到单例缓存池中，每次请求都会重新创建一个新的Bean对象。
    scope="prototype"
~~~

* 原型作用域
~~~xml
    <!--原型作用域-->
    <bean id="typeDao" class="com.zh.dao.TypeDao" scope="prototype" lazy-init="false"/>
~~~

* 解释

~~~text
为什么lazy-init属性默认为false?
    1. 可以提前发现配置的潜在问题
    2. Bean对象存在于缓存中，使用时不用再去实例化bean，加快程序运行效率

什么对象适合做单例？
    一般来说对于无状态或状态不可改变的对象适合做单例模式。（不存在会改变对象状态的成员变量）比如controller层、service层、dao层
    
什么是无状态或状态不可改变的对象？
    对象中不存在改变当前对象的状态的成员变量。
~~~














