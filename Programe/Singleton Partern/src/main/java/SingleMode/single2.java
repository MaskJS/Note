package SingleMode;

/**
 * Created by jst on 2018/4/28.
 */
//静态内部类  单例模式  调用getInstance()方法时才初始化，资源利用率高，但初始化慢
public class single2 {
    private single2(){}
    private static class single2Helper{
        static single2 instance=new single2();
    }
    public static single2 getInstance(){
        return single2Helper.instance;
    }
}
