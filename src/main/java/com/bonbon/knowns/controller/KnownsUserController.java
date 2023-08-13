package com.bonbon.knowns.controller;

import com.bonbon.knowns.service.KnownsUserService;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rocky
 * @since 2023-08-13
 */
@Validated
@RestController
@RequestMapping("/knownsUser")
public class KnownsUserController {

    /**
    * <p>
    * KnownsUserService
    * </p>
    */
    @Resource
    private KnownsUserService knownsUserService;


}
