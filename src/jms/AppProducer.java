package jms;

import javax.jms.*;

public class AppProducer {

    private static final String url = "tcp://127.0.0.1:61616";
    private static final String queueName="queue-test";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(queueName);
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 100; i++) {
            TextMessage message = session.createTextMessage("message"+i);
            producer.send(message);
            System.out.println("发送消息:"+message.getText());
        }
        connection.close();
    }

}