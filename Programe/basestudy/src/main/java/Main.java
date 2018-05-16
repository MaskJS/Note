/**
 * Created by jst on 2018/5/16.
 */
public class Main {
    public static void main(String[] args){



        String a="abcdef";
        String b=a.replace("a","");
        System.out.println(b);
    }

    public String re(String str,char c){
        return str.replaceAll(Character.toString(c),"");
    }


//    synchronized  同步
}
