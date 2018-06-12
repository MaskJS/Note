一、Java下Mybatis处理集合、循环、数组和in查询等语句的使用
{
	主要采用foreach
	foreach的参数：
	foreach元素的属性主要有 item，index，collection，open，separator，close。
	item表示集合中每一个元素进行迭代时的别名.
	index指 定一个名字，用于表示在迭代过程中，每次迭代到的位置.
	open表示该语句以什么开始，separator表示在每次进行迭代之间以什么符号作为分隔 符.
	close表示以什么结束

	 <![CDATA[ <> ]]>
	 
	1、in查询
	java代码：public abstract List<Model> findByIds(@Param("ids")List<Integer> ids);
	xml:
	select * from table
	<where>
		id in <foreach collection="ids" item="item" index="index" 
	open="(" separator="," close=")">#{item}</foreach>
	</where>
	2、保存多条记录
	java:public abstract void saves(@Param("tables")List<Model> tables);
	xml:
	insert into table(name,addtime) values
	<foreach collection="tables" item="item" index="index" separator=",">  
		(#{item.name},#{item.addtime})
	</foreach>
	3、判断集合是否有值
	xml:<if test="list!=null and list.size()>0"></if>
}
二、时间操作  Date now=new Date();
{
   引用包：java.text.SimpleDateFormat
   用法： SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
   1、字符串转时间： Date date = sdf.parse( " 2008-07-10 19:20:00 " );
   2、日期转字符串： String nowTime = sdf.format(new Date());

   Calendar 类的使用
   Calendar cal = Calendar.getInstance（）；//得到当前时间 
   cal.setTimeInMillis（0）；//转换成格林威治时间  GMT+8   东八区
   cal.get（Calendar.YEAR）；//年 
   cal.get（Calendar.MONTH） + 1;//月（必须要+1） 
   cal.get（Calendar.DATE）；//日 
   cal.get（Calendar.HOUR_OF_DAY）；//时 
   cal.get（Calendar.MINUTE）；//分 
   cal.get（Calendar.SECOND）；//秒 
   cal.get（Calendar.DAY_OF_WEEK）；//星期（Locale.ENGLISH情况下，周日是1）
   设置值 
   cal.set（2013, 5, 4, 13, 44, 51）；//年月日时分秒（月份0代表1月） 
   cal.set（Calendar.YEAR, 2014）；//年 
   cal.set（Calendar.MONTH, 7）；//月（月份0代表1月） 
   cal.set（Calendar.DATE, 11）；//日 
   cal.set（Calendar.HOUR_OF_DAY, 15）；//时 
   cal.set（Calendar.MINUTE, 33）；//分 
   cal.set（Calendar.SECOND, 32）；//秒 
   运算值 
   cal.add（Calendar.YEAR, 1）；//年 
   cal.add（Calendar.MONTH, 1）；//月 
   cal.add（Calendar.DATE, 1）；//日 
   cal.add（Calendar.HOUR_OF_DAY, -1）；//时 
   cal.add（Calendar.MINUTE, 1）；//分 
   cal.add（Calendar.SECOND, 1）；//秒 
   cal.add（Calendar.DATE, 7）；//周
}
三、数据库相关
	informix驱动器：com.informix.jdbc.IfxDriver
	oracle驱动器：oracle.jdbc.driver.OracleDriver
    String path = System.getProperty("user.dir") + "\\mybatis-config.xml";
    sessionFactory = new SqlSessionFactoryBuilder().build(new InputStreamReader(new FileInputStream(path), "UTF-8"));
    
	oracle连接字符串  用反斜杠 \    jdbc:oracle:thin:@192.168.10.36:1521\NSCS
	
四、基本语法
{
1、StringUtils.stripEnd（） 从第一个字符串中 去除第二个字符串中含有的所有字符   
    StringUtils.stripEnd("  abcyx", "xyz") = "  abc"
	
2、StringUtils.isBlank（） 判断某字符串是否为空或长度为0或由空白符(whitespace) 构成    
   StringUtils.isBlank(null) = true
   StringUtils.isBlank("") = true
   StringUtils.isBlank("        ") = true
   StringUtils.isBlank("\t \n \f \r") = true   //对于制表符、换行符、换页符和回车符
   StringUtils.isBlank("123") = false
   
3、StringUtils.isEmpty 判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
   StringUtils.isEmpty(null) = true
   StringUtils.isEmpty("") = true
   StringUtils.isEmpty(" ") = false //注意在 StringUtils 中空格作非空处理 
   
4、Scanner  java.util.Scanner是Java5的新特征，主要功能是简化文本扫描   

5、Map定义  Map<String,Object> param=new HashMap();   param.put("","");

6、super指针 指向自己超（父）类对象的一个指针，而这个超类指的是离自己最近的一个父类
   super(); // 调用父类构造方法
   super.XX //引用父类成员
  
   this 指针  指向当前对象
   
7、不定长度参数 ...
   不定参数有两个规定：第一，方法的参数列表中最多只有一个不定长度的参数；第二，就是不定长度的数组的位置必须是最后一个参数。不然不能通过编译。
   public class VariArgs {  
  
    public static void main(String[] args) {  
        test("aaa");  
        test("aaa", "bbb");  
        test("aaa", "bbb", "ccc");  
    }  
  
    public static void test(String arg, String... args) {  
        System.out.println(arg);  
        System.out.println("----------------");  
        for (String s : args) {  
            System.out.println(s);  
        }  
    }  
}  

8、字符串格式化
http://blog.csdn.net/lonely_fireworks/article/details/7962171/

9、字符串转换
   1）转整形
   int x=Integer.parseInt(str);
   
   2）将字符串转为字节流
   String LoginCmd="";
   ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(LoginCmd.getBytes());
   
10、extends和implements  
   extends是继承某个类, 继承之后可以使用父类的方法, 也可以重写父类的方法
   implements是实现多个接口, 接口的方法一般为空的, 必须重写才能使用 
   
    extends是继承父类，只要那个类不是声明为final或者那个类定义为abstract的就能继承
	JAVA中不支持多重继承，但是可以用接口 来实现，这样就要用到implements，继承只能继承一个类，
	但implements可以实现多个接口，用逗号分开就行了 比如 ：
	class A extends B implements C,D,E
	   
11、synchronized 类加锁，线程安全   不能锁空指针  即：synchronized（null）会报错
   private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new SingletonTest();  
        }  
    }  
   //
   public static Singleton getInstance() {  
        if (instance == null) {  
            synchronized (instance) {  
                if (instance == null) {  
                    instance = new Singleton();  
                }  
            }  
        }  
        return instance;  
    } 
     
12、 单精度和双精度
float型float f=3.4是否正确    --错误，因为3.4是double类型， 大范围不能向小范围转换，应该用强制转换，即： float f=(float)3.4

在java里面，没小数点的默认是int,有小数点的默认是 double;    


基本数据类型 		包装类
byte  				Byte
boolean				Boolean
short				Short
char				Character
int					Integer
long				Long
float				Float
double				Double  
}	
valueOf() 装箱
intValue() 拆箱

13、





五、文件操作
{
1、java中获取当前根目录文件   
   String path = System.getProperty("user.dir") + "\\config.properties";
   File file = new File(path);
    Properties prop = new Properties();
	if (file.exists()) {
		prop.load(new InputStreamReader(new FileInputStream(path),"gbk"));
	} else {
		prop.load(Object.class.getResourceAsStream("/config.properties"));
	}
	String index = prop.getProperty("IndexSql").trim();
    
	或者
	
	Properties prop = new Properties();
            BufferedReader br=null;
            if (file.exists()) {
                br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"GBK"));
            } else {
                br=new BufferedReader(new InputStreamReader(Object.class.getResourceAsStream("/config.properties"),"GBK"));
            }
            prop.load(br);
			
2、写文件
{
    FileOutputStream out=new FileOutputStream(new File(“C:/add.txt”));
    out.write(“测试java 文件操作\r\n”.getBytes());     
	
}
3、获取文件目录
{
    1)、"user.dir" 获取当前的目录工程路径（Tomcat中获取的是bin路径）
	String path = System.getProperty("user.dir") + "\\mybatis-config.xml";
	
	2)、"catalina.home" Tomcat 安装目录，一般是用来查找库 jar 的
	System.getProperty("catalina.home")
	
	
	********************************************************************************************************************************
	System.out.println("java版本号：" + System.getProperty("java.version")); // java版本号
	System.out.println("Java提供商名称：" + System.getProperty("java.vendor")); // Java提供商名称
	System.out.println("Java提供商网站：" + System.getProperty("java.vendor.url")); // Java提供商网站
	System.out.println("jre目录：" + System.getProperty("java.home")); // Java，哦，应该是jre目录
	System.out.println("Java虚拟机规范版本号：" + System.getProperty("java.vm.specification.version")); // Java虚拟机规范版本号
	System.out.println("Java虚拟机规范提供商：" + System.getProperty("java.vm.specification.vendor")); // Java虚拟机规范提供商
	System.out.println("Java虚拟机规范名称：" + System.getProperty("java.vm.specification.name")); // Java虚拟机规范名称
	System.out.println("Java虚拟机版本号：" + System.getProperty("java.vm.version")); // Java虚拟机版本号
	System.out.println("Java虚拟机提供商：" + System.getProperty("java.vm.vendor")); // Java虚拟机提供商
	System.out.println("Java虚拟机名称：" + System.getProperty("java.vm.name")); // Java虚拟机名称
	System.out.println("Java规范版本号：" + System.getProperty("java.specification.version")); // Java规范版本号
	System.out.println("Java规范提供商：" + System.getProperty("java.specification.vendor")); // Java规范提供商
	System.out.println("Java规范名称：" + System.getProperty("java.specification.name")); // Java规范名称
	System.out.println("Java类版本号：" + System.getProperty("java.class.version")); // Java类版本号
	System.out.println("Java类路径：" + System.getProperty("java.class.path")); // Java类路径
	System.out.println("Java lib路径：" + System.getProperty("java.library.path")); // Java lib路径
	System.out.println("Java输入输出临时路径：" + System.getProperty("java.io.tmpdir")); // Java输入输出临时路径
	System.out.println("Java编译器：" + System.getProperty("java.compiler")); // Java编译器
	System.out.println("Java执行路径：" + System.getProperty("java.ext.dirs")); // Java执行路径
	System.out.println("操作系统名称：" + System.getProperty("os.name")); // 操作系统名称
	System.out.println("操作系统的架构：" + System.getProperty("os.arch")); // 操作系统的架构
	System.out.println("操作系统版本号：" + System.getProperty("os.version")); // 操作系统版本号
	System.out.println("文件分隔符：" + System.getProperty("file.separator")); // 文件分隔符
	System.out.println("路径分隔符：" + System.getProperty("path.separator")); // 路径分隔符
	System.out.println("直线分隔符：" + System.getProperty("line.separator")); // 直线分隔符
	System.out.println("操作系统用户名：" + System.getProperty("user.name")); // 用户名
	System.out.println("操作系统用户的主目录：" + System.getProperty("user.home")); // 用户的主目录
	System.out.println("当前程序所在目录：" + System.getProperty("user.dir")); // 当前程序所在目录
	********************************************************************************************************************************
}	

4.读取xml配置文件()
        //读取配置文件
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext2.xml");
        Zoo zoo=(Zoo) ctx.getBean("zoo");
        System.out.println(zoo.toString());
}		
六、Webservice添加WSDL文件

set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_26  安装JDK的根目录
回车
set classpath=%JAVA_HOME%\lib\tools.jar;%JAVA_HOME%\lib\dt.jar;
回车
set path=%JAVA_HOME%\bin; 
回车

   wsimport -s G:\test\javaWebService\com.boco.theservice\src -p com.boco.phoneservice -keep F:\sichuan\底层数据处理和分析\短信发送服务\Boco.SendPhoneMessage.Service\wsdl\SMSService.wsdl
   
七、注解   扫描包 <context:component-scan base-package="cn.test"/> 
1、@Autowired 自动匹配注解
2、@Qualifiter 指定名称注解 eg:@Qualifier("bmwCar") 会注入名为"bmwCar"的Bean
3、@Resource 和Autowired类似   
	(1)、@Resource后面没有任何内容，默认通过name属性去匹配bean，找不到再按type去匹配
	(2)、指定了name或者type则根据指定的类型去匹配bean
	(3)、指定了name和type则根据指定的name和type去匹配bean，任何一个不匹配都将报错

	然后，区分一下@Autowired和@Resource两个注解的区别：
	(1)、@Autowired默认按照byType方式进行bean匹配，@Resource默认按照byName方式进行bean匹配
	(2)、@Autowired是Spring的注解，@Resource是J2EE的注解，这个看一下导入注解的时候这两个注解的包名就一清二楚了
4、@Service
	(1)、声明Zoo.java是一个bean，这点很重要，因为Zoo.java是一个bean，其他的类才可以使用@Autowired将Zoo作为一个成员变量自动注入。
	(2)、Zoo.java在bean中的id是"zoo"，即类名且首字母小写	   
5、@Scope("prototype")   
   默认是"singleton"即单例，"prototype"表示原型即每次都会new一个新的出来
************************************************************************************************************************************   
   使用注解来构造IoC容器
   如果某个类的头上带有特定的注解【@Component/@Repository/@Service/@Controller】，就会将这个对象作为Bean注册进Spring容器。也可以在<context:component-scan base-package=” ”/>中指定多个包，如：
   <context:component-scan base-package="cn.gacl.dao.impl,cn.gacl.service.impl,cn.gacl.action"/>

6、@Controller   对应表现层的Bean，也就是Action
    @Controller
	@Scope("prototype")
	public class UserAction extends BaseAction<User>{
	 ……
	}
   
   使用@Controller注解标识UserAction之后，就表示要把UserAction交给Spring容器管理，在Spring容器中会存在一个名字为"userAction"的action，这个名字是根据UserAction类名来取的。注意：如果@Controller不指定其value【@Controller】，则默认的bean名字为这个类的类名首字母小写，如果指定value【@Controller(value="UserAction")】或者【@Controller("UserAction")】，则使用value作为bean的名字。
   
   @Scope("prototype")表示将Action的范围声明为原型,scope="prototype" 可以保证当有请求的时候都创建一个Action对象,确保数据安全
   
7、@Service 对应的是业务层Bean
8、@Repository 对应数据访问层Bean   
 
 ///////////////////////////////////
Spring常用注解汇总 
本文汇总了Spring的常用注解，以方便大家查询和使用，具体如下：

使用注解之前要开启自动扫描功能，其中base-package为需要扫描的包(含子包)。
<context:component-scan base-package="cn.test"/> 
@Configuration把一个类作为一个IoC容器，它的某个方法头上如果注册了@Bean，就会作为这个Spring容器中的Bean。
@Scope注解 作用域
@Lazy(true) 表示延迟初始化
@Service用于标注业务层组件、 
@Controller用于标注控制层组件（如struts中的action）
@Repository用于标注数据访问组件，即DAO组件。
@Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
@Scope用于指定scope作用域的（用在类上）
@PostConstruct用于指定初始化方法（用在方法上）
@PreDestory用于指定销毁方法（用在方法上）
@DependsOn：定义Bean初始化及销毁时的顺序
@Primary：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
@Autowired 默认按类型装配，如果我们想使用按名称装配，可以结合@Qualifier注解一起使用。如下：
@Autowired @Qualifier("personDaoBean") 存在多个实例配合使用
@Resource默认按名称装配，当找不到与名称匹配的bean才会按类型装配。
@PostConstruct 初始化注解
@PreDestroy 摧毁注解 默认 单例  启动就加载
@Async异步方法调用 
   
   
//注意导入的包都是slf4j的包
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        LOGGER.trace("logback的--trace日志--输出了");
        LOGGER.debug("logback的--debug日志--输出了");
        LOGGER.info("logback的--info日志--输出了");
        LOGGER.warn("logback的--warn日志--输出了");
        LOGGER.error("logback的--error日志--输出了");
    }

}   


八、java打包区别
war包:是做好一个web应用后，通常是网站，打成包部署到容器中。
jar包：通常是开发时要引用通用类，打成包便于存放管理。
ear包：企业级应用，通常是EJB打成ear包。
war是一个web模块，其中需要包括WEB-INF，是可以直接运行的WEB模块。而jar一般只是包括一些class文件，在声明了Main_class之后是可以用java命令运行的.

































   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
单例模式（饿汉式）   
public class SingleMode{
	private SingleMode(){}
	private static SingleMode instance=new SingleMode();
	public static SingleMode getInstance(){
		return instance;
	}
}   
静态内部类
public class SingleMode1{
	private SingleMode1(){}
	private static class SingleModeHelper{
		static SingleMode1 instance=SingleMode1();
	}
	public static SingMode1 getInstance(){
		return SingleModeHelper.instance;
	}
} 
   
   
   
   
   
   
   
   



   