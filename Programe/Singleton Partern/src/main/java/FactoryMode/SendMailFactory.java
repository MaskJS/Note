package FactoryMode;

/**
 * Created by jst on 2018/4/28.
 */
public class SendMailFactory implements Factory {
    @Override
    public Sender Produce(){
        return new MailSend();
    }
}
