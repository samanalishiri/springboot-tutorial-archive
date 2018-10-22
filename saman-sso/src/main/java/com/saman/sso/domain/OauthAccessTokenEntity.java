package com.saman.sso.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "oauth_access_token", schema = "sso")
public class OauthAccessTokenEntity {
    private String authenticationId;
    private String tokenId;
    private Integer token;
    private String userName;
    private String clientId;
    private Long authentication;
    private String refreshToken;

    @Id
    @Column(name = "authentication_id", nullable = false, length = 255)
    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
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
    @Column(name = "user_name", nullable = true, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "client_id", nullable = true, length = 255)
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "authentication", nullable = true)
    public Long getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Long authentication) {
        this.authentication = authentication;
    }

    @Basic
    @Column(name = "refresh_token", nullable = true, length = 255)
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OauthAccessTokenEntity that = (OauthAccessTokenEntity) o;
        return Objects.equals(authenticationId, that.authenticationId) &&
                Objects.equals(tokenId, that.tokenId) &&
                Objects.equals(token, that.token) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(authentication, that.authentication) &&
                Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticationId, tokenId, token, userName, clientId, authentication, refreshToken);
    }
}
