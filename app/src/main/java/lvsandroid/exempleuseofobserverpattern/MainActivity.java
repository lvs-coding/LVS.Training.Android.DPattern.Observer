package lvsandroid.exempleuseofobserverpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lvsandroid.exempleuseofobserverpattern.Interfaces.Observer;
import lvsandroid.exempleuseofobserverpattern.Models.MyTopic;
import lvsandroid.exempleuseofobserverpattern.Models.MyTopicSubscriber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create subject
        MyTopic topic = new MyTopic();

        //create observers
        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");

        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        //attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        //check if any update is available
        obj1.update();

        //now send message to subject
        topic.postMessage("New Message");
    }
}
