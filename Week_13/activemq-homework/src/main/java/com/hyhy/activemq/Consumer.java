package com.hyhy.activemq;

import javax.jms.*;

/**
 * @Author: hyhy
 * @Date: 2021/1/11 9:00 下午
 */
public class Consumer implements Runnable {
    private Destination destination;
    private Session session;

    public Consumer(Destination destination, Session session) {
        this.destination = destination;
        this.session = session;
    }

    public void rcv() throws JMSException{
       MessageConsumer consumer = session.createConsumer(destination);
       MessageListener messageListener = new MessageListener(){

           @Override
           public void onMessage(Message message) {
               System.out.println("rcv:"+message.toString());
           }
       };
       consumer.setMessageListener(messageListener);
   }

    @Override
    public void run() {
        try {
            rcv();
        }catch (JMSException e){
            System.out.println(e);
        }

    }
}
