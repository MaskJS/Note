/**
 * Created by jst on 2018/5/16.
 */
public class StringFZ {
    //字符串反转 StringBuffer 并发安全
    public static String reverse(String str){
        if(null==str||str.length()<1){
            return str;
        }
        return new StringBuffer(str).reverse().toString();
    }

    public static String reverse1(String str){
        if(null==str||str.length()<1){
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }

    //递归
    public static String reverse2(String str){
        if(null==str||str.length()<1){
            return str;
        }
        return reverse2(str.substring(1)+str.charAt(0));
    }
}
