package com.bonbon.knowns.mapper;

import com.bonbon.knowns.model.entity.KnownsUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonbon.knowns.model.query.KnownsUserQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rocky
 * @since 2023-08-13
 */
@Mapper
public interface KnownsUserMapper extends BaseMapper<KnownsUser> {

    /**
     * 查询
     * @param knownsUserQuery
     * @return
     */
    KnownsUser query(KnownsUserQuery knownsUserQuery);
}
