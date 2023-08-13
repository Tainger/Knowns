package com.bonbon.knowns.service.impl;

import com.bonbon.knowns.common.repsonse.PageResult;
import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.compose.KnownsRssCompose;
import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.model.dto.KnownsRssPageDTO;
import com.bonbon.knowns.model.entity.KnownsRss;
import com.bonbon.knowns.mapper.KnownsRssMapper;
import com.bonbon.knowns.model.query.KnownsRssQuery;
import com.bonbon.knowns.service.KnownsRssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class KnownsRssServiceImpl extends ServiceImpl<KnownsRssMapper, KnownsRss> implements KnownsRssService {

    @Autowired
    private KnownsRssCompose knownsRssCompose;

    @Autowired
    private KnownsRssMapper knownsRssMapper;

    @Override
    public Result add(KnownsRssDTO knownsRssDTO) {
        KnownsRss knownsRss = knownsRssCompose.componse(knownsRssDTO);
        knownsRssMapper.insert(knownsRss);
        return Result.OK();
    }

    @Override
    public PageResult<KnownsRss> pagable(KnownsRssPageDTO knownsRssPageDTO) {
        PageHelper.startPage(knownsRssPageDTO.getPage(), knownsRssPageDTO.getSize());
        KnownsRssQuery knownsRssQuery = new KnownsRssQuery();
        List<KnownsRss> knownsRssList = knownsRssMapper.query(knownsRssQuery);
        PageInfo<KnownsRss> pageInfo = new PageInfo(knownsRssList);
        return new PageResult<>(knownsRssList, (int) pageInfo.getTotal());
    }
}
