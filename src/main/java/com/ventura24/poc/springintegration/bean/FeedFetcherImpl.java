package com.ventura24.poc.springintegration.bean;

import com.rometools.fetcher.FeedFetcher;
import com.rometools.fetcher.FetcherException;
import com.rometools.fetcher.FetcherListener;
import com.rometools.fetcher.impl.HttpURLFeedFetcher;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;

import java.io.IOException;
import java.net.URL;

/**
 * Created by josete on 6/6/15.
 */
public class FeedFetcherImpl implements
        FeedFetcher {


    private FeedFetcher feedFetcher = new HttpURLFeedFetcher();

    /**
     * @param string The User-Agent to sent to servers
     */
    @Override
    public void setUserAgent(String string) {
         feedFetcher.setUserAgent(string);
    }

    /**
     * @return the User-Agent currently being sent to servers
     */
    @Override
    public String getUserAgent() {
        return null;
    }

    /**
     * <p>
     * Turn on or off rfc3229 delta encoding
     * </p>
     * <p/>
     * <p>
     * See http://www.ietf.org/rfc/rfc3229.txt and
     * http://bobwyman.pubsub.com/main/2004/09/using_rfc3229_w.html
     * </p>
     * <p/>
     * <p>
     * NOTE: This is experimental and feedback is welcome!
     * </p>
     *
     * @param useDeltaEncoding
     */
    @Override
    public void setUsingDeltaEncoding(boolean useDeltaEncoding) {
         feedFetcher.setUsingDeltaEncoding(true);
    }

    /**
     * <p>
     * Is this fetcher using rfc3229 delta encoding?
     * </p>
     *
     * @return
     */
    @Override
    public boolean isUsingDeltaEncoding() {
        return true;
    }

    /**
     * <p>
     * Add a FetcherListener.
     * </p>
     * <p/>
     * <p>
     * The FetcherListener will receive an FetcherEvent when a Fetcher event (feed polled,
     * retrieved, etc) occurs
     * </p>
     *
     * @param listener The FetcherListener to recieve the event
     */
    @Override
    public void addFetcherEventListener(FetcherListener listener) {
            feedFetcher.addFetcherEventListener(listener);
    }

    /**
     * <p>
     * Remove a FetcherListener
     * </p>
     *
     * @param listener The FetcherListener to remove
     */
    @Override
    public void removeFetcherEventListener(FetcherListener listener) {
           feedFetcher.removeFetcherEventListener(listener);
    }

    /**
     * Retrieve a feed over HTTP
     *
     * @param feedUrl A non-null URL of a RSS/Atom feed to retrieve
     * @return A {@link SyndFeed} object
     * @throws IllegalArgumentException if the URL is null;
     * @throws IOException              if a TCP error occurs
     * @throws FeedException            if the feed is not valid
     * @throws FetcherException         if a HTTP error occurred
     */
    @Override
    public SyndFeed retrieveFeed(URL feedUrl) throws IllegalArgumentException, IOException, FeedException, FetcherException {
        return feedFetcher.retrieveFeed(feedUrl);
    }

    @Override
    public SyndFeed retrieveFeed(String userAgent, URL url) throws IllegalArgumentException, IOException, FeedException, FetcherException {
        return feedFetcher.retrieveFeed(userAgent,url);
    }

    /**
     * If set to true, the WireFeed will be made accessible from the SyndFeed object returned from
     * the Fetcher via the originalWireFeed() method. Each Entry in the feed will have the
     * corresponding wireEntry property set.
     *
     * @param preserveWireFeed
     */
    @Override
    public void setPreserveWireFeed(boolean preserveWireFeed) {
              feedFetcher.setPreserveWireFeed(preserveWireFeed);
    }
}
