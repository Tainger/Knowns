package com.bonbon.knowns.mapper;

import com.bonbon.knowns.model.entity.KnownsRss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonbon.knowns.model.query.KnownsRssQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
@Mapper
public interface KnownsRssMapper extends BaseMapper<KnownsRss> {


    /**
     *
     * @param knownsRssQuery
     * @return
     */
    List<KnownsRss> query(KnownsRssQuery knownsRssQuery);
}
