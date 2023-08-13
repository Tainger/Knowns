package com.bonbon.knowns.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.bonbon.knowns.common.repsonse.Result;
import com.bonbon.knowns.model.dto.KnownsUserDTO;
import com.bonbon.knowns.model.dto.KnownsUserFavoritesDTO;
import com.bonbon.knowns.model.entity.KnownsUserFavorites;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.validation.Valid;

import com.bonbon.knowns.model.vo.Auth;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * 用户收藏表 服务类
 * </p>
 *
 * @author rocky
 * @since 2023-08-11
 */
@Validated
public interface KnownsUserFavoritesService extends IService<KnownsUserFavorites> {

    /**
     * 用户收藏
     * @param knownsUserFavoritesDTO
     */
    Result favorite(KnownsUserFavoritesDTO knownsUserFavoritesDTO);

    /**
     * 用户toekn校验
     * @param knownsUserDTO
     * @return
     */
    Result login(KnownsUserDTO knownsUserDTO);
}
