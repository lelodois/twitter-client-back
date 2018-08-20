package br.com.lelo.twclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    @Column(name = "id_tweet")
    private Long id;

    @NotNull
    @Column(name = "id_tweet_tw")
    private Long idTweet;

    @NotNull
    @Column(name = "dt_created")
    private Date creationDate;

    @NotNull
    @Column(name = "nm_text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_search")
    @JsonIgnore
    private Search search;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_tw")
    private UserTweet userTweet;

    public UserTweet getUserTweet() {
        return userTweet;
    }

    public void setUserTweet(UserTweet userTweet) {
        this.userTweet = userTweet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTweet() {
        return idTweet;
    }

    public void setIdTweet(Long idTweet) {
        this.idTweet = idTweet;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

}
