package com.bonbon.knowns.model.dto;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import lombok.Data;

    import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rocky
 * @since 2023-08-05
 */

@Data
public class KnownsRssDTO implements Serializable {

    private Long id;

    private String url;

    private String title;

    private String link;

    private Date updated;

    private String author;

    private String subtitle;

    private String version;

    private String userTitle;

    private String httpEtag;

    private String httpLastModified;

    private String dataHash;

    private String stale;

    private Date updatesEnabled;

    private Date lastUpdated;

    private String added;

    private String lastException;

    /**
    * 0 官网提供， 1 开源提供， 2 网站生成
    */
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getHttpEtag() {
        return httpEtag;
    }

    public void setHttpEtag(String httpEtag) {
        this.httpEtag = httpEtag;
    }

    public String getHttpLastModified() {
        return httpLastModified;
    }

    public void setHttpLastModified(String httpLastModified) {
        this.httpLastModified = httpLastModified;
    }

    public String getDataHash() {
        return dataHash;
    }

    public void setDataHash(String dataHash) {
        this.dataHash = dataHash;
    }

    public String getStale() {
        return stale;
    }

    public void setStale(String stale) {
        this.stale = stale;
    }

    public Date getUpdatesEnabled() {
        return updatesEnabled;
    }

    public void setUpdatesEnabled(Date updatesEnabled) {
        this.updatesEnabled = updatesEnabled;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getLastException() {
        return lastException;
    }

    public void setLastException(String lastException) {
        this.lastException = lastException;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "KnownsRssDTO{" +
                "id=" + id +
                ", url=" + url +
                ", title=" + title +
                ", link=" + link +
                ", updated=" + updated +
                ", author=" + author +
                ", subtitle=" + subtitle +
                ", version=" + version +
                ", userTitle=" + userTitle +
                ", httpEtag=" + httpEtag +
                ", httpLastModified=" + httpLastModified +
                ", dataHash=" + dataHash +
                ", stale=" + stale +
                ", updatesEnabled=" + updatesEnabled +
                ", lastUpdated=" + lastUpdated +
                ", added=" + added +
                ", lastException=" + lastException +
                ", type=" + type +
        "}";
    }
}
