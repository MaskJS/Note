/**
 * Created by jst on 2018/5/16.
 */
public class StringEg {
    public static void S(){
        String a="abc";
        String b=new String("abc");
        System.out.println("1");
        System.out.println(a==b);
        System.out.println(a.equals(b));
//        String 的 equals 方法有被重写为值判断
        System.out.println("2");
        System.out.println("abc"==a.substring(0));
        System.out.println("bc"==a.substring(1));
//        substring 方法实现里面有个 index == 0 的判断，当 index 等于 0 就直接返回当前对象，否则新 new 一个 sub 的对象返回
        System.out.println("3");
        String c="BCD";
        String d="bcd".toUpperCase();
        System.out.println(c==d);
        System.out.println(c.equals(d));
//        toUpperCase 方法内部创建了新字符串对象
        System.out.println("4");
        String e="abc";
        final String f="bc";
        String g="a"+f;
        final String h="a"+GetB();    //同理 final String h="a"+new String("bc");
        System.out.println(a==g);
        System.out.println(a==h);

        String i="a";
        String j="b";
        String l=i+j;
        String m="ab";
        System.out.println(l==m);
        System.out.println(l.intern()==m);
        System.out.println(l=m.intern());
//        调用 intern 方法如果字符串常量池中已经包含一个等于此 String 对象的字符串（用 equals(Object) 方法确定）则返回字符串常量池中的字符串，否则将此 String 对象添加到字符串常量池中，并返回此 String 对象的引用

    }
    private static String GetB(){
        return "bc";
    }


}
