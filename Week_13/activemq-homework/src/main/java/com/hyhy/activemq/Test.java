package com.hyhy.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @Author: hyhy
 * @Date: 2021/1/11 9:05 下午
 */
public class Test {
    public static void main(String[] args) {
        Session session = null;
        try {
            JMSFactory jmsFactory = new JMSFactory("tcp://127.0.0.1:61616", false);
            session = jmsFactory.getSession();

            ActiveMQTopic dest = new ActiveMQTopic("testtopic");
            // ActiveMQQueue dest = new ActiveMQQueue("testqueue");

            Thread consumer = new Thread(new Consumer(dest, session));
            consumer.start();

            Thread producer = new Thread(new Producer(dest, session));
            producer.start();
            Thread.sleep(100000);
        } catch (JMSException | InterruptedException e) {
            System.out.println(e);
        } finally {
            try {
                session.close();
            } catch (JMSException e) {

            }
        }

    }
}
