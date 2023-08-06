package com.bonbon.knowns.service.impl;

import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.model.entity.KnownsFeed;
import com.bonbon.knowns.mapper.KnownsFeedMapper;
import com.bonbon.knowns.model.entity.KnownsRss;
import com.bonbon.knowns.model.query.KnownsFeedQuery;
import com.bonbon.knowns.service.KnownsFeedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonbon.knowns.service.KnownsRssService;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
@Service
public class KnownsFeedServiceImpl extends ServiceImpl<KnownsFeedMapper, KnownsFeed> implements KnownsFeedService {


    @Autowired
    private KnownsFeedMapper knownsFeedMapper;

    @Autowired
    private KnownsRssService knownsRssService;



    @Override
    public KnownsFeed selectLatestOne(KnownsFeedQuery knownsFeedQuery) {
        return knownsFeedMapper.selectLatestOne(knownsFeedQuery);
    }

    @Override
    public Result<Void> add(KnownsRssDTO knownsRssDTO) {
        KnownsFeed knownsFeed = new KnownsFeed();
         knownsFeedMapper.insert(knownsFeed);
        return Result.OK();
    }

    @Override
    public Result refresh() throws IOException, FeedException {

        List<KnownsRss> knownsRsses = knownsRssService.list();
        for (KnownsRss knownsRss : knownsRsses) {
            Long knownsRssId = knownsRss.getId();
            KnownsFeedQuery knownsFeedQuery = new KnownsFeedQuery();
            knownsFeedQuery.setRssId(knownsRssId);
            KnownsFeed knownsFeed = this.selectLatestOne(knownsFeedQuery);
            if(knownsFeed == null) {
                //全量刷一遍

                URL feedUrl = new URL(knownsRss.getUrl());
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedUrl));
                List<SyndEntry> entries = feed.getEntries();

                List<KnownsFeed> knownsFeeds = new ArrayList<>();
                for (SyndEntry entry : entries) {
                    KnownsFeed item = new KnownsFeed();
                    item.setLink(entry.getLink());
                    item.setRssId(knownsRssId);
                    item.setAuthor(entry.getAuthor());
                    item.setSummary(entry.getDescription().getValue());
                    knownsFeeds.add(item);
                }
                this.saveBatch(knownsFeeds);
            }
        }
        return Result.OK();
    }
}
