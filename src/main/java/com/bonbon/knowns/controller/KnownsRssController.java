package com.bonbon.knowns.controller;

import com.bonbon.knowns.common.repsonse.PageResult;
import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.model.dto.KnownsRssDTO;
import com.bonbon.knowns.model.dto.KnownsRssPageDTO;
import com.bonbon.knowns.model.entity.KnownsRss;
import com.bonbon.knowns.service.KnownsRssService;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
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


    /**
     * 新增数据
     *
     * @param knownsRssDTO
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody KnownsRssDTO knownsRssDTO) {
        return knownsRssService.add(knownsRssDTO);
    }


    /**
     * 分页数据
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/pagable")
    public PageResult<KnownsRss> pagable(@RequestParam(value = "page") int page,
                                         @RequestParam(value = "size") int size) {
        KnownsRssPageDTO knownsRssPageDTO = new KnownsRssPageDTO();
        knownsRssPageDTO.setPage(page);
        knownsRssPageDTO.setSize(size);
        return knownsRssService.pagable(knownsRssPageDTO);
    }
}
