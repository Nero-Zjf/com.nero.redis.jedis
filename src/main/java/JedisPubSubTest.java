import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class JedisPubSubTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);//指定Redis服务Host和port
        jedis.subscribe(new MyListener(),"myChannel");
    }
}

class MyListener extends JedisPubSub {
    public void onMessage(String channel, String message) {
        System.out.println(message);
    }

    public void onSubscribe(String channel, int subscribedChannels) {
    }

    public void onUnsubscribe(String channel, int subscribedChannels) {
    }

    public void onPSubscribe(String pattern, int subscribedChannels) {
    }

    public void onPUnsubscribe(String pattern, int subscribedChannels) {
    }

    public void onPMessage(String pattern, String channel, String message) {
    }
}
