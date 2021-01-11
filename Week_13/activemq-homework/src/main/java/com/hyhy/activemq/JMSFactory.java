package com.hyhy.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @Author: hyhy
 * @Date: 2021/1/11 8:51 下午
 */
public class JMSFactory {
    private Session session;
    private String uri;
    private Boolean transacted;

    public JMSFactory(String uri, Boolean transacted) {
        this.uri = uri;
        this.transacted = transacted;
    }

    public void createSession() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(uri);
        Connection connection = factory.createConnection();
        connection.start();
        session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);
    }

    public Session getSession() throws JMSException {
        if (session == null) {
           createSession();
        }
        return session;
    }

}
