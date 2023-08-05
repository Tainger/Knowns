package com.bonbon.knowns.service.impl;

import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.compose.KnownsRssCompose;
import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.model.entity.KnownsRss;
import com.bonbon.knowns.mapper.KnownsRssMapper;
import com.bonbon.knowns.service.KnownsRssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Result<Void> add(KnownsRssDTO knownsRssDTO) {
        KnownsRss knownsRss = knownsRssCompose.componse(knownsRssDTO);
        knownsRssMapper.insert(knownsRss);
        return Result.OK();
    }
}
