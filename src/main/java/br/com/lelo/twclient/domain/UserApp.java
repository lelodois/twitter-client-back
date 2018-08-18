package br.com.lelo.twclient.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserApp {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;

    @Column(name = "nm_login")
    private String login;

    @Column(name = "dt_last_login")
    private Date lastLogin;

    @Column(name = "nm_password")
    private String password;

    @Transient
    private transient String token;

    public UserApp() {
    }

    public UserApp(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserApp(Long id) {
        this.id = id;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
