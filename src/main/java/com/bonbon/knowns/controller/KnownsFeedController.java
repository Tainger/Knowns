package com.bonbon.knowns.controller;

import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.service.KnownsFeedService;
import javax.annotation.Resource;

import com.rometools.rome.io.FeedException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
@RestController
@RequestMapping("/api/feed")
public class KnownsFeedController {

    /**
    * <p>
    * KnownsFeedService
    * </p>
    */
    @Resource
    private KnownsFeedService knownsFeedService;


    /**
     * 获取首页服务
     * @param knownsRssDTO
     * @return
     */
    @GetMapping("/index")
    public Result index(@RequestBody KnownsRssDTO knownsRssDTO) {
        return knownsFeedService.add(knownsRssDTO);
    }

    /**
     * 新增KnownsRssDTO
     * @param knownsRssDTO
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody KnownsRssDTO knownsRssDTO) {
        return knownsFeedService.add(knownsRssDTO);
    }


    /**
     * 更新feed
     * @param knownsRssDTO
     * @return
     */
    @PostMapping("/refresh")
    public Result refresh() throws FeedException, IOException {
        return knownsFeedService.refresh();
    }

}
