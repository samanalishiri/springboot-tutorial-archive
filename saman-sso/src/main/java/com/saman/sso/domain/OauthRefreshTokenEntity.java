package com.saman.sso.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "oauth_refresh_token", schema = "sso")
public class OauthRefreshTokenEntity {
    private Integer id;
    private String tokenId;
    private Integer token;
    private Integer authentication;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "token_id", nullable = true, length = 255)
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    @Basic
    @Column(name = "token", nullable = true)
    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    @Basic
    @Column(name = "authentication", nullable = true)
    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OauthRefreshTokenEntity that = (OauthRefreshTokenEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tokenId, that.tokenId) &&
                Objects.equals(token, that.token) &&
                Objects.equals(authentication, that.authentication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tokenId, token, authentication);
    }
}
