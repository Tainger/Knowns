package com.bonbon.knowns.service;

import com.bonbon.knowns.common.repsonse.PageResult;
import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.model.dto.KnownsRssPageDTO;
import com.bonbon.knowns.model.entity.KnownsRss;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
@Validated
public interface KnownsRssService extends IService<KnownsRss> {

    /**
     * 新增rss
     * @param knownsRssDTO
     */
    Result add(KnownsRssDTO knownsRssDTO);

    /**
     * 分页查询
     * @param knownsRssPageDTO
     * @return
     */
    PageResult<KnownsRss> pagable(KnownsRssPageDTO knownsRssPageDTO);
}
