package com.bonbon.knowns.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.model.dto.KnownsUserDTO;
import com.bonbon.knowns.model.dto.KnownsUserFavoritesDTO;
import com.bonbon.knowns.model.vo.Auth;
import com.bonbon.knowns.service.KnownsUserFavoritesService;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户收藏表 前端控制器
 * </p>
 *
 * @author rocky
 * @since 2023-08-11
 */
@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {

    /**
    * <p>
    * KnownsUserFavoritesService
    * </p>
    */
    @Resource
    private KnownsUserFavoritesService knownsUserFavoritesService;


    /**
     * 用户登陆
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody KnownsUserDTO knownsUserDTO) {
        return knownsUserFavoritesService.login(knownsUserDTO);
    }

    /**
     * 用户收藏
     * @return
     */
    @PostMapping("/favorite/pick")
    public Result favoritePick(@RequestBody KnownsUserFavoritesDTO knownsUserFavoritesDTO) {
        return  knownsUserFavoritesService.favorite(knownsUserFavoritesDTO);
    }

    /**
     * 用户取消收藏
     * @return
     */
    @PostMapping("/favorite/unpick")
    public Result favoriteUnpick(@RequestBody KnownsUserFavoritesDTO knownsUserFavoritesDTO) {
        return  knownsUserFavoritesService.favorite(knownsUserFavoritesDTO);
    }


    /**
     * 用户收藏查询
     * @return
     */
    @PostMapping("/favorite/list")
    public Result favorite(@RequestBody KnownsUserFavoritesDTO knownsUserFavoritesDTO) {
        return  knownsUserFavoritesService.favorite(knownsUserFavoritesDTO);
    }
}
