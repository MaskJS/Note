package FactoryMode;

/**
 * Created by jst on 2018/4/28.
 */
public class MailSend implements Sender {
    @Override
    public void Send(){
        System.out.println("This is Mail Sender!");
    }
}
