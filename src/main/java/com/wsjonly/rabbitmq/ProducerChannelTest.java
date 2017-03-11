package com.wsjonly.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by shijinweng on 2017/1/17.
 */
public class ProducerChannelTest {
    public static void main(String args[]) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();


        factory.setHost("10.4.245.5");
        factory.setPort(5672);
        factory.setUsername("mtmq_waimai");
        factory.setPassword("mtmq_waimai");
        factory.setVirtualHost("waimai");
        Connection connection = factory.newConnection();
        Channel channelOlder = null;
        Channel channel = connection.createChannel();
        int i = 0;
        while (i < 100) {
            String message = "123";
            channel.basicPublish("waimai.wengshijin2.exchange", "waimai.wengshijin", null, message.getBytes());
            i++;
            System.out.println(" [" + i + "] Sent '" + "waimai.wengshijin2" + "':'" + message + "'");
//            System.out.println("[" + i + "]" + channel.getChannelNumber());
//            Thread.sleep(1000 * 5);
//            if (channelOlder != null) {
//                channelOlder.close();
//            }
//            channelOlder = channel;
        }

//        Thread.sleep(1000*60*5);
//        connection.close();
        connection.close();

    }
}