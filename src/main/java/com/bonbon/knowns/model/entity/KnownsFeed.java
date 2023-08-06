package com.bonbon.knowns.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */
public class KnownsFeed implements Serializable {


    private Long id;

    /**
     * rss_id
     */
    private Long rssId;

    /**
     * 标题
     */
    private String title;

    /**
     * 链接
     */
    private String link;

    /**
     * 作者
     */
    private String author;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 概要
     */
    private String summary;

    /**
     * 内容
     */
    private String content;

    /**
     * 附件
     */
    private String enclosures;

    /**
     * 来源类型 0 rss解析, 1 用户上传
     */
    private String sourceType;

    /**
     * rss id， user_id
     */
    private Integer sourceId;

    /**
     * feed的状态
     */
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRssId() {
        return rssId;
    }

    public void setRssId(Long rssId) {
        this.rssId = rssId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEnclosures() {
        return enclosures;
    }

    public void setEnclosures(String enclosures) {
        this.enclosures = enclosures;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "KnownsFeed{" +
            "id=" + id +
            ", rssId=" + rssId +
            ", title=" + title +
            ", link=" + link +
            ", author=" + author +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
            ", summary=" + summary +
            ", content=" + content +
            ", enclosures=" + enclosures +
            ", sourceType=" + sourceType +
            ", sourceId=" + sourceId +
            ", status=" + status +
        "}";
    }
}
