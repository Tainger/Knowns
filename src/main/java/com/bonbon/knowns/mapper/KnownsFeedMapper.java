package com.bonbon.knowns.mapper;

import com.bonbon.knowns.model.entity.KnownsFeed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonbon.knowns.model.query.KnownsFeedQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
@Mapper
public interface KnownsFeedMapper extends BaseMapper<KnownsFeed> {

    /**
     * 查询最近更新的时间
     * @param knownsFeedQuery
     * @return
     */
    KnownsFeed selectLatestOne(KnownsFeedQuery knownsFeedQuery);
}
