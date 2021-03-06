package br.com.lelo.twclient.domain;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_search")
    private Long id;

    @NotNull
    @Column(name = "nm_hashtag")
    private String hashtag;

    @NotNull
    @Column(name = "dt_created")
    private Date creationDate;

    @Column(name = "dt_execution")
    private Date executionDate;

    @Column(name = "dt_expiration_cache")
    private LocalDateTime expiration;

    @OneToMany(mappedBy = "search", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tweet> tweets;

    @Column(name = "fg_twitter_info")
    private boolean twitterInfo;

    public Search() {

    }

    public Search(String hashtag) {
        this.hashtag = hashtag;
        this.creationDate = new Date();
        this.tweets = Lists.newArrayList();
    }

    public void addTweet(Tweet item) {
        if (item != null) {
            if (this.tweets == null) {
                this.tweets = Lists.newArrayList();
            }
            this.tweets.add(item);
            item.setSearch(this);
        }
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public boolean isTwitterInfo() {
        return twitterInfo;
    }

    public void setTwitterInfo(boolean twitterInfo) {
        this.twitterInfo = twitterInfo;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return Objects.equal(id, search.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
