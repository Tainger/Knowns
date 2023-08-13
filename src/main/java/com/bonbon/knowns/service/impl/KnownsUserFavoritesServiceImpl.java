package com.bonbon.knowns.service.impl;

import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.configuration.context.UserContext;
import com.bonbon.knowns.mapper.KnownsFeedMapper;
import com.bonbon.knowns.mapper.KnownsUserMapper;
import com.bonbon.knowns.model.dto.KnownsUserDTO;
import com.bonbon.knowns.model.dto.KnownsUserFavoritesDTO;
import com.bonbon.knowns.model.entity.KnownsFeed;
import com.bonbon.knowns.model.entity.KnownsUser;
import com.bonbon.knowns.model.entity.KnownsUserFavorites;
import com.bonbon.knowns.mapper.KnownsUserFavoritesMapper;
import com.bonbon.knowns.model.query.KnownsFeedQuery;
import com.bonbon.knowns.model.query.KnownsUserFavoritesQuery;
import com.bonbon.knowns.model.query.KnownsUserQuery;
import com.bonbon.knowns.model.vo.Auth;
import com.bonbon.knowns.service.KnownsUserFavoritesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonbon.knowns.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户收藏表 服务实现类
 * </p>
 *
 * @author rocky
 * @since 2023-08-11
 */
@Service
public class KnownsUserFavoritesServiceImpl extends ServiceImpl<KnownsUserFavoritesMapper, KnownsUserFavorites> implements KnownsUserFavoritesService {


    @Autowired
    private KnownsUserMapper knownsUserMapper;


    @Autowired
    private KnownsFeedMapper knownsFeedMapper;

    @Autowired
    private KnownsUserFavoritesMapper knownsUserFavoritesMapper;

    @Override
    @Transactional
    public Result favorite(KnownsUserFavoritesDTO knownsUserFavoritesDTO) {
        String url = knownsUserFavoritesDTO.getUrl();
        if(StringUtils.isEmpty(url)) {
            return Result.fail("收藏url的不能为空");
        }
        KnownsFeedQuery knownsFeedQuery = new KnownsFeedQuery();
        knownsFeedQuery.setUrl(url);
        KnownsFeed knownsFeed = knownsFeedMapper.selectLatestOne(knownsFeedQuery);
        //feed没有
        long feedId;
        if(null == knownsFeed) {
            knownsFeed = new KnownsFeed();
            knownsFeed.setLink(url);
            feedId = knownsFeedMapper.insert(knownsFeed);
        }else {
            feedId = knownsFeed.getId();
        }
        KnownsUserFavorites knownsUserFavorite = new KnownsUserFavorites();
        knownsUserFavorite.setFeedId(feedId);
        knownsUserFavorite.setUserId(UserContext.getUser().getId());
        knownsUserFavoritesMapper.insert(knownsUserFavorite);
        return Result.OK();
    }

    @Override
    public Result login(KnownsUserDTO knownsUserDTO) {
        String username = knownsUserDTO.getUsername();
        if(StringUtils.isEmpty(username)) {
            return Result.fail("用户名为空");
        }
        KnownsUserQuery knownsUserQuery = new KnownsUserQuery();
        knownsUserQuery.setUsername(username);
        KnownsUser knownsUser = knownsUserMapper.query(knownsUserQuery);
        if(null == knownsUser) {
            return Result.fail("用户不存在");
        }
        String token = TokenUtil.getToken(knownsUser);
        return Result.OK(token);
    }
}
