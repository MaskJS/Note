package BuilderMode;

import FactoryMode.MailSend;
import FactoryMode.Sender;
import FactoryMode.SmsSend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jst on 2018/4/28.
 */
//建造者模式
//与工程模式的区别就是：工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分
public class Builder {
    private List<Sender> list=new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSend());
        }
        for(Sender s: list){
            s.Send();
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSend());
        }
        for(Sender s: list){
            s.Send();
        }
    }
}
