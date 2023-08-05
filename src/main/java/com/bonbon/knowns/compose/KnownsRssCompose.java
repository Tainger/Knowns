package com.bonbon.knowns.compose;

import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.model.entity.KnownsRss;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author jiazhiyuan
 * @date 2023/8/5 10:56 AM
 */

@Component
public class KnownsRssCompose {


    /**
     *
     * @param knownsRssDTO
     * @return
     */
    public KnownsRss componse(KnownsRssDTO knownsRssDTO) {
        KnownsRss knownsRss = new KnownsRss();
        BeanUtils.copyProperties(knownsRssDTO, knownsRss);
        return knownsRss;
    }
}



    
