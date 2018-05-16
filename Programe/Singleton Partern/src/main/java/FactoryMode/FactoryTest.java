package FactoryMode;

/**
 * Created by jst on 2018/4/28.
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory fac = new SendFactory();
        Sender send = fac.Produce("sms");
        send.Send();
        //***   多个方法
        Sender send1=fac.ProduceMainSend();
        send1.Send();
        //***  调用静态方法
        Sender send2=SendFactory.ProduceMainSend1();
        send2.Send();

        //*** 抽象工厂模式
        Factory sfac=new SendMailFactory();
        Sender sd=sfac.Produce();
        sd.Send();
    }
}
