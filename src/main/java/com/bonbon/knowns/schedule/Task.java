package com.bonbon.knowns.schedule;

import com.bonbon.knowns.mapper.KnownsRssMapper;
import com.bonbon.knowns.model.entity.KnownsFeed;
import com.bonbon.knowns.model.entity.KnownsRss;
import com.bonbon.knowns.model.query.KnownsFeedQuery;
import com.bonbon.knowns.service.KnownsFeedService;
import com.bonbon.knowns.service.KnownsRssService;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author jiazhiyuan
 * @date 2023/8/5 12:08 PM
 */

@Component
public class Task {


    @Autowired
    private KnownsRssService knownsRssService;

    @Autowired
    private KnownsFeedService knownsFeedService;

    /**
     * 并行扫描
     */
//    @Scheduled(cron ="*/1 * * * * ?")
    public void sayWorld() throws IOException, FeedException {
        List<KnownsRss> knownsRsses = knownsRssService.list();
        for (KnownsRss knownsRss : knownsRsses) {
            Long knownsRssId = knownsRss.getId();
            KnownsFeedQuery knownsFeedQuery = new KnownsFeedQuery();
            knownsFeedQuery.setRssId(knownsRssId);
            KnownsFeed knownsFeed = knownsFeedService.selectLatestOne(knownsFeedQuery);
            if(knownsFeed == null) {
                //全量刷一遍

                URL feedUrl = new URL(knownsRss.getUrl());
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedUrl));

                System.out.println("Feed Title: " + feed.getTitle());
                System.out.println("Feed Description: " + feed.getDescription());

                List<SyndEntry> entries = feed.getEntries();
                for (SyndEntry entry : entries) {
                    System.out.println("Title: " + entry.getTitle());
                    System.out.println("Link: " + entry.getLink());
                    System.out.println("Published Date: " + entry.getPublishedDate());
                    System.out.println("Description: " + entry.getDescription().getValue());
                    System.out.println("--------------------------------------------------");
                }
            }
        }
    }
}



    
