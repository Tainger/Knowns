package com.bonbon.knowns.controller;

import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.service.KnownsRssService;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
@Validated
@RestController
@RequestMapping("/api/rss")
public class KnownsRssController {

    /**
    * <p>
    * KnownsRssService
    * </p>
    */
    @Resource
    private KnownsRssService knownsRssService;


    @PostMapping("/add")
    public Result add(@RequestBody KnownsRssDTO knownsRssDTO) {
        return knownsRssService.add(knownsRssDTO);
    }

}
