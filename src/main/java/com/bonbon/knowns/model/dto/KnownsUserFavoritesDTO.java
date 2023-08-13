package com.bonbon.knowns.model.dto;

    import lombok.Data;
    import org.apache.kafka.common.protocol.types.Field;

    import java.util.Date;
    import java.io.Serializable;

/**
 * <p>
 * 用户收藏表
 * </p>
 *
 * @author rocky
 * @since 2023-08-11
 */

@Data
public class KnownsUserFavoritesDTO implements Serializable {

    /**
    * feed_id
    */
    private String url;

    /**
    * 备注
    */
    private String remark;

}
