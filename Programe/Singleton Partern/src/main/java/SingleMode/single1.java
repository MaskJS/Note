package SingleMode;

/**
 * Created by jst on 2018/4/28.
 */
//饿汉式 单例模式  类加载时就初始化好，调用更快，线程安全
public class single1 {
    private single1(){}
    private static single1 instance=new single1();
    public static single1 getInstance(){return  instance;}
}
