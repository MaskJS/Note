package FactoryMode;

/**
 * Created by jst on 2018/4/28.
 */
public class SmsSend implements Sender{
    @Override
    public void Send(){
        System.out.println("This is Sms Send!");
    }
}
