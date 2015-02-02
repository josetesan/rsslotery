package com.ventura24.poc.springintegration.bean;

import com.rometools.rome.feed.synd.SyndEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

/**
 * Created by josete on 24/1/15.
 */
@Component
public class Rss2Twitter {

    private Logger LOGGER = LoggerFactory.getLogger(Rss2Twitter.class);

    @Transformer
    public Message convertRss2Tweet(Message<SyndEntry> message){
        LOGGER.info(message.getPayload().getTitle());

        return new GenericMessage(message.getPayload().getTitle());
    }

}
