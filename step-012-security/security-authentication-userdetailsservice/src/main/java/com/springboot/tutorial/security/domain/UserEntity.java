package com.springboot.tutorial.security.domain;

import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity(name = UserEntity.ENTITY_NAME)
@Table(name = UserEntity.TABLE_NAME, schema = "PUBLIC")
@Component
public class UserEntity implements UserDetails {

    public static final String TABLE_NAME = "USERS";
    public static final String ENTITY_NAME = "userEntity";
    public static final String UNDER_LINE = "_";
    public static final String ID_SUFFIX = UNDER_LINE + "ID";
    public static final String SEQ_SUFFIX = UNDER_LINE + "SEQ";
    public static final String GEN_SUFFIX = UNDER_LINE + "GEN";

    @Id
    @Column(name = TABLE_NAME + ID_SUFFIX, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME + GEN_SUFFIX)
    @SequenceGenerator(name = TABLE_NAME + GEN_SUFFIX, sequenceName = TABLE_NAME + SEQ_SUFFIX)
    private Long id;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWD", nullable = false)
    private String password;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "ENABLED")
    @Type(type = "boolean")
    private boolean enabled = true;

    @Column(name = "NON_EXPIRED")
    @Type(type = "boolean")
    private boolean accountNonExpired = true;

    @Column(name = "NON_LOCKED")
    @Type(type = "boolean")
    private boolean accountNonLocked = true;

    @Column(name = "PASSWORD_NON_EXPIRED")
    @Type(type = "boolean")
    private boolean credentialsNonExpired = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = UserEntity.TABLE_NAME + "_" + AuthorityEntity.TABLE_NAME,
            joinColumns = @JoinColumn(name = UserEntity.TABLE_NAME + UserEntity.ID_SUFFIX, referencedColumnName = UserEntity.TABLE_NAME + UserEntity.ID_SUFFIX),
            inverseJoinColumns = @JoinColumn(name = AuthorityEntity.TABLE_NAME + AuthorityEntity.ID_SUFFIX, referencedColumnName = AuthorityEntity.TABLE_NAME + AuthorityEntity.ID_SUFFIX))
    private List<AuthorityEntity> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public List<AuthorityEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }
}
