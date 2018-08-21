package br.com.lelo.twclient.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class TweetUser {

    @Id
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "nr_followers")
    private Long followersCount;

    @Column(name = "nm_location")
    private String location;

    @Column(name = "nm_lang")
    private String language;

    @Column(name = "nm_name")
    @NotNull
    private String name;

    @NotNull
    @Column(name = "dt_created")
    private LocalDateTime creationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Long followersCount) {
        this.followersCount = followersCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TweetUser tweetUser = (TweetUser) o;
        return Objects.equals(id, tweetUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
