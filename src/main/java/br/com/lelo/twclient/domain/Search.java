package br.com.lelo.twclient.domain;

import com.google.common.collect.Lists;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Search {

    @Id
    @GeneratedValue
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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserApp user;

    @OneToMany(mappedBy = "search", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tweet> tweets = Lists.newArrayList();

    public Search() {

    }

    public Search(String hashtag, Long user) {
        this.hashtag = hashtag;
        this.user = new UserApp(user);
        this.setCreationDate(new Date());
    }

    public void addTweet(Tweet item) {
        this.tweets.add(item);
        item.setSearch(this);
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

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

}
