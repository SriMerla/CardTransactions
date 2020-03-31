package com.example.springjms;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.example.user.User;
import com.google.gson.Gson;

@Component
public class Producer {



    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String queueName, final String x) {

        jmsTemplate.send(queueName, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage();
                message.setText(x);
                return message;
            }
        });

    }

}
