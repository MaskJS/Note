package FactoryMode;

/**
 * Created by jst on 2018/4/28.
 */
public class SendSmsFactory implements Factory {
    @Override
    public Sender Produce(){
        return new SmsSend();
    }
}
