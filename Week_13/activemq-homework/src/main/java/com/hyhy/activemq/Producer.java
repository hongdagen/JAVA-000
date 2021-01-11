package com.hyhy.activemq;

import javax.jms.*;

/**
 * @Author: hyhy
 * @Date: 2021/1/11 8:57 下午
 */
public class Producer implements Runnable {
    private Destination destination;
    private Session session;

    public Producer(Destination destination, Session session) {
        this.destination = destination;
        this.session = session;
    }

    public void send() throws JMSException {
        MessageProducer producer = session.createProducer(destination);
        int index = 0;
        while (index++ < 100) {
            TextMessage message = session.createTextMessage(index + " message.");
            producer.send(message);
        }
    }

    @Override
    public void run() {
        try {
            send();
        }catch (JMSException e){
            System.out.println(e);
        }
    }
}
