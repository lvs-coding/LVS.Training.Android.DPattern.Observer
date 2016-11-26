package lvsandroid.exempleuseofobserverpattern.Models;

import android.util.Log;

import lvsandroid.exempleuseofobserverpattern.Interfaces.Observer;
import lvsandroid.exempleuseofobserverpattern.Interfaces.Subject;

public class MyTopicSubscriber implements Observer {

    private String name;
    private Subject topic;

    public MyTopicSubscriber(String nm){
        this.name=nm;
    }
    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            Log.i("MYAPP",name+":: No new message");
        }else
            Log.i("MYAPP",name+":: Consuming message::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }

}
