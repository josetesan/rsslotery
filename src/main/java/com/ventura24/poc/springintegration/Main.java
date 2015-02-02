package com.ventura24.poc.springintegration;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by josete on 24/1/15.
 */
@SpringBootApplication
@ImportResource("applicationContext.xml")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    private void test()
    {
        String url = "https://www.ventura24.es/blog/feed";

        try {
            InputStream is = new URL(url).openConnection().getInputStream();
            InputSource source = new InputSource(is);
            source.setEncoding("utf-8");
            System.out.println(source.getEncoding());

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(source);

            System.out.println("description: " + feed.getDescription());
        } catch (final Exception t){
            t.printStackTrace();
        }
    }
}

