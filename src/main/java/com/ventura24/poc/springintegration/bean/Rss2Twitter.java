package com.ventura24.poc.springintegration.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by josete on 24/1/15.
 */
@Component
public class Rss2Twitter {

    private Logger LOGGER = LoggerFactory.getLogger(Rss2Twitter.class);

    @ServiceActivator
    public Message convertRss2Tweet(Message message){
        LOGGER.info(message.getPayload().toString());
        return message;
    }

}
