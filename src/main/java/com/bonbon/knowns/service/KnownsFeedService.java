package com.bonbon.knowns.service;

import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.model.entity.KnownsFeed;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.validation.Valid;

import com.bonbon.knowns.model.query.KnownsFeedQuery;
import com.rometools.rome.io.FeedException;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
@Validated
public interface KnownsFeedService extends IService<KnownsFeed> {


    /**
     * 查询最新的 KnownsFeed
     * @param knownsFeedQuery
     * @return
     */
    KnownsFeed selectLatestOne(KnownsFeedQuery knownsFeedQuery);

    Result add(KnownsRssDTO knownsRssDTO);

    /**
     * 刷新feed
     * @return
     */
    Result refresh() throws IOException, FeedException;
}
