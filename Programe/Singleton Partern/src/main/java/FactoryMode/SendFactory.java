package FactoryMode;

/**
 * Created by jst on 2018/4/28.
 */
public class SendFactory {

    //普通工厂模式
    public Sender Produce(String type){
           if ("mail".equals(type)){
               return new MailSend();
           }
           else if ("sms".equals(type)){
               return  new SmsSend();
           }
           else{
               System.out.print("输入的类型错误");
               return null;
           }
      }

      //多个方法工厂模式
      public Sender ProduceMainSend(){
          return new MailSend();
      }
      public Sender ProduceSmsSend(){
          return new SmsSend();
      }

      //静态工厂方法模式
      public static Sender ProduceMainSend1(){
          return new MailSend();
      }
      public static Sender ProduceSmsSend1(){
        return new SmsSend();
      }
}
