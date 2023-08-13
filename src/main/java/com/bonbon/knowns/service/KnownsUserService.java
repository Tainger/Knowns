package com.bonbon.knowns.service;

import com.bonbon.knowns.model.entity.KnownsUser;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rocky
 * @since 2023-08-13
 */
@Validated
public interface KnownsUserService extends IService<KnownsUser> {

}
