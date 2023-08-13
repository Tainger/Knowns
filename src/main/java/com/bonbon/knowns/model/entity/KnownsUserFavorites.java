package com.bonbon.knowns.model.entity;

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
public class KnownsUserFavorites implements Serializable {


    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * feed_id
     */
    private Long feedId;

    private Date createTime;

    private Date modifyTime;

    /**
     * 备注
     */
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFeedId() {
        return feedId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "KnownsUserFavorites{" +
            "id=" + id +
            ", userId=" + userId +
            ", feedId=" + feedId +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            ", remark=" + remark +
        "}";
    }
}
